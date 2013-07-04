package com.aironman.core.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.aironman.core.configuration.MailBean;
import com.aironman.core.configuration.MailPropertiesConfig;
import com.aironman.core.pojos.DatosDemanda;
import com.aironman.core.pojos.InfoCertificadoDeuda;

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

	@Override
	@Transactional(readOnly = false)
	public String generarCertificadoYCrearDemanda(Long idDeuda, String username) {

		// Esto es una mierda puesto asi...
		if (idDeuda == null) {
			LOG.info("DespachoServiceImpl.generarCertificadoYCrearDemanda. idDeuda no puede ser nulo.");
			return "";
		}
		String rutaFisicaDemanda = certificadosService
				.generarCertificadoCelebracionJunta(idDeuda, username);
		crearDemandaYAsociarAUsuario(username, rutaFisicaDemanda, idDeuda);
		LOG.info("rutaFisicaDemanda: " + rutaFisicaDemanda);
		// esto esta fatal en el sentido que esto debe ir en un properties.
		// emailTo debe ser un mail de jorge

		MailBean beanProperties = mailProperties.getMailProperties();
		LOG.info("beanProperties: " + beanProperties.toString());
		String emailTo = beanProperties.getEmailTo();
		try {
			servicioMail.sendMessage(emailTo);
		} catch (Exception e) {
			LOG.error("ATENCION, NO SE HA PODIDO ENVIAR EL MAIL A " + emailTo,
					e);
		}
		return rutaFisicaDemanda;
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

	/***
	 * ESTE METODO VA A TRAER LOS CERTIFICADOS ASOCIADOS A LAS DEMANDAS CREADAS
	 */
	@Override
	public List<DatosDemanda> traerCertificadosAsociadoConDemanda(
			String username) {
		// TODO Auto-generated method stub
		return certificadosService.traerCertificados(username);
	}
}
