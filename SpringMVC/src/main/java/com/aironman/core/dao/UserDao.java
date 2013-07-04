package com.aironman.core.dao;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.aironman.core.pojos.Users;

public interface UserDao extends AbstractDao<Users, String> {
	void saveUser(Users user);

	List<Users> findUsers(String userName) throws DataAccessException;

	Users login(String userName, String pass) throws DataAccessException;
}
