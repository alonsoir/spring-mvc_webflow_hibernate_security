package com.aironman.core.service;

import org.springframework.security.access.annotation.Secured;

import com.aironman.core.pojos.Moroso;

public interface MorosasService {

	@Secured("ROLE_FINCA")
	boolean addMoroso(final Moroso moroso);

	@Secured("ROLE_FINCA")
	Moroso getMorosoByClave(final String key);

	@Secured("ROLE_FINCA")
	public Moroso getMorosoByCriterion(String nifcif, String tlffijo,
			String tlfmovil);
}
