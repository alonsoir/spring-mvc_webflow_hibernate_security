package com.aironman.core.service;

import java.util.List;

import org.springframework.security.access.annotation.Secured;

import com.aironman.core.pojos.JuntasOrdinarias;

public interface JuntasOrdinariasService {

	@Secured("ROLE_FINCA")
	boolean addJuntasOrdinarias(JuntasOrdinarias value);

	@Secured("ROLE_FINCA")
	List<JuntasOrdinarias> getJuntasOrdinariasByFecha(String fecha);

}
