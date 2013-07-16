package com.aironman.core.dao;

import java.util.List;

import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import com.aironman.core.pojos.UserRoles;

@Repository
public class UserRolesDaoImpl extends AbstractDaoImpl<UserRoles, Long>
		implements UserRolesDao {

	private static final Logger LOG = LoggerFactory
			.getLogger(UserRolesDaoImpl.class);

	protected UserRolesDaoImpl() {
		super(UserRoles.class);
	}

	@Override
	public UserRoles saveUserRoles(UserRoles userRoles) {
		// TODO Auto-generated method stub
		UserRoles _userRoles = (UserRoles) merge(userRoles);
		return _userRoles;
	}

	@Override
	public List<UserRoles> findUserRoles(String authority)
			throws DataAccessException {
		return findByCriteria(Restrictions.like("authority", authority,
				MatchMode.START));
	}

}
