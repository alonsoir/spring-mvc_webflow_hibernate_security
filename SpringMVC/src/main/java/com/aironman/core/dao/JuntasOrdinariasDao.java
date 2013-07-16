package com.aironman.core.dao;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.aironman.core.pojos.JuntasOrdinarias;

public interface JuntasOrdinariasDao extends
		AbstractDao<JuntasOrdinarias, Long> {

	JuntasOrdinarias addJuntasOrdinarias(final JuntasOrdinarias value)
			throws DataAccessException;

	List<JuntasOrdinarias> getJuntasOrdinariasByFecha(String fecha)
			throws DataAccessException;
}
