package com.aironman.core.dao;

import java.io.Serializable;
import java.util.List;

import org.hibernate.criterion.Criterion;
import org.springframework.dao.DataAccessException;

public interface AbstractDao<E, I extends Serializable> {

	E findById(I id) throws DataAccessException;

	Object save(E e) throws DataAccessException;

	void saveOrUpdate(E e) throws DataAccessException;

	void delete(E e) throws DataAccessException;

	List<E> findByCriteria(Criterion criterion) throws DataAccessException;

	public Object merge(E e) throws DataAccessException;
}
