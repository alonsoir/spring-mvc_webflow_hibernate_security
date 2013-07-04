package com.aironman.core.dao;

import org.springframework.dao.DataAccessException;

import com.aironman.core.pojos.ComunidadVecinos;

public interface ComunidadesDao extends AbstractDao<ComunidadVecinos, String> {

	boolean addComunidadVecinos(ComunidadVecinos value)
			throws DataAccessException;

	ComunidadVecinos getComunidadVecinosByDireccion(String key)
			throws DataAccessException;

	ComunidadVecinos getComunidadVecinosByCriterion(String refCatastral,
			String direccion) throws DataAccessException;
}
