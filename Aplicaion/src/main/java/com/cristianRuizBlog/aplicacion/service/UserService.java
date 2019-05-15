package com.cristianRuizBlog.aplicacion.service;

import javax.validation.Valid;

import com.cristianRuizBlog.aplicacion.entity.User;

public interface UserService {

	public Iterable<User> getAllUsers();

	public User createUser(User user) throws Exception;

	public User getUserById(Long id) throws Exception;
	
	public User updateUser(User user) throws Exception;
	
	public void deleteUser(Long id) throws Exception;
}
