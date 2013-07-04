package com.aironman.core.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.aironman.core.dao.MorosasDao;
import com.aironman.core.pojos.Moroso;

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
	public boolean addMoroso(final Moroso moroso) {

		boolean retorno = false;
		try {
			Moroso morosoExistente = morosasDao.getMorosoByCriterion(
					moroso.getNifCif(), moroso.getTlffijo(),
					moroso.getTlfmovil());
			if (morosoExistente != null) {
				LOG.info("ATENCION, ya existe un moroso con esa clave o ese tlf "
						+ moroso.getNifCif()
						+ " tlfFijo: "
						+ moroso.getTlffijo()
						+ " tlfMovil: "
						+ moroso.getTlfmovil() + " Procediendo a actualizarlo.");
				// en este momento, los datos actuales que has cogido desde la
				// jsp lo tienes en el pojo moroso que te entra por cabecera de
				// metodo
				// que hacer? como poco avisar al cliente que existe ese moroso
				// y que vas a actualizar al moroso, para ello debes
				// proporcionar el id de la tabla
				moroso.setIdMoroso(morosoExistente.getIdMoroso());
			} else {
				LOG.info("Moroso nuevo para crear...");
				// esto es para forzar a crear un moroso nuevo
				moroso.setIdMoroso(null);

			}
			retorno = morosasDao.addMoroso(moroso);
		} catch (Exception e) {
			LOG.info(
					"ATENCION, excepcion a la hora de intentar a–adir un moroso a la bd. ",
					e);
			retorno = false;

		}
		return retorno;

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
					"ATENCION, excepcion a la hora de intentar recuperar el moroso por criterion nifcif : {0} tlffijo: {1} tlfmovil: {2}",
					nifcif, tlffijo, tlfmovil, e);
		}
		return moroso;
	}

}
