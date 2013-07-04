package com.aironman.core.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.aironman.core.dao.JuntasOrdinariasDao;
import com.aironman.core.pojos.JuntasOrdinarias;

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
	public boolean addJuntasOrdinarias(final JuntasOrdinarias value) {
		// TODO Auto-generated method stub
		juntasOrdinariasDao.addJuntasOrdinarias(value);
		return true;
	}

	@Override
	@Secured("ROLE_FINCA")
	public List<JuntasOrdinarias> getJuntasOrdinariasByFecha(String fecha) {
		// TODO Auto-generated method stub
		return juntasOrdinariasDao.getJuntasOrdinariasByFecha(fecha);
	}

}
