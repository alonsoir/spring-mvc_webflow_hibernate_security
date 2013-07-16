package com.aironman.core.service;

import org.springframework.security.access.annotation.Secured;

import com.aironman.core.pojos.ComunidadVecinos;
import com.aironman.core.pojos.ServiceResponse;

public interface ComunidadService {

	@Secured("ROLE_FINCA")
	ServiceResponse addComunidadVecinos(ComunidadVecinos value, Long idJunta,
			String username);

	@Secured("ROLE_FINCA")
	ComunidadVecinos getComunidadVecinosByDireccion(String key);

	@Secured("ROLE_FINCA")
	public ComunidadVecinos getComunidadVecinosByCriterion(String refCatastral,
			String direccion);

	@Secured("ROLE_FINCA")
	boolean existsComunidad(String key);
}
