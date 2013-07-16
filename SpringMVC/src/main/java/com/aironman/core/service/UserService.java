package com.aironman.core.service;

import java.util.List;

import com.aironman.core.pojos.Users;

public interface UserService {

	Users login(String userName, String pass);

	Users findByIdUser(Long idUser);

	void saveUser(Users user);

	void deleteUser(String userName);

	List<Users> findUsers(String user);

	boolean isUsernameAdmin(String username);
}
