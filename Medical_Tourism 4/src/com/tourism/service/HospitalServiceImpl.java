package com.tourism.service;

import java.util.List;

import com.tourism.Dao.HospitalDao;
import com.tourism.Dao.HospitalDaoImp;
import com.tourism.bean.RegistrationHospital;



public class HospitalServiceImpl  implements HospitalService{

	private HospitalDao hospitalDAO = new HospitalDaoImp();
	
	public int getHospitalId() {
		// TODO Auto-generated method stub
		return hospitalDAO.getHospitalId();
	}

	public String addHospital(RegistrationHospital hospital) {
		// TODO Auto-generated method stub
		return hospitalDAO.addHospital(hospital);
	}

	@Override
	public List<RegistrationHospital> getAllHospitals() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<RegistrationHospital> getHospital(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String resetStatus(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getStatus(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	
	
	


}
