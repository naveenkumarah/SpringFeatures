package com.sample.mvc.service;

import java.util.List;

import com.sample.mvc.pojo.User;

public interface UserService {

	List<User> findAllUsers();

	User findById(long id);

	boolean isUserExist(User user);

	void saveUser(User user);

	void updateUser(User currentUser);

	void deleteUserById(long id);

	void deleteAllUsers();

}
