package com.tourism.Dao;

import java.util.List;


import com.tourism.bean.RegistrationHospital;

public interface HospitalDao {
	public int getHospitalId();
	public String addHospital(RegistrationHospital hospital);
	public List< RegistrationHospital> getAllHospitals();
	public List<RegistrationHospital> getHospital(String name);
	public String resetStatus(int id);
	public String getStatus(int id);
}
