package com.aironman.core.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.aironman.core.configuration.CertificadosBean;
import com.aironman.core.configuration.CertificadosPropertiesConfig;
import com.aironman.core.dao.AbogadosDao;
import com.aironman.core.pojos.Abogados;
import com.aironman.core.pojos.DatosAbogado;

@Service("abogadosService")
@Transactional(readOnly = true)
public class AbogadosServiceImpl implements AbogadosService {

	private static final Logger LOG = LoggerFactory
			.getLogger(AbogadosServiceImpl.class);

	private static String SQL_ABOGADOS_DISPONIBLES = "select a.idabogado, a.nombre, a.apellidos, a.tlf, a.ciudad, a.cp, a.direccion "
			+ "from abogados a,users u, user_roles ur "
			+ "where a.usuario_user_id=u.user_id "
			+ "	and u.user_id = ur.user_user_id; ";

	@Autowired
	private CertificadosPropertiesConfig certificadosProperties;

	@Resource
	private AbogadosDao abogadosDao;

	@Override
	@Secured("ROLE_ADMIN")
	public List<DatosAbogado> traerAbogadosDisponibles() {
		// TODO Auto-generated method stub
		Connection conn = null;
		DatosAbogado info = null;
		List<DatosAbogado> listaDatosAbogado = new ArrayList<DatosAbogado>();

		try {
			CertificadosBean beanProperties = certificadosProperties
					.getCertificadosProperties();

			String rutaConexiondb = beanProperties.getRUTA_CONEXION_DB().trim();
			String passdb = beanProperties.getPASS_DB().trim();
			String userdb = beanProperties.getUSUARIO_DB().trim();

			conn = DriverManager.getConnection(rutaConexiondb, userdb, passdb);
			conn.setAutoCommit(false);
			PreparedStatement ps = conn
					.prepareStatement(SQL_ABOGADOS_DISPONIBLES);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Long idabogado = rs.getLong("idabogado");
				String nombre = rs.getString("nombre");
				String apellidos = rs.getString("apellidos");
				String cp = rs.getString("cp");
				String direccion = rs.getString("direccion");
				String tlfContacto = rs.getString("tlf");
				String ciudad = rs.getString("ciudad");
				info = new DatosAbogado(idabogado, nombre, apellidos, ciudad,
						cp, direccion, tlfContacto);
				listaDatosAbogado.add(info);

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
		return listaDatosAbogado;
	}

	@Override
	@Secured("ROLE_ADMIN")
	public Abogados traerAbogadoDadoId(Long idAbogado) {
		// TODO Auto-generated method stub
		return abogadosDao.findById(idAbogado);
	}

}
