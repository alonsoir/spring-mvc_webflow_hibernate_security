package com.aironman.core.service;

import org.springframework.security.access.annotation.Secured;

import com.aironman.core.pojos.Abogados;
import com.aironman.core.pojos.Demandas;

public interface DemandasService {

	@Secured("ROLE_ADMIN")
	public boolean asignarAbogadoADemanda(Demandas demanda, Abogados abogado);

	@Secured("ROLE_ADMIN")
	public Demandas traerDemanda(Long idDemanda);

	@Secured("ROLE_FINCA")
	public Object crearDemandaYAsociarAUsuario(String username,
			String rutaFisicaDemanda, Long idDeuda);

	@Secured("ROLE_FINCA")
	public void crearHistoricoDemanda(String rutaFisicaDemanda, Long idDeuda,
			Long idDemanda);
}
