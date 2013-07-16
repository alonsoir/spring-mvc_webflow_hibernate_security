package com.aironman.core.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.aironman.core.dao.FincasMorosasDao;
import com.aironman.core.pojos.ComunidadVecinos;
import com.aironman.core.pojos.Moroso;
import com.aironman.core.pojos.ServiceResponse;
import com.aironman.core.pojos.ViviendasConDeudas;

@Service("fincasMorosasService")
@Transactional(readOnly = true)
public class FincasMorosasServiceImpl implements FincasMorosasService {

	// lo suyo es configurar un interceptor que haga el log de cada llamada a
	// cada metodo
	private static final Logger LOG = LoggerFactory
			.getLogger(FincasMorosasServiceImpl.class);
	@Autowired
	private FincasMorosasDao fincasDao;

	private ViviendasConDeudas getViviendasConDeudasByClave(Long key) {

		LOG.info("getViviendasConDeudasByClave. key" + key);
		ViviendasConDeudas viviendasConDeudas = fincasDao.findById(key);
		LOG.info(viviendasConDeudas != null ? "getViviendasConDeudasByClave."
				+ viviendasConDeudas.getIdDeuda()
				: "ATENCION!! No se ha encontrado una vivienda morosa dada esa clave "
						+ key);
		return viviendasConDeudas;
	}

	@Override
	@Transactional(readOnly = false)
	public ServiceResponse addViviendasConDeudas(ViviendasConDeudas value,
			Long idComunidad, Long idMoroso) {

		ServiceResponse response = new ServiceResponse();
		StringBuilder sb = new StringBuilder();
		if (idMoroso != null) {
			LOG.info("seteado moroso...idMoroso: " + idMoroso);
			Moroso mor = new Moroso();
			mor.setIdMoroso(idMoroso);
			value.setMoroso(mor);
		} else {
			LOG.info("ATENCION. Esta finca no tiene asociado datos de ningun moroso!");
			sb.append("ATENCION. Esta finca no tiene asociado datos de ningun moroso!.");
			// response.setMensaje();
		}

		if (idComunidad != null) {
			LOG.info("seteada comunidad. idComunidad: " + idComunidad);
			ComunidadVecinos com = new ComunidadVecinos();
			com.setIdComunidad(idComunidad);
			value.setComunidad(com);
		} else {
			LOG.info("ATENCION. Esta finca no est‡ asociada a ninguna comunidad de vecinos!.");
			sb.append("ATENCION. Esta finca no est‡ asociada a ninguna comunidad de vecinos!.");
			// response.setMensaje("ATENCION. Esta finca no est‡ asociada a ninguna comunidad de vecinos!.");
		}

		Long idDeuda = value.getIdDeuda() != null ? value.getIdDeuda() : null;
		if (idDeuda != null) {
			ViviendasConDeudas viviendaExistente = getViviendasConDeudasByClave(idDeuda);
			LOG.info("vivienda existente. Procedemos a moficarla!.");
			sb.append("DATOS DE LA VIVIENDA MODIFICADOS.");

			// response.setMensaje("DATOS DE LA VIVIENDA MODIFICADOS.");
			value.setIdDeuda(viviendaExistente.getIdDeuda());
		} else {
			LOG.info("Vivienda  no existe. Procedemos a insertarlo!.");
			sb.append("DATOS DE LA VIVIENDA GUARDADOS.");
			// response.setMensaje("DATOS DE LA VIVIENDA GUARDADOS.");

		}

		ViviendasConDeudas viviendaNueva = fincasDao
				.addViviendasConDeudas(value);
		response.setEstado(viviendaNueva != null ? true : false);
		LOG.info("FincasMorosasServiceImpl.addViviendasConDeudas. idDeuda: "
				+ viviendaNueva.getIdDeuda());
		response.setIdGenerado(viviendaNueva != null ? viviendaNueva
				.getIdDeuda() : null);
		response.setMensaje(sb.toString());
		return response;
	}

}
