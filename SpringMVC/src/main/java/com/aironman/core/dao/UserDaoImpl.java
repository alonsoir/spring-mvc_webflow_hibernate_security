package com.aironman.core.dao;

import java.util.List;

import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import com.aironman.core.pojos.Users;

@Repository
public class UserDaoImpl extends AbstractDaoImpl<Users, String> implements
		UserDao {

	private static final Logger LOG = LoggerFactory
			.getLogger(UserDaoImpl.class);

	protected UserDaoImpl() {
		super(Users.class);
	}

	@Override
	public void saveUser(final Users user) {
		// saveOrUpdate(user);
		merge(user);
	}

	@Override
	public List<Users> findUsers(final String userName)
			throws DataAccessException {
		/*
		 * Criterion criterion = Restrictions.and(Restrictions.like("userName",
		 * userName, MatchMode.START)) .add(Restrictions.like("password", pass,
		 * MatchMode.START)); return findByCriteria(criterion);
		 */
		return findByCriteria(Restrictions.like("userName", userName,
				MatchMode.START));
	}

	@Override
	public Users login(final String userName, final String pass)
			throws DataAccessException {

		Criterion criterion = Restrictions.and(
				Restrictions.like("userName", userName, MatchMode.START)).add(
				Restrictions.like("password", pass, MatchMode.START));
		List<Users> listaUser = findByCriteria(criterion);
		Users userLogado = listaUser.get(0);
		LOG.info("userLogado: " + userLogado.toString());
		return userLogado;
	}
}
