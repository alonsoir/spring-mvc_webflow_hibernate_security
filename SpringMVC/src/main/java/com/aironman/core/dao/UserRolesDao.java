package com.aironman.core.dao;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.aironman.core.pojos.UserRoles;

public interface UserRolesDao extends AbstractDao<UserRoles, Long> {

	UserRoles saveUserRoles(UserRoles userRoles);

	List<UserRoles> findUserRoles(String authority) throws DataAccessException;
}
