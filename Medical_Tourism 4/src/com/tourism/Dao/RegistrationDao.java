package com.tourism.Dao;

import java.util.List;

import com.tourism.bean.RegistrationUser;



public interface RegistrationDao {
	public int getUserId(); 
	public String addUser(RegistrationUser user);
	public List<RegistrationUser> getAllUsers();
	public RegistrationUser getUser(int userId);
}
