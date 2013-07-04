package com.aironman.core.service;

import java.io.File;
import java.io.FileOutputStream;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.export.ooxml.JRDocxExporter;
import net.sf.jasperreports.engine.export.ooxml.JRDocxExporterParameter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.aironman.core.configuration.CertificadosBean;
import com.aironman.core.configuration.CertificadosPropertiesConfig;
import com.aironman.core.pojos.DatosDemanda;
import com.aironman.core.pojos.InfoCertificadoDeuda;

@Service("certificadosService")
@Transactional(readOnly = true)
public class CertificadosServiceImpl implements CertificadosService {

	private static final Logger LOG = LoggerFactory
			.getLogger(CertificadosServiceImpl.class);

	private static String SQL_CERTIFICADO_USER_IDDEUDA = "select mor.cp as CP_MOROSO,"
			+ "mor.direccion as DIRECCION_MOROSO,"
			+ "mor.nifcif as NIFCIF_MOROSO,"
			+ "mor.nombre AS NOMBRE_MOROSO,"
			+ "mor.telefono AS TLF_MOROSO,"
			+ "mor.ciudad AS CIUDAD_MOROSO,"
			+ "comunidad.ciudad AS CIUDAD_COMUNIDAD,"
			+ "comunidad.nombrecomunidad AS NOMBRE_COMUNIDAD,"
			+ "comunidad.direccion AS DIRECCION_COMUNIDAD,"
			+ "comunidad.adminfincas AS ADMIN_COMUNIDAD,"
			+ "comunidad.presidente AS PRESI_COMUNIDAD,"
			+ "juntas.fechacelebracion AS FECHA_CELEBRACION_JUNTAS,"
			+ "juntas.textolibre AS TEXTO_LIBRE_JUNTAS "
			+ "from users as u, comunidadvecinos as comunidad, viviendascondeudas as vivi,moroso as mor,juntas_ordinarias as juntas "
			+ "where u.user_id=comunidad.usuario_user_id				AND "
			+ "comunidad.junta_idjunta = juntas.idjunta              AND "
			+ "comunidad.idcomunidad  = vivi.comunidad_idcomunidad AND "
			+ "mor.idmoroso = vivi.moroso_idmoroso                   AND "
			+ "u.username= ?								AND " + "vivi.iddeuda= ?";

	private static String SQL_CERTIFICADO_USER_ONLY = "SELECT VIV.montante as MONTANTE, "
			+ "H.RUTAFISICADEMANDA AS URL_CERTIFICADO, "
			+ " U.USERNAME as usuario, MOR.nombre as nombre_moroso, "
			+ "COM.nombrecomunidad as nombre_comunidad, "
			+ "COM.direccion as direccion_comunidad, "
			+ "COM.REFCATASTRAL as referencia_catastral, "
			+ "D.TIPO AS ESTADO_DEMANDA "
			+ "FROM USERS U, "
			+ "JUNTAS_ORDINARIAS JUNTA, "
			+ "COMUNIDADVECINOS COM, "
			+ "VIVIENDASCONDEUDAS VIV, "
			+ "MOROSO MOR, "
			+ "DEMANDAS D, "
			+ "historico_demandas_viviendas H "
			+ "WHERE D.IDDEMANDA=H.DEMANDA_IDDEMANDA "
			+ "AND U.USER_ID=COM.USUARIO_USER_ID "
			+ "AND COM.junta_idjunta=JUNTA.idjunta "
			+ "AND COM.idcomunidad=VIV.comunidad_idcomunidad "
			+ "AND MOR.IDMOROSO=VIV.moroso_idmoroso "
			+ "AND D.usuario_user_id=U.USER_ID "
			+ "AND D.iddemanda = H.demanda_iddemanda "
			+ "AND H.deudora_iddeuda=VIV.IDDEUDA " + "AND U.username=?;";

	private static final String PREFIJO_NOMBRE_CERTIFICADO = "certificadoDeuda-";
	private static final String SUFIJO_NOMBRE_CERTIFICADO_PDF = ".pdf";
	private static final String SUFIJO_NOMBRE_CERTIFICADO_DOC = ".doc";
	private static final String SUFIJO_NOMBRE_CERTIFICADO_HTML = ".htm";
	private static final String NORMA_ISO = "ISO-8859-15";
	private static final String PARAMETRO_CERT_DEUDA = "IDDEUDA";
	private static final String PARAMETRO_USERNAME = "USERNAME";
	private static Connection conn = null;
	private JasperReport plantillaReport;

	@Autowired
	private CertificadosPropertiesConfig certificadosProperties;

	@PostConstruct
	public void initService() {

		LOG.info("CertificadosServiceImpl.initService. Inicializando plantilla...");
		CertificadosBean beanProperties = certificadosProperties
				.getCertificadosProperties();

		LOG.info("beanProperties: " + beanProperties.toString());

		String rutaPlantilla = beanProperties.getRUTA_PLANTILLA();

		try {
			plantillaReport = JasperCompileManager.compileReport(rutaPlantilla);
			LOG.info("Plantilla compilada...");
		} catch (JRException e) {
			// TODO Auto-generated catch block
			LOG.info("ATENCION! No ha sido posible compilar la plantilla.", e);
		}

	}

	@Override
	public String generarCertificadoCelebracionJunta(Long idDeuda,
			String username) {

		// TODO esto es mierda, devolviendo en caso de error una cadena con
		// ERROR!! puedes mejorar esto...
		if (idDeuda == null) {
			LOG.info("CertificadosServiceImpl.generarCertificadoCelebracionJunta. idDeuda no puede ser nulo para generar el certificado!.");
			return "ERROR idDeuda no puede ser nulo para generar el certificado.";
		}
		CertificadosBean beanProperties = certificadosProperties
				.getCertificadosProperties();
		LOG.info("beanProperties: " + beanProperties.toString());

		String dirDespliegue = beanProperties.getDIRECTORIO_DESPLIEGUE().trim();
		String rutaConexiondb = beanProperties.getRUTA_CONEXION_DB().trim();
		String passdb = beanProperties.getPASS_DB().trim();
		String userdb = beanProperties.getUSUARIO_DB().trim();

		// los metodos de StringBuilder son non synchronized por lo tanto mas
		// rapidos que su contrapartida StringBuffer que si son sincronizados
		// pero en un metodo local no deben dar problemas...
		StringBuilder sbPdf = new StringBuilder();
		StringBuilder sbDoc = new StringBuilder();
		StringBuilder sbHtml = new StringBuilder();
		StringBuilder sbPdfSinRuta = new StringBuilder();
		try {
			LOG.info("rutaConexiondb: " + rutaConexiondb);
			LOG.info("userdb: " + userdb);
			LOG.info("passdb: " + passdb);

			conn = DriverManager.getConnection(rutaConexiondb, userdb, passdb);
			conn.setAutoCommit(false);

			Map<String, Object> parameters = new HashMap<String, Object>();

			LOG.info("generarCertificadoCelebracionJunta. Convirtiendo valor de idDeuda:"
					+ idDeuda + " a un Long. username: " + username);

			parameters.put(PARAMETRO_CERT_DEUDA, Long.valueOf(idDeuda));
			parameters.put(PARAMETRO_USERNAME, username);
			JasperPrint print = JasperFillManager.fillReport(plantillaReport,
					parameters, conn);

			sbPdf.append(dirDespliegue);
			sbDoc.append(dirDespliegue);
			sbHtml.append(dirDespliegue);

			sbPdf.append(PREFIJO_NOMBRE_CERTIFICADO);
			sbDoc.append(PREFIJO_NOMBRE_CERTIFICADO);
			sbHtml.append(PREFIJO_NOMBRE_CERTIFICADO);
			sbPdfSinRuta.append(PREFIJO_NOMBRE_CERTIFICADO);

			sbPdf.append(idDeuda);
			sbDoc.append(idDeuda);
			sbHtml.append(idDeuda);
			sbPdfSinRuta.append(idDeuda);

			sbPdf.append(SUFIJO_NOMBRE_CERTIFICADO_PDF);
			sbDoc.append(SUFIJO_NOMBRE_CERTIFICADO_DOC);
			sbHtml.append(SUFIJO_NOMBRE_CERTIFICADO_HTML);
			sbPdfSinRuta.append(SUFIJO_NOMBRE_CERTIFICADO_PDF);

			LOG.info("Vamos a procurar generar el pdf en la ruta: "
					+ sbPdf.toString());
			LOG.info("Vamos a procurar generar el sbHtml en la ruta: "
					+ sbHtml.toString());

			LOG.info("Vamos a procurar generar el doc en la ruta: "
					+ sbDoc.toString());

			JasperExportManager.exportReportToPdfFile(print, sbPdf.toString());

			// quieres crear el informe en html, que salga en una pesta–a del
			// navegador
			JasperExportManager
					.exportReportToHtmlFile(print, sbHtml.toString());

			JRDocxExporter exporter = new JRDocxExporter();

			File archivo = new File(sbDoc.toString());

			FileOutputStream os = new FileOutputStream(archivo);

			exporter.setParameter(JRDocxExporterParameter.JASPER_PRINT, print);

			exporter.setParameter(JRDocxExporterParameter.CHARACTER_ENCODING,
					NORMA_ISO);
			exporter.setParameter(JRDocxExporterParameter.OUTPUT_STREAM, os);

			exporter.exportReport();

			os.close();

			LOG.info("Se deberia haber generado el pdf en " + sbPdf.toString());

			LOG.info("Se deberia haber generado el doc en " + sbDoc.toString());

			LOG.info("Se deberia haber generado el HTML en "
					+ sbHtml.toString());

		} catch (Exception e) {
			LOG.info("ERROR al conectar con la bd para generar el pdf. ", e);
			return "ERROR al conectar con la bd para generar el pdf. ";
		} finally {
			/*
			 * Cleanup antes de salir
			 */
			try {
				if (conn != null) {
					// // conn.rollback();
					// // LOG.info("ROLLBACK EJECUTADO")
					LOG.info("CertificadoService. Tratando de cerrar la conexion con la bd...");
					conn.close();
					LOG.info("CertificadoService. Conexion con la bd cerrada.");
				}
			} catch (Exception e) {
				LOG.info(
						"ERROR al cerrar la conexion con la bd al cerrar la conexion. ",
						e);
				return "ERROR al cerrar la conexion con la bd al cerrar la conexion";
			}
		}
		// ruta fisica de despliegue del certificado en .HTML. Igual debo crear
		// un pojo que contenga todas las rutas fisicas generadas
		// DEBERIA DEVOLVER TODO EN UN POJO?
		return sbPdfSinRuta.toString();
	}

	@Override
	public InfoCertificadoDeuda traerInfoParaCertificado(Long idDeuda,
			String username) {

		Connection conn = null;
		InfoCertificadoDeuda info = null;

		if (idDeuda == null) {
			info = new InfoCertificadoDeuda();
			info.setEstado("KO");
			return info;
		}

		try {
			CertificadosBean beanProperties = certificadosProperties
					.getCertificadosProperties();

			LOG.info("beanProperties: " + beanProperties.toString());

			String rutaConexiondb = beanProperties.getRUTA_CONEXION_DB().trim();
			String passdb = beanProperties.getPASS_DB().trim();
			String userdb = beanProperties.getUSUARIO_DB().trim();

			conn = DriverManager.getConnection(rutaConexiondb, userdb, passdb);
			conn.setAutoCommit(false);

			PreparedStatement ps = conn
					.prepareStatement(SQL_CERTIFICADO_USER_IDDEUDA);
			ps.setString(1, username);
			ps.setLong(2, idDeuda);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				String cp = rs.getString("CP_MOROSO");
				String direccionMoroso = rs.getString("DIRECCION_MOROSO");
				String nif = rs.getString("NIFCIF_MOROSO");
				String nombre = rs.getString("NOMBRE_MOROSO");
				String tlf = rs.getString("TLF_MOROSO");
				String ciudadMoroso = rs.getString("CIUDAD_MOROSO");
				String ciudadComunidad = rs.getString("CIUDAD_COMUNIDAD");
				String nombreComunidad = rs.getString("NOMBRE_COMUNIDAD");
				String direccionComunidad = rs.getString("DIRECCION_COMUNIDAD");
				String adminComunidad = rs.getString("ADMIN_COMUNIDAD");
				String presi = rs.getString("PRESI_COMUNIDAD");
				String fechaCelebracion = rs
						.getString("FECHA_CELEBRACION_JUNTAS");
				String textoLibre = rs.getString("TEXTO_LIBRE_JUNTAS");
				info = new InfoCertificadoDeuda(cp, direccionMoroso, nif,
						nombre, tlf, ciudadMoroso, ciudadComunidad,
						nombreComunidad, direccionComunidad, adminComunidad,
						presi, fechaCelebracion, textoLibre);
				info.setEstado("OK");

			}
			rs.close();
			ps.close();

		} catch (SQLException e) {
			LOG.info("ERROR al traerInfoParaCertificado. ", e);

		} finally {
			if (conn != null) {
				try {
					LOG.info("CertificadoService. Tratando de cerrar la conexion con la bd...");
					conn.close();
					LOG.info("CertificadoService. conexion cerrada con la bd...");
				} catch (SQLException e) {
					LOG.info(
							"ERROR Tratando de cerrar la conexion con la bd... ",
							e);
				}
			}
		}

		return info != null ? info : new InfoCertificadoDeuda();
	}

	@Override
	public List<DatosDemanda> traerCertificados(String username) {

		Connection conn = null;
		DatosDemanda info = null;
		List<DatosDemanda> listaCertificados = new ArrayList<DatosDemanda>();

		try {
			CertificadosBean beanProperties = certificadosProperties
					.getCertificadosProperties();

			LOG.info("beanProperties: " + beanProperties.toString());

			String rutaConexiondb = beanProperties.getRUTA_CONEXION_DB().trim();
			String passdb = beanProperties.getPASS_DB().trim();
			String userdb = beanProperties.getUSUARIO_DB().trim();

			conn = DriverManager.getConnection(rutaConexiondb, userdb, passdb);
			conn.setAutoCommit(false);
			PreparedStatement ps = conn
					.prepareStatement(SQL_CERTIFICADO_USER_ONLY);
			ps.setString(1, username);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {

				BigDecimal montante = rs.getBigDecimal("MONTANTE");
				String url = rs.getString("URL_CERTIFICADO");
				String nombreComunidad = rs.getString("nombre_comunidad");
				String dirComunidad = rs.getString("direccion_comunidad");
				String refCatastral = rs.getString("referencia_catastral");
				int estadoDemanda = rs.getInt("ESTADO_DEMANDA");
				String nombreMoroso = rs.getString("nombre_moroso");

				switch (DatosDemanda.ESTADO_DEMANDA.values()[estadoDemanda]) {
				case ENVIADA_A_JURIDIA: {
					DatosDemanda.ESTADO_DEMANDA _estadoDemanda = DatosDemanda.ESTADO_DEMANDA.ENVIADA_A_JURIDIA;

					// LOG.info("_estadoDemanda: " + _estadoDemanda);
					info = new DatosDemanda(url, nombreComunidad, dirComunidad,
							refCatastral, _estadoDemanda, nombreMoroso,
							montante);

				}
					break;
				case ASIGNADA_A_ABOGADO: {
					DatosDemanda.ESTADO_DEMANDA _estadoDemanda = DatosDemanda.ESTADO_DEMANDA.ASIGNADA_A_ABOGADO;

					// LOG.info("_estadoDemanda: " + _estadoDemanda);
					info = new DatosDemanda(url, nombreComunidad, dirComunidad,
							refCatastral, _estadoDemanda, nombreMoroso,
							montante);

				}
					break;
				case CERRADA: {
					DatosDemanda.ESTADO_DEMANDA _estadoDemanda = DatosDemanda.ESTADO_DEMANDA.CERRADA;

					// LOG.info("_estadoDemanda: " + _estadoDemanda);
					info = new DatosDemanda(url, nombreComunidad, dirComunidad,
							refCatastral, _estadoDemanda, nombreMoroso,
							montante);

				}
					break;
				default: {
					DatosDemanda.ESTADO_DEMANDA _estadoDemanda = DatosDemanda.ESTADO_DEMANDA.ENVIADA_A_JURIDIA;
					// LOG.info("_estadoDemanda: " + _estadoDemanda);
					info = new DatosDemanda(url, nombreComunidad, dirComunidad,
							refCatastral, _estadoDemanda, nombreMoroso,
							montante);

				}
					break;
				}

				listaCertificados.add(info);

			}
			// LOG.info("listaCertificados.size: " + listaCertificados.size());
			rs.close();
			ps.close();

		} catch (SQLException e) {
			LOG.info("ERROR al traerCertificados. ", e);

		} finally {
			if (conn != null) {
				try {
					LOG.info("CertificadoService. Tratando de cerrar la conexion con la bd...");
					conn.close();
					LOG.info("CertificadoService. conexion cerrada con la bd...");
				} catch (SQLException e) {
					LOG.info(
							"ERROR Tratando de cerrar la conexion con la bd... ",
							e);
				}
			}
		}

		return listaCertificados;

	}
}
