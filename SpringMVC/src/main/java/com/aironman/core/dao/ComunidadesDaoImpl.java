package com.aironman.core.dao;

import java.util.List;

import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import com.aironman.core.pojos.ComunidadVecinos;

@Repository
public class ComunidadesDaoImpl extends
		AbstractDaoImpl<ComunidadVecinos, String> implements ComunidadesDao {

	private static final Logger LOG = LoggerFactory
			.getLogger(ComunidadesDaoImpl.class);

	protected ComunidadesDaoImpl() {
		super(ComunidadVecinos.class);
	}

	@Override
	public boolean addComunidadVecinos(ComunidadVecinos value)
			throws DataAccessException {
		merge(value);
		// saveOrUpdate(value);
		return true;
	}

	@Override
	public ComunidadVecinos getComunidadVecinosByDireccion(String direccion)
			throws DataAccessException {

		Criterion criterion = Restrictions.and(Restrictions.like("direccion",
				direccion));
		List<ComunidadVecinos> listaComunidadVecinos = findByCriteria(criterion);
		ComunidadVecinos comunidadVecinos = null;
		if (listaComunidadVecinos != null && listaComunidadVecinos.size() > 0) {
			comunidadVecinos = listaComunidadVecinos.get(0);
			LOG.info("getComunidadVecinosByDireccion. comunidadVecinos: "
					+ comunidadVecinos.toString());

		}
		return comunidadVecinos;

	}

	/**
	 * basicamente a–adimos todos los filtros por los que podemos buscar una
	 * comunidad de vecinos, es decir, por su refCatastral y por su direccion
	 */
	@Override
	public ComunidadVecinos getComunidadVecinosByCriterion(String refCatastral,
			String direccion) throws DataAccessException {

		Criterion criterionComunidad = null;
		List<ComunidadVecinos> lista = null;
		if (refCatastral != null && !refCatastral.equals("")) {

			Criterion criterioRefCatastral = Restrictions.like("refCatastral",
					refCatastral);
			criterionComunidad = Restrictions.and(criterioRefCatastral);
		}
		if (direccion != null && !direccion.equals("")) {
			Criterion criterioDireccion = Restrictions.like("direccion",
					direccion);
			criterionComunidad = Restrictions.and(criterioDireccion);
		}
		if (criterionComunidad != null) {
			LOG.info("getComunidadVecinosByCriterion. Hay criterios insertados...");
			lista = findByCriteria(criterionComunidad);

		}
		return lista != null && lista.size() > 0 ? lista.get(0) : null;
	}

}
