package com.aironman.core.service;

import org.springframework.security.access.annotation.Secured;

import com.aironman.core.pojos.ComunidadVecinos;
import com.aironman.core.pojos.JuntasOrdinarias;
import com.aironman.core.pojos.Users;

public interface ComunidadService {

	@Secured("ROLE_FINCA")
	boolean addComunidadVecinos(ComunidadVecinos value,
			JuntasOrdinarias juntas, Users users, String username);

	@Secured("ROLE_FINCA")
	ComunidadVecinos getComunidadVecinosByDireccion(String key);

	@Secured("ROLE_FINCA")
	public ComunidadVecinos getComunidadVecinosByCriterion(String refCatastral,
			String direccion);

	@Secured("ROLE_FINCA")
	boolean existsComunidad(String key);
}
