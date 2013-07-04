package com.aironman.core.service;

import java.util.List;

import org.springframework.security.access.annotation.Secured;

import com.aironman.core.pojos.DatosDemanda;
import com.aironman.core.pojos.InfoCertificadoDeuda;

public interface CertificadosService {

	@Secured("ROLE_FINCA")
	String generarCertificadoCelebracionJunta(Long idDeuda, String username);

	@Secured("ROLE_FINCA")
	InfoCertificadoDeuda traerInfoParaCertificado(Long idDeuda, String username);

	@Secured("ROLE_FINCA")
	List<DatosDemanda> traerCertificados(String username);

}
