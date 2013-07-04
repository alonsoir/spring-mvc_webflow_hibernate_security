package com.aironman.core.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.aironman.core.dao.FincasMorosasDao;
import com.aironman.core.pojos.ComunidadVecinos;
import com.aironman.core.pojos.Moroso;
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

	@Override
	public ViviendasConDeudas getViviendasConDeudasByClave(String key) {

		ViviendasConDeudas viviendasConDeudas = fincasDao.findById(key);
		LOG.info(viviendasConDeudas.toString());
		return viviendasConDeudas;
	}

	@Override
	@Transactional(readOnly = false)
	public Long addViviendasConDeudas(ViviendasConDeudas value,
			ComunidadVecinos com, Moroso mom) {

		if (mom != null && mom.getIdMoroso() != null)
			value.setMoroso(mom);
		if (com != null && com.getRefCatastral() != null)
			value.setComunidad(com);
		fincasDao.saveOrUpdate(value);
		LOG.info("FincasMorosasServiceImpl.addViviendasConDeudas. idDeuda: "
				+ value.getIdDeuda());
		return value.getIdDeuda();
	}

}
