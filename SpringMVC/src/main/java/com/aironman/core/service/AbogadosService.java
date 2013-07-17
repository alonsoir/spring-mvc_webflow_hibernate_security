package com.aironman.core.service;

import java.util.List;

import org.springframework.security.access.annotation.Secured;

import com.aironman.core.pojos.Abogados;
import com.aironman.core.pojos.DatosAbogado;

public interface AbogadosService {

	@Secured("ROLE_ADMIN")
	List<DatosAbogado> traerAbogadosDisponibles();

	@Secured("ROLE_ADMIN")
	Abogados traerAbogadoDadoId(Long idAbogado);
}
