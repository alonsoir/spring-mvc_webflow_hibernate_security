package com.aironman.core.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.aironman.core.dao.UserDao;
import com.aironman.core.dao.UserRolesDao;
import com.aironman.core.pojos.UserRoles;
import com.aironman.core.pojos.Users;

/*
 * este servicio lo suyo es que lo usaras para gestionar la info de las tablas para spring security
 * pero ahora mismo eso lo hace la clase org.springframework.security.core.userdetails.jdbc.JdbcDaoImpl
 * que es la implementacion por defecto de spring ws. Tienes que definir una pantalla de login*/
@Service("userService")
@Transactional(readOnly = true)
public class UserServiceImpl implements UserService {

	private static final Logger LOG = LoggerFactory
			.getLogger(UserServiceImpl.class);

	@Autowired
	private UserDao userDao;

	@Autowired
	private UserRolesDao userRolesDao;

	@Override
	public Users findByIdUser(Long idUser) {

		return userDao.findById(idUser);
	}

	@Override
	@Transactional(readOnly = false)
	public void saveUser(Users user) {
		userDao.saveUser(user);
	}

	@Override
	@Transactional(readOnly = false)
	public void deleteUser(String userName) {
		List<Users> listauser = userDao.findUsers(userName);
		if (listauser != null && listauser.size() > 0) {
			Users _user = listauser.get(0);
			userDao.delete(_user);
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

	@Override
	public boolean isUsernameAdmin(String username) {
		// TODO Auto-generated method stub
		boolean retorno = false;
		List<Users> listaUsers = findUsers(username);
		if (listaUsers != null && listaUsers.size() > 0) {
			Users _user = listaUsers.get(0);
			List<UserRoles> listaUserRoles = userRolesDao
					.findUserRoles("ROLE_ADMIN");
			if (listaUserRoles != null && listaUserRoles.size() > 0) {
				UserRoles _userRoles = listaUserRoles.get(0);
				if (_userRoles != null) {
					retorno = _userRoles.getAuthority().equalsIgnoreCase(
							"ROLE_ADMIN")
							&& _userRoles.getUser().getUserName()
									.equalsIgnoreCase(username);

				}
			}
		}
		LOG.info(username + " isUserAdmin? retorno: " + retorno);
		return retorno;
	}
}
