package com.aironman.core.service;

import java.util.List;

import org.springframework.security.access.annotation.Secured;

import com.aironman.core.pojos.DatosDemanda;
import com.aironman.core.pojos.InfoCertificadoDeuda;

public interface DespachoService {

	@Secured("ROLE_FINCA")
	String generarCertificadoYCrearDemanda(Long idDeuda, String username);

	@Secured("ROLE_FINCA")
	List<DatosDemanda> traerCertificadosAsociadoConDemanda(String username);

	@Secured("ROLE_FINCA")
	InfoCertificadoDeuda traerInfoParaCertificado(Long idDeuda, String username);

	@Secured("ROLE_FINCA")
	void crearDemandaYAsociarAUsuario(String username,
			String rutaFisicaDemanda, Long idDeuda);
}
