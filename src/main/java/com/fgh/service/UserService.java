package com.fgh.service;

import com.fgh.entity.User;

public interface UserService {

	public void testGet();

	public User getUser();

	public User getUser(Integer id);

	public User getUser(Integer id, String name);

	void testPost();

	public User postUser(User user);

	public User postUser(String id);
}
