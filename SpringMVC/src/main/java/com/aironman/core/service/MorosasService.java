package com.aironman.core.service;

import org.springframework.security.access.annotation.Secured;

import com.aironman.core.pojos.Moroso;
import com.aironman.core.pojos.ServiceResponse;

public interface MorosasService {

	@Secured("ROLE_FINCA")
	ServiceResponse addMoroso(final Moroso moroso);

	@Secured("ROLE_FINCA")
	Moroso getMorosoByClave(final String key);

	@Secured("ROLE_FINCA")
	public Moroso getMorosoByCriterion(String nifcif, String tlffijo,
			String tlfmovil);
}
