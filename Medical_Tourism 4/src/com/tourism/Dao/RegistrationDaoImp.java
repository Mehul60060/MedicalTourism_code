package com.tourism.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


import com.tourism.bean.RegistrationUser;
import com.tourism.util.DBUtils;



public class RegistrationDaoImp implements RegistrationDao {
  Connection connection = null;
	@Override
	public int getUserId() {
		connection  = DBUtils.getConnection();
		PreparedStatement preparedStatement = null;
		connection  = DBUtils.getConnection();
		ResultSet resultSet = null;
		String query = "select userId from user order by userId desc Limit 1";
		int id;
		
		try {
			connection.setAutoCommit(true);
			preparedStatement = connection.prepareStatement(query);
			 resultSet = preparedStatement.executeQuery();
			 
			 if(resultSet.next())
				{
			    	id= resultSet.getInt("userId");
				}
			 else
				 id =1000;
			 
			 return id;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return -1;
		
		
	}
	@Override
	public String addUser(RegistrationUser user) {
		connection  = DBUtils.getConnection();
		PreparedStatement preparedStatement = null;
		PreparedStatement preparedStatement2 = null;
		connection  = DBUtils.getConnection();
		String query ="INSERT INTO user(userId,firstName,lastName,age,gender,contactNumber,address,city,zipcode,password)VALUES(?,?,?,?,?,?,?,?,?,?)";
		String query2 = "insert into login(userId, password, userType) values(?,?,?)";
		
		
		System.out.println(user);
		
		try {
			connection.setAutoCommit(true);
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setInt(1, user.getUserId());
			preparedStatement.setString(2,user.getFirstName());
			preparedStatement.setString(3,user.getLastName());
			preparedStatement.setInt(4, user.getAge());
			preparedStatement.setString(5,user.getGender());
			preparedStatement.setString(6, user.getContactNumber());
			preparedStatement.setString(7,user.getAddress());
			preparedStatement.setString(8,user.getCity());
			preparedStatement.setInt(9, user.getZipCode());
			preparedStatement.setString(10, user.getPassword());
	
			preparedStatement2 = connection.prepareStatement(query2);
			preparedStatement2.setInt(1, user.getUserId());
			preparedStatement2.setString(2,user.getPassword());
			preparedStatement2.setString(3,"U");
			
			if(preparedStatement.executeUpdate()==1 && preparedStatement2.executeUpdate()==1){
					System.out.println("22");
				return "success";
			}
			
			
			return "failed";
			
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			DBUtils.closeConnection(connection);
		}
		
		
		return null;
	
	}
	@Override
	public List<RegistrationUser> getAllUsers() {
    List<RegistrationUser> userList = new ArrayList(); 
		
		connection  = DBUtils.getConnection();
		PreparedStatement preparedStatement = null;
		connection  = DBUtils.getConnection();
		ResultSet resultSet = null;
		
		String query = "select * from user";
		
		
		try {
			connection.setAutoCommit(true);
			preparedStatement = connection.prepareStatement(query);
			resultSet = preparedStatement.executeQuery();
		
			while(resultSet.next()){
				
			int	userId= resultSet.getInt("userId");
			String password = resultSet.getString("password");
			String firstName =  resultSet.getString("firstName");
			String lastName = resultSet.getString("lastName");
			String contactNumber =  resultSet.getString("contactNumber");
			String gender =resultSet.getString("gender");
			int age = resultSet.getInt("age");
			String address =  resultSet.getString("address");
			String city = resultSet.getString("city");
			int zipCode =  resultSet.getInt("zipCode");
			
			//hospital = new Hospital(hospitalId,hospitalName,addressLine1,addressLine2,city,state,pin,certifications,successfulOperations,achievements);
			RegistrationUser user = new RegistrationUser(userId, password, firstName, lastName, age, gender, contactNumber, address, city, zipCode);
			userList.add(user);
			
			}
			
			return userList;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
		return null;
	}
	@Override
	public RegistrationUser getUser(int userId) {
		PreparedStatement preparedStatement = null;
		connection  = DBUtils.getConnection();
		ResultSet resultSet = null;
		RegistrationUser user = new RegistrationUser();
		String insertStatement ="select * from user where userid = ? ";
		
		try {
			
			connection.setAutoCommit(true);
			preparedStatement = connection.prepareStatement(insertStatement);
			preparedStatement.setInt(1, userId);	
		    resultSet = preparedStatement.executeQuery();
			
		    if(resultSet.next())
			{
		    	int	userId2= resultSet.getInt("userId");
				String password =  null;
				String firstName =  resultSet.getString("firstName");
				String lastName = resultSet.getString("lastName");
				String contactNumber =  resultSet.getString("contactNumber");
				String gender =resultSet.getString("gender");
				int age = resultSet.getInt("age");
				String address =  resultSet.getString("address");
				String city = resultSet.getString("city");
				int zipCode =  resultSet.getInt("zipCode");
				user.setAddress(address);
				user.setAge(age);
				user.setContactNumber(contactNumber);
				user.setFirstName(firstName);
				user.setGender(gender);
				user.setLastName(lastName);
				user.setZipCode(zipCode);
				user.setCity(city);
				user.setPassword(password);
				user.setUserId(userId2);
				
				return user;
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally
		{
			DBUtils.closeConnection(connection);
		}
		return user;

		
	}
	}
  

