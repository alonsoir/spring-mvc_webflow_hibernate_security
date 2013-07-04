package com.aironman.core.dao;

import java.util.List;

import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import com.aironman.core.pojos.JuntasOrdinarias;

@Repository
public class JuntasOrdinariasDaoImpl extends
		AbstractDaoImpl<JuntasOrdinarias, String> implements
		JuntasOrdinariasDao {

	protected JuntasOrdinariasDaoImpl() {
		super(JuntasOrdinarias.class);
	}

	@Override
	public boolean addJuntasOrdinarias(final JuntasOrdinarias value)
			throws DataAccessException {
		// saveOrUpdate(value);
		merge(value);
		return true;
	}

	@Override
	public List<JuntasOrdinarias> getJuntasOrdinariasByFecha(String fecha)
			throws DataAccessException {
		// TODO Auto-generated method stub
		Criterion criterioFecha = Restrictions.like("fechaCelebracion", fecha);
		List<JuntasOrdinarias> listajuntas = findByCriteria(criterioFecha);
		return listajuntas;
	}

}
