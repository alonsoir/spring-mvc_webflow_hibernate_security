package com.aironman.core.dao;

import org.springframework.dao.DataAccessException;

import com.aironman.core.pojos.Moroso;

public interface MorosasDao extends AbstractDao<Moroso, String> {

	boolean addMoroso(final Moroso value) throws DataAccessException;

	Moroso getMorosoByClave(final String nifcif) throws DataAccessException;

	Moroso getMorosoByCriterion(String nifcif, String tlffijo, String tlfmovil)
			throws DataAccessException;
}
