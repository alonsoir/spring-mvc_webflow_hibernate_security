package com.aironman.core.dao;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.aironman.core.pojos.Abogados;

@Repository
public class AbogadosDaoImpl extends AbstractDaoImpl<Abogados, Long> implements
		AbogadosDao {

	private static final Logger LOG = LoggerFactory
			.getLogger(AbogadosDaoImpl.class);

	protected AbogadosDaoImpl() {
		super(Abogados.class);
	}

}
