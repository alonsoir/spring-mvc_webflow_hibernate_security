package com.aironman.core.dao;

import org.springframework.dao.DataAccessException;

import com.aironman.core.pojos.ViviendasConDeudas;

public interface FincasMorosasDao extends
		AbstractDao<ViviendasConDeudas, String> {

	void addViviendasConDeudas(ViviendasConDeudas value)
			throws DataAccessException;

	ViviendasConDeudas getViviendasConDeudasByClave(String key)
			throws DataAccessException;
}
