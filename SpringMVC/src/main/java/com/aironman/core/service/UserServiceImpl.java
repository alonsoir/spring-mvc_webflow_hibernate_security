package com.aironman.core.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.aironman.core.dao.UserDao;
import com.aironman.core.pojos.Users;

/*
 * este servicio lo suyo es que lo usaras para gestionar la info de las tablas para spring security
 * pero ahora mismo eso lo hace la clase org.springframework.security.core.userdetails.jdbc.JdbcDaoImpl
 * que es la implementacion por defecto de spring ws. Tienes que definir una pantalla de login*/
@Service("userService")
@Transactional(readOnly = true)
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDao userDao;

	@Override
	public Users findByUserName(String userName) {

		return userDao.findById(userName);
	}

	@Override
	@Transactional(readOnly = false)
	public void saveUser(Users user) {
		userDao.saveUser(user);
	}

	@Override
	@Transactional(readOnly = false)
	public void deleteUser(String userName) {
		Users user = userDao.findById(userName);
		if (user != null) {
			userDao.delete(user);
		}
	}

	@Override
	public List<Users> findUsers(String user) {
		return userDao.findUsers(user);
	}

	@Override
	public Users login(String userName, String pass) {
		// TODO Auto-generated method stub
		return userDao.login(userName, pass);
	}
}
