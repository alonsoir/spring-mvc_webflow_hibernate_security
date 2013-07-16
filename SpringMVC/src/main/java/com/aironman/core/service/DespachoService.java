package com.aironman.core.service;

import java.util.List;

import org.springframework.security.access.annotation.Secured;

import com.aironman.core.pojos.DatosAbogado;
import com.aironman.core.pojos.DatosDemanda;
import com.aironman.core.pojos.DatosDemandaAdmin;
import com.aironman.core.pojos.InfoCertificadoDeuda;
import com.aironman.core.pojos.ServiceResponse;

public interface DespachoService {

	@Secured("ROLE_FINCA")
	ServiceResponse generarCertificadoYCrearDemanda(Long idDeuda,
			String username);

	@Secured("ROLE_FINCA")
	List<DatosDemanda> traerCertificadosAsociadoConDemanda(String username);

	@Secured("ROLE_FINCA")
	InfoCertificadoDeuda traerInfoParaCertificado(Long idDeuda, String username);

	@Secured("ROLE_FINCA")
	void crearDemandaYAsociarAUsuario(String username,
			String rutaFisicaDemanda, Long idDeuda);

	@Secured("ROLE_ADMIN")
	public List<DatosDemandaAdmin> traerCertificadosAdmin();

	@Secured("ROLE_ADMIN")
	public List<DatosAbogado> traerAbogadosDisponibles();
}
