package com.aironman.core.dao;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import com.aironman.core.pojos.HistoricoDemandasViviendasAdeudadas;

@Repository
public class HistoricoDemandasDaoImpl extends
		AbstractDaoImpl<HistoricoDemandasViviendasAdeudadas, String> implements
		HistoricoDemandasDao {

	private static final Logger LOG = LoggerFactory
			.getLogger(HistoricoDemandasDaoImpl.class);

	protected HistoricoDemandasDaoImpl() {
		super(HistoricoDemandasViviendasAdeudadas.class);
	}

	@Override
	public void crearHistoricoDemanda(HistoricoDemandasViviendasAdeudadas value)
			throws DataAccessException {

		LOG.info("value: " + value);
		// saveOrUpdate(value);
		merge(value);
	}

}
