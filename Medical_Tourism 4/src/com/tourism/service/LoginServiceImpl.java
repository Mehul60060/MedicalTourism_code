package com.tourism.service;

import com.tourism.Dao.LoginDao;
import com.tourism.Dao.LoginDaoImp;

public class LoginServiceImpl implements LoginService {

	LoginDao loginDAO = new LoginDaoImp();

	public boolean authenticateUserId(String userId) {
		// TODO Auto-generated method stub
		return loginDAO.authenticateUserId(userId);
	}

	public boolean authenticate(String userName, String password) {
		// TODO Auto-generated method stub
		return loginDAO.authenticate(userName, password);
	}

	public String getUserType(String id, String password) {
		// TODO Auto-generated method stub
		return loginDAO.getUserType(id, password);
	}
	
	
}
