package com.aironman.core.service;

import org.springframework.security.access.annotation.Secured;

import com.aironman.core.pojos.ComunidadVecinos;
import com.aironman.core.pojos.Moroso;
import com.aironman.core.pojos.ViviendasConDeudas;

public interface FincasMorosasService {

	@Secured("ROLE_FINCA")
	Long addViviendasConDeudas(ViviendasConDeudas value, ComunidadVecinos com,
			Moroso mom);

	@Secured("ROLE_FINCA")
	ViviendasConDeudas getViviendasConDeudasByClave(String key);

}
