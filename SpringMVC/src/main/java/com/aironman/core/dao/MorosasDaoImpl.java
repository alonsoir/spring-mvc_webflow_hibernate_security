package com.aironman.core.dao;

import java.util.List;

import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import com.aironman.core.pojos.Moroso;

@Repository
public class MorosasDaoImpl extends AbstractDaoImpl<Moroso, String> implements
		MorosasDao {

	private static final Logger LOG = LoggerFactory
			.getLogger(MorosasDaoImpl.class);

	protected MorosasDaoImpl() {
		super(Moroso.class);
	}

	@Override
	public Moroso addMoroso(final Moroso value) throws DataAccessException {
		// TODO Auto-generated method stub
		Moroso o = (Moroso) merge(value);
		return o;
	}

	@Override
	public Moroso getMorosoByClave(final String nifCif)
			throws DataAccessException {

		Criterion criterion = Restrictions.and(Restrictions.like("nifCif",
				nifCif));
		List<Moroso> listaMoroso = findByCriteria(criterion);
		Moroso moroso = null;
		if (listaMoroso != null && listaMoroso.size() > 0) {
			moroso = listaMoroso.get(0);
			LOG.info("getMorosoByClave. nombre del moroso: "
					+ moroso.getNombreCompleto());

		}
		return moroso;
	}

	@Override
	public Moroso getMorosoByCriterion(String nifcif, String tlffijo,
			String tlfmovil) throws DataAccessException {

		Criterion criterionMoroso = null;
		List<Moroso> lista = null;
		Criterion criteriotlfFijo = null;
		Criterion criteriotlfMovil = null;
		Criterion criterionifCif = null;

		if (nifcif != null && !nifcif.equals("")) {
			criterionifCif = Restrictions.like("nifCif", nifcif);
		}
		if (tlffijo != null && !tlffijo.equals("")) {
			criteriotlfFijo = Restrictions.like("tlffijo", tlffijo);
		}

		if (tlfmovil != null && !tlfmovil.equals("")) {
			criteriotlfMovil = Restrictions.like("tlfmovil", tlfmovil);
		}
		// posibles combinaciones de criterios, pffff
		// hay nif,fijo y movil
		if (criterionifCif != null && criteriotlfFijo != null
				&& criteriotlfMovil != null) {
			criterionMoroso = Restrictions.or(criterionifCif, criteriotlfFijo,
					criteriotlfMovil);
		}
		// hay fijo y movil
		else if (criterionifCif == null && criteriotlfFijo != null
				&& criteriotlfMovil != null) {
			criterionMoroso = Restrictions
					.or(criteriotlfFijo, criteriotlfMovil);
		}
		// hay fijo y nif
		else if (criterionifCif != null && criteriotlfFijo != null
				&& criteriotlfMovil == null) {
			criterionMoroso = Restrictions.or(criterionifCif, criteriotlfFijo);
		}
		// hay movil y nif
		else if (criterionifCif != null && criteriotlfFijo == null
				&& criteriotlfMovil != null) {
			criterionMoroso = Restrictions.or(criterionifCif, criteriotlfMovil);
		}
		// solo movil
		else if (criterionifCif == null && criteriotlfFijo == null
				&& criteriotlfMovil != null) {
			criterionMoroso = Restrictions.or(criteriotlfMovil);
		}
		// solo nif
		else if (criterionifCif != null && criteriotlfFijo == null
				&& criteriotlfMovil == null) {
			criterionMoroso = Restrictions.or(criterionifCif);
		}
		// solo fijo
		else if (criterionifCif == null && criteriotlfFijo != null
				&& criteriotlfMovil == null) {
			criterionMoroso = Restrictions.or(criteriotlfFijo);
		}
		if (criterionMoroso != null) {
			LOG.info("getMorosoByCriterion. Hay varios criterios insertados. criterionMoroso: "
					+ criterionMoroso.toString());
			lista = findByCriteria(criterionMoroso);
			LOG.info("lista morosos: "
					+ (lista != null ? lista.size() : "ATENCION! lista nula"));

		}
		return lista != null && lista.size() > 0 ? lista.get(0) : null;

	}

}
