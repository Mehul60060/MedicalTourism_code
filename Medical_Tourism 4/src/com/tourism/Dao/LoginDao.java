package com.tourism.Dao;



public interface LoginDao {
	
//	public Login  userAuthentication(String userName, String password);
	public boolean authenticateUserId(String userId);
	public boolean authenticate(String userName,String password);
	public String getUserType(String id,String password);
	

}
