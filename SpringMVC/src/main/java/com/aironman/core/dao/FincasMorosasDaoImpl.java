package com.aironman.core.dao;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import com.aironman.core.pojos.ViviendasConDeudas;

@Repository
public class FincasMorosasDaoImpl extends
		AbstractDaoImpl<ViviendasConDeudas, Long> implements FincasMorosasDao {

	private static final Logger LOG = LoggerFactory
			.getLogger(FincasMorosasDaoImpl.class);

	protected FincasMorosasDaoImpl() {
		super(ViviendasConDeudas.class);
	}

	@Override
	public ViviendasConDeudas addViviendasConDeudas(
			final ViviendasConDeudas value) throws DataAccessException {
		ViviendasConDeudas o = (ViviendasConDeudas) merge(value);
		return o;
	}

}
