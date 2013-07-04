package com.aironman.core.dao;

import org.springframework.dao.DataAccessException;

import com.aironman.core.pojos.Abogados;
import com.aironman.core.pojos.Demandas;

public interface DemandasDao extends AbstractDao<Demandas, String> {

	Object generarDemanda(Demandas value) throws DataAccessException;

	boolean asignarAbogadoADemanda(Demandas value, Abogados abogado)
			throws DataAccessException;
}
