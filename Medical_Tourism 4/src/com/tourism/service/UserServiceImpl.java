package com.tourism.service;

import java.util.List;

import com.tourism.Dao.RegistrationDao;
import com.tourism.Dao.RegistrationDaoImp;
import com.tourism.bean.RegistrationUser;



public class UserServiceImpl implements UserService {

	RegistrationDao dao = new RegistrationDaoImp();
	
	public int getUserId() {
		// TODO Auto-generated method stub
		return  dao.getUserId();
	}

	public String addUser(RegistrationUser user) {
		// TODO Auto-generated method stub
		return dao.addUser(user);
	}

	@Override
	public List<RegistrationUser> getAllUsers() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public RegistrationUser getUser(int userId) {
		// TODO Auto-generated method stub
		return null;
	}

	
	
}
