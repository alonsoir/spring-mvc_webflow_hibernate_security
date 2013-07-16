package com.aironman.core.dao;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Criterion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;

public abstract class AbstractDaoImpl<E, I extends Serializable> implements
		AbstractDao<E, I> {

	private final Class<E> entityClass;

	protected AbstractDaoImpl(Class<E> entityClass) {
		this.entityClass = entityClass;
	}

	@Autowired
	private SessionFactory sessionFactory;

	public Session getCurrentSession() {
		return sessionFactory.getCurrentSession();
	}

	@Override
	@SuppressWarnings("unchecked")
	public E findById(I ident) throws DataAccessException {
		E obj = (E) getCurrentSession().get(entityClass, ident);
		return obj;
	}

	@Override
	public Object save(E e) throws DataAccessException {
		Object o = getCurrentSession().save(e);
		return o;
	}

	@Override
	public Object merge(E e) throws DataAccessException {
		Object o = getCurrentSession().merge(e);
		return o;
	}

	@Override
	public void saveOrUpdate(E e) throws DataAccessException {
		getCurrentSession().saveOrUpdate(e);
	}

	@Override
	public void delete(E e) throws DataAccessException {
		getCurrentSession().delete(e);
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<E> findByCriteria(Criterion criterion)
			throws DataAccessException {
		Criteria criteria = getCurrentSession().createCriteria(entityClass);
		criteria.add(criterion);
		return criteria.list();
	}
}
