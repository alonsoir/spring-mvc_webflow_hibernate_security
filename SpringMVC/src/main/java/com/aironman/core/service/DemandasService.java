package com.aironman.core.service;

import org.springframework.security.access.annotation.Secured;

import com.aironman.core.pojos.Abogados;
import com.aironman.core.pojos.Demandas;

public interface DemandasService {

	@Secured("ROLE_ABOGADO")
	public boolean asignarAbogadoADemanda(Demandas value, Abogados abogado);

	@Secured("ROLE_FINCA")
	public Object crearDemandaYAsociarAUsuario(String username,
			String rutaFisicaDemanda, Long idDeuda);

	@Secured("ROLE_FINCA")
	public void crearHistoricoDemanda(String rutaFisicaDemanda, Long idDeuda,
			Long idDemanda);
}
