package com.aironman.core.dao;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import com.aironman.core.pojos.Abogados;
import com.aironman.core.pojos.Demandas;

@Repository
public class DemandasDaoImpl extends AbstractDaoImpl<Demandas, Long> implements
		DemandasDao {

	private static final Logger LOG = LoggerFactory
			.getLogger(DemandasDaoImpl.class);

	protected DemandasDaoImpl() {
		super(Demandas.class);
	}

	@Override
	public Long generarDemanda(Demandas value) throws DataAccessException {
		// TODO Auto-generated method stub
		Demandas o = (Demandas) merge(value);

		return o.getIdDemanda();

	}

	@Override
	public boolean asignarAbogadoADemanda(Demandas demanda, Abogados abogado)
			throws DataAccessException {
		// TODO Auto-generated method stub
		demanda.setAbogado(abogado);
		Object o = merge(demanda);
		// saveOrUpdate(value);
		return o != null ? true : false;

	}

}
