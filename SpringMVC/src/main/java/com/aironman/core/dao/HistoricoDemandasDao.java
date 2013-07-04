package com.aironman.core.dao;

import org.springframework.dao.DataAccessException;

import com.aironman.core.pojos.HistoricoDemandasViviendasAdeudadas;

public interface HistoricoDemandasDao extends
		AbstractDao<HistoricoDemandasViviendasAdeudadas, String> {

	void crearHistoricoDemanda(HistoricoDemandasViviendasAdeudadas value)
			throws DataAccessException;

}
