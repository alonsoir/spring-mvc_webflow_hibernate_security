package com.aironman.core.dao;

import java.util.List;

import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import com.aironman.core.pojos.JuntasOrdinarias;

@Repository
public class JuntasOrdinariasDaoImpl extends
		AbstractDaoImpl<JuntasOrdinarias, Long> implements JuntasOrdinariasDao {

	protected JuntasOrdinariasDaoImpl() {
		super(JuntasOrdinarias.class);
	}

	@Override
	public JuntasOrdinarias addJuntasOrdinarias(final JuntasOrdinarias value)
			throws DataAccessException {
		JuntasOrdinarias o = (JuntasOrdinarias) merge(value);
		return o;
	}

	@Override
	public List<JuntasOrdinarias> getJuntasOrdinariasByFecha(String fecha)
			throws DataAccessException {
		Criterion criterioFecha = Restrictions.like("fechaCelebracion", fecha);
		List<JuntasOrdinarias> listajuntas = findByCriteria(criterioFecha);
		return listajuntas;
	}
}
