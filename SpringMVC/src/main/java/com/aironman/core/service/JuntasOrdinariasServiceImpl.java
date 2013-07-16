package com.aironman.core.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.aironman.core.dao.JuntasOrdinariasDao;
import com.aironman.core.pojos.JuntasOrdinarias;
import com.aironman.core.pojos.ServiceResponse;

@Service("juntasOrdinariasService")
@Transactional(readOnly = true)
public class JuntasOrdinariasServiceImpl implements JuntasOrdinariasService {

	// lo suyo es configurar un interceptor que haga el log de cada llamada a
	// cada metodo
	private static final Logger LOG = LoggerFactory
			.getLogger(JuntasOrdinariasServiceImpl.class);
	@Autowired
	private JuntasOrdinariasDao juntasOrdinariasDao;

	@Override
	@Transactional(readOnly = false)
	public ServiceResponse addJuntasOrdinarias(final JuntasOrdinarias value) {
		// menuda mierda de implementacion!

		ServiceResponse response = new ServiceResponse();
		Long idJunta = value.getIdJunta() != null ? value.getIdJunta() : null;
		LOG.info("addJuntasOrdinarias idJunta: " + idJunta);
		if (idJunta != null) {
			JuntasOrdinarias juntaExistente = juntasOrdinariasDao
					.findById(idJunta);
			LOG.info("Junta existente. Procedemos a moficarlo!.");
			response.setMensaje("DATOS DE LA JUNTA MODIFICADOS.");
			value.setIdJunta(juntaExistente.getIdJunta());
		} else {
			LOG.info("Junta no existe. Procedemos a insertarlo!.");
			response.setMensaje("DATOS DE LA JUNTA GUARDADOS.");
		}
		JuntasOrdinarias juntaCreada = juntasOrdinariasDao
				.addJuntasOrdinarias(value);
		LOG.info("juntaCreada: " + juntaCreada);
		boolean estado = juntaCreada.getIdJunta() != null ? true : false;
		response.setEstado(estado);
		response.setIdGenerado(juntaCreada.getIdJunta());
		return response;
	}

	@Override
	public List<JuntasOrdinarias> getJuntasOrdinariasByFecha(String fecha) {
		// TODO Auto-generated method stub
		return juntasOrdinariasDao.getJuntasOrdinariasByFecha(fecha);
	}

}
