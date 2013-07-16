package com.aironman.core.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.aironman.core.dao.MorosasDao;
import com.aironman.core.pojos.Moroso;
import com.aironman.core.pojos.ServiceResponse;

@Service("morososService")
@Transactional(readOnly = true)
public class MorososServiceImpl implements MorosasService {

	// lo suyo es configurar un interceptor que haga el log de cada llamada a
	// cada metodo
	private static final Logger LOG = LoggerFactory
			.getLogger(MorososServiceImpl.class);

	@Autowired
	private MorosasDao morosasDao;

	@Override
	@Transactional(readOnly = false)
	public ServiceResponse addMoroso(final Moroso moroso) {

		ServiceResponse response = new ServiceResponse();
		StringBuilder sb = new StringBuilder();
		try {
			Moroso morosoExistente = morosasDao.getMorosoByCriterion(
					moroso.getNifCif(), moroso.getTlffijo(),
					moroso.getTlfmovil());
			if (morosoExistente != null) {
				sb.append("Datos del moroso modificados.");
				LOG.info(sb.toString());
				response.setMensaje(sb.toString());
				moroso.setIdMoroso(morosoExistente.getIdMoroso());
			} else {
				LOG.info("Moroso nuevo para crear...");
				sb.append("Datos del moroso guardados.");
				response.setMensaje(sb.toString());
			}
			Moroso morosoInsertado = morosasDao.addMoroso(moroso);
			response.setEstado(morosoInsertado != null ? true : false);
			response.setIdGenerado(morosoInsertado.getIdMoroso());
		} catch (Exception e) {
			LOG.info(
					"ATENCION, excepcion a la hora de intentar a–adir un moroso a la bd. ",
					e);
			response.setEstado(Boolean.FALSE);
			response.setMensaje("ATENCION, ha ocurrido un problema a la hora de insertar los datos de un moroso.");

		}
		return response;

	}

	@Override
	public Moroso getMorosoByClave(final String nifcif) {

		Moroso moroso = null;
		try {
			moroso = morosasDao.getMorosoByClave(nifcif);
		} catch (Exception e) {
			LOG.info(
					"ATENCION, excepcion a la hora de intentar recuperar el moroso por clave {0}",
					nifcif, e);
		}
		return moroso;
	}

	@Override
	public Moroso getMorosoByCriterion(String nifcif, String tlffijo,
			String tlfmovil) {
		// TODO Auto-generated method stub
		Moroso moroso = null;
		try {
			moroso = morosasDao.getMorosoByCriterion(nifcif, tlffijo, tlfmovil);
		} catch (Exception e) {
			LOG.info(
					"ATENCION, excepcion a la hora de intentar recuperar el moroso por criterion. nifcif : {0} tlffijo: {1} tlfmovil: {2}",
					nifcif, tlffijo, tlfmovil, e);
		}
		return moroso;
	}

}
