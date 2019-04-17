package com.tourism.service;



public interface LoginService {
	
//	public Object userAuthentication(String userName, String password);
	public boolean authenticateUserId(String userId);
	public boolean authenticate(String userName,String password);
	public String getUserType(String id,String password);

}
