package com.aironman.core.dao;

import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import com.aironman.core.pojos.ViviendasConDeudas;

@Repository
public class FincasMorosasDaoImpl extends
		AbstractDaoImpl<ViviendasConDeudas, String> implements FincasMorosasDao {

	protected FincasMorosasDaoImpl() {
		super(ViviendasConDeudas.class);
	}

	@Override
	public ViviendasConDeudas getViviendasConDeudasByClave(final String key)
			throws DataAccessException {
		return findById(key);
	}

	@Override
	public void addViviendasConDeudas(final ViviendasConDeudas value)
			throws DataAccessException {
		// saveOrUpdate(value);
		merge(value);
	}

}
