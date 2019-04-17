package com.tourism.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.tourism.util.DBUtils;



public class LoginDaoImp implements LoginDao
{

	private Connection connection;
	public boolean authenticateUserId(String userId) {
		// TODO Auto-generated method stub
		PreparedStatement preparedStatement = null;
		connection  = DBUtils.getConnection();
		ResultSet resultSet = null;
		String insertStatement ="select * from login where userid = ?";
		
		try {
			
			connection.setAutoCommit(true);
			preparedStatement = connection.prepareStatement(insertStatement);
			preparedStatement.setString(1, userId);
		    resultSet = preparedStatement.executeQuery();
		    if(resultSet.next())
			{
			 return true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally
		{
			DBUtils.closeConnection(connection);
		}
		return false;

	}
	public boolean authenticate(String userId, String password) {
		// TODO Auto-generated method stub
		PreparedStatement preparedStatement = null;
		connection  = DBUtils.getConnection();
		ResultSet resultSet = null;
		String insertStatement ="select * from login where userid = ? and password = ?";
		
		try {
			System.out.println("%");
			connection.setAutoCommit(true);
			preparedStatement = connection.prepareStatement(insertStatement);
			preparedStatement.setString(1, userId);
			preparedStatement.setString(2, password);
		    resultSet = preparedStatement.executeQuery();
		    if(resultSet.next())
			{
			 return true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally
		{
			DBUtils.closeConnection(connection);
		}
		return false;

	}
	public String getUserType(String id, String password) {
		// TODO Auto-generated method stub
		PreparedStatement preparedStatement = null;
		String uType="C";
		connection  = DBUtils.getConnection();
		ResultSet resultSet = null;
		String insertStatement ="select userType from login where userid = ?";
		
		try {
			
			connection.setAutoCommit(true);
			preparedStatement = connection.prepareStatement(insertStatement);
			preparedStatement.setString(1, id);	
		    resultSet = preparedStatement.executeQuery();
			
		    if(resultSet.next())
			{
			 uType = resultSet.getString("usertype");
				return uType;
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally
		{
			DBUtils.closeConnection(connection);
		}
		return uType;

	}

}
