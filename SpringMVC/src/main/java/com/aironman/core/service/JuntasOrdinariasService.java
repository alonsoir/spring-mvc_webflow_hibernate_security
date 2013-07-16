package com.aironman.core.service;

import java.util.List;

import org.springframework.security.access.annotation.Secured;

import com.aironman.core.pojos.JuntasOrdinarias;
import com.aironman.core.pojos.ServiceResponse;

public interface JuntasOrdinariasService {

	@Secured("ROLE_FINCA")
	ServiceResponse addJuntasOrdinarias(JuntasOrdinarias value);

	@Secured("ROLE_FINCA")
	List<JuntasOrdinarias> getJuntasOrdinariasByFecha(String fecha);

}
