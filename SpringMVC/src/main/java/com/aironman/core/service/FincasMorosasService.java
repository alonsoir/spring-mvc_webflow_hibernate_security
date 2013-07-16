package com.aironman.core.service;

import org.springframework.security.access.annotation.Secured;

import com.aironman.core.pojos.ServiceResponse;
import com.aironman.core.pojos.ViviendasConDeudas;

public interface FincasMorosasService {

	@Secured("ROLE_FINCA")
	ServiceResponse addViviendasConDeudas(ViviendasConDeudas value,
			Long idComunidad, Long idMoroso);
}
