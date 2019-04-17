package com.tourism.service;

import java.util.List;


import com.tourism.bean.RegistrationUser;

public interface UserService {

	public int getUserId();
	public String addUser(RegistrationUser user);
	public List<RegistrationUser> getAllUsers();
	public  RegistrationUser  getUser(int userId);
	
}
