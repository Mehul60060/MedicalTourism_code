package com.tourism.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


import com.tourism.bean.RegistrationHospital;
import com.tourism.util.DBUtils;

public class HospitalDaoImp implements HospitalDao {
      Connection connection=null;
	@Override
	public int getHospitalId() {
		connection  = DBUtils.getConnection();
		PreparedStatement preparedStatement = null;
		connection  = DBUtils.getConnection();
		ResultSet resultSet = null;
		String query = "select hospitalId from hospital order by hospitalid desc Limit 1";
		int id;
		
		try {
			connection.setAutoCommit(true);
			preparedStatement = connection.prepareStatement(query);
			 resultSet = preparedStatement.executeQuery();
			 
			 if(resultSet.next())
				{
			    	id= resultSet.getInt("hospitalId");
				}
			 else
				 id =100;
			 
			 return id;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return -1;
	}

	@Override
	public String addHospital(RegistrationHospital hospital) {
		connection  = DBUtils.getConnection();
		PreparedStatement preparedStatement = null;
		PreparedStatement preparedStatement2 = null;
		connection  = DBUtils.getConnection();
		String query ="INSERT INTO hospital(hospitalId,hospitalName,addressLine1,addressLine2,city,state,pin,certifications,status,password) values(?,?,?,?,?,?,?,?,?,?)";
		String query2 = "insert into login(userId, password, userType) values(?,?,?)";
		
		System.out.println(hospital);
		
		try {
			connection.setAutoCommit(true);
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setInt(1, hospital.getHospitalId());
			preparedStatement.setString(2, hospital.getHospitalName());
			preparedStatement.setString(3, hospital.getAddressLine1());
			preparedStatement.setString(4, hospital.getAddressLine2());
			preparedStatement.setString(5, hospital.getCity());
			preparedStatement.setString(6, hospital.getState());
			preparedStatement.setInt(7,hospital.getPin());
			preparedStatement.setString(8, hospital.getCertifications());
			
			preparedStatement.setString(9, hospital.getStatus());
			preparedStatement.setString(10, hospital.getPassword());
			
			preparedStatement2 = connection.prepareStatement(query2);
			preparedStatement2.setInt(1, hospital.getHospitalId());
			preparedStatement2.setString(2, hospital.getPassword());
			preparedStatement2.setString(3, "H");
			
			if(preparedStatement.executeUpdate()==1 && preparedStatement2.executeUpdate()==1){
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
	public List<RegistrationHospital> getAllHospitals() {
List<RegistrationHospital> hospitalList = new ArrayList(); 
		
		connection  = DBUtils.getConnection();
		PreparedStatement preparedStatement = null;
	//	connection  = DBUtils.getConnection();
		ResultSet resultSet = null;
		RegistrationHospital hospital ;
		String query = "select * from hospital";
		
		
		try {
			connection.setAutoCommit(true);
			preparedStatement = connection.prepareStatement(query);
			resultSet = preparedStatement.executeQuery();
		
			while(resultSet.next()){
				
			int	hospitalId= resultSet.getInt("hospitalId");
			String hospitalName = resultSet.getString("hospitalName");
			String addressLine1 =  resultSet.getString("addressLine1");
			String addressLine2 = resultSet.getString("addressLine2");
			String city =  resultSet.getString("city");
			String state =resultSet.getString("state");
			int pin = resultSet.getInt("pin");
			String certifications =  resultSet.getString("certifications");
			String status = resultSet.getString("status");
			String password = resultSet.getString("password");
			
			hospital = new RegistrationHospital(hospitalId,hospitalName,addressLine1,addressLine2,city,state,pin,certifications,status,password);
			
			hospitalList.add(hospital);
			}
			
			return hospitalList;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<RegistrationHospital> getHospital(String name) {
List<RegistrationHospital> hospitalList = new ArrayList(); 
		
		connection  = DBUtils.getConnection();
		PreparedStatement preparedStatement = null;
	
		ResultSet resultSet = null;
		RegistrationHospital hospital ;
	
		System.out.println(name);
	
		String query = null;
	
		if(name.equals(""))
		{
			
			query = "select * from hospital";
		}
		
		else
		{
			query = "select * from hospital where hospitalName = ? ";
		}
		
		
		try {
			connection.setAutoCommit(true);
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, name);
			resultSet = preparedStatement.executeQuery();
		
			while(resultSet.next()){
				
			int	hospitalId= resultSet.getInt("hospitalId");
			String hospitalName = resultSet.getString("hospitalName");
			String addressLine1 =  resultSet.getString("addressLine1");
			String addressLine2 = resultSet.getString("addressLine2");
			String city =  resultSet.getString("city");
			String state =resultSet.getString("state");
			int pin = resultSet.getInt("pin");
			String certifications =  resultSet.getString("certifications");
			String status = resultSet.getString("status");
			String password = resultSet.getString("password");
			
			hospital = new RegistrationHospital(hospitalId,hospitalName,addressLine1,addressLine2,city,state,pin,certifications,status,password);
			
			hospitalList.add(hospital);
			}
			
			return hospitalList;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			return null;
	}
	}

	@Override
	public String resetStatus(int id) {
		PreparedStatement preparedStatement = null;
		connection  = DBUtils.getConnection();
		
		
		String query = "update hospital set status = ? where hospitalId = ? and status = ?";
		try {
			connection.setAutoCommit(true);
			preparedStatement = connection.prepareStatement(query);
			
			preparedStatement.setString(1,"Y");
			preparedStatement.setInt(2, id);
			preparedStatement.setString(3, "N");
			
			if(preparedStatement.executeUpdate()==1)
				return "success";
			
			else
				return "fail";
			
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		return "fail";
	}

	@Override
	public String getStatus(int id) {
		connection  = DBUtils.getConnection();
		PreparedStatement preparedStatement = null;
		ResultSet resultSet;
		String status;
		//connection  = DBUtils.getConnection();
		
		String query = "Select status from hospital where hospitalId=?";
		
		try {
			connection.setAutoCommit(true);
			preparedStatement = connection.prepareStatement(query);
			
			preparedStatement.setInt(1, id);
			resultSet = preparedStatement.executeQuery();
			
			if(resultSet.next())
			{
				System.out.println("$");
			 status = resultSet.getString("status");
				return status;
			}

			
		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}

}
