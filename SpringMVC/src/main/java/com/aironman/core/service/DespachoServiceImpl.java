package com.aironman.core.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.aironman.core.configuration.MailBean;
import com.aironman.core.configuration.MailPropertiesConfig;
import com.aironman.core.pojos.CertificadosServiceResponse;
import com.aironman.core.pojos.DatosAbogado;
import com.aironman.core.pojos.DatosDemanda;
import com.aironman.core.pojos.DatosDemandaAdmin;
import com.aironman.core.pojos.InfoCertificadoDeuda;
import com.aironman.core.pojos.ServiceResponse;

@Service("despachoService")
@Transactional(readOnly = true)
public class DespachoServiceImpl implements DespachoService {

	private static final Logger LOG = LoggerFactory
			.getLogger(DespachoServiceImpl.class);

	@Autowired
	private DemandasService demandasService;

	@Autowired
	private CertificadosService certificadosService;

	@Autowired
	private ServicioMail servicioMail;

	@Autowired
	private MailPropertiesConfig mailProperties;

	@Autowired
	private UserService userService;

	@Override
	/***
	 * no me gusta un pelo tener que romper el ppio de unica responsabilidad, o como se llame, para mi es KISS 
	 * La razon que me doy es que esto es invocado directamente desde el controller gestionado
	 * por web flow y solo puede ser invocado desde el fincas-morosas-flow lo ideal seria pedir ejecutar uno y luego el otro! en funcion 
	 * de la salida del primero.
	 */
	@Transactional(readOnly = false)
	public ServiceResponse generarCertificadoYCrearDemanda(Long idDeuda,
			String username) {

		ServiceResponse serviceResponse = new ServiceResponse();
		if (idDeuda == null) {
			LOG.info("DespachoServiceImpl.generarCertificadoYCrearDemanda. idDeuda no puede ser nulo.");
			serviceResponse.setEstado(Boolean.FALSE);
			serviceResponse
					.setMensaje("ATENCION!! Debes completar todos los pasos anteriores asegurandote de guardar para que se pueda generar el certificado.");
			return serviceResponse;
		}
		CertificadosServiceResponse certificadoResponse = certificadosService
				.generarCertificadoCelebracionJunta(idDeuda, username);
		LOG.info("certificadoResponse: " + certificadoResponse.toString());
		String rutaFisicaDemanda = certificadoResponse.getRutaPdf();
		LOG.info("rutaFisicaDemanda en pdf: " + rutaFisicaDemanda);
		crearDemandaYAsociarAUsuario(username, rutaFisicaDemanda, idDeuda);
		LOG.info("rutaFisicaDemanda despues : " + rutaFisicaDemanda);

		MailBean beanProperties = mailProperties.getMailProperties();
		LOG.info("beanProperties: Usuario que envia: "
				+ beanProperties.getUserMail()
				+ " Usuario que recibe el mail: " + beanProperties.getEmailTo());
		String emailTo = beanProperties.getEmailTo();
		try {
			servicioMail.sendMessage(emailTo);
		} catch (Exception e) {
			LOG.error("ATENCION, NO SE HA PODIDO ENVIAR EL MAIL A " + emailTo,
					e);

			serviceResponse.setEstado(Boolean.FALSE);
			serviceResponse
					.setMensaje("Se ha generado y guardado un certificado en nuestro sistema, "
							+ "pero ha ocurrido un error cuando trataba de enviarle un mail al administrador de juridia");

			return serviceResponse;
		}
		serviceResponse.setEstado(Boolean.TRUE);
		serviceResponse
				.setMensaje("Se ha generado y guardado un certificado en nuestro sistema. En breve nos pondremos en contacto con Ud.");
		return serviceResponse;
	}

	@Override
	public InfoCertificadoDeuda traerInfoParaCertificado(Long idDeuda,
			String username) {

		return certificadosService.traerInfoParaCertificado(idDeuda, username);
	}

	@Override
	public void crearDemandaYAsociarAUsuario(String username,
			String rutaFisicaDemanda, Long idDeuda) {

		Long idDemanda = (Long) demandasService.crearDemandaYAsociarAUsuario(
				username, rutaFisicaDemanda, idDeuda);
		LOG.info("idDemanda: " + idDemanda);
		demandasService.crearHistoricoDemanda(rutaFisicaDemanda, idDeuda,
				idDemanda);
	}

	@Override
	public List<DatosDemandaAdmin> traerCertificadosAdmin() {
		return certificadosService.traerCertificadosAdmin();
	}

	/***
	 * ESTE METODO VA A TRAER LOS CERTIFICADOS de un username ASOCIADOS A LAS
	 * DEMANDAS CREADAS
	 */
	@Override
	public List<DatosDemanda> traerCertificadosAsociadoConDemanda(
			String username) {
		return certificadosService.traerCertificados(username);
	}

	@Override
	@Secured("ROLE_ADMIN")
	public List<DatosAbogado> traerAbogadosDisponibles() {
		// TODO Auto-generated method stub
		return certificadosService.traerAbogadosDisponibles();
	}
}
