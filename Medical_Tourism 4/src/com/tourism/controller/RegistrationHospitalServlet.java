package com.tourism.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tourism.bean.RegistrationHospital;
import com.tourism.service.HospitalService;
import com.tourism.service.HospitalServiceImpl;




@WebServlet("/RegistrationHospitalServlet")
public class RegistrationHospitalServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private HospitalService hospitalService = new HospitalServiceImpl();  

    
    public RegistrationHospitalServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
RequestDispatcher requestDispatcher = null;
		
		String hospitalName = request.getParameter("hospitalName");
		String addressLine1 =  request.getParameter("addressLine1");
		String addressLine2 = request.getParameter("addressLine2");
		String city =  request.getParameter("city");
		String state = request.getParameter("state");
		//int pin = request.getParameter("pin")
		int pin = Integer.parseInt( request.getParameter("pin"));
		String certifications =  request.getParameter("certifications");
		int successfulOperations =  Integer.parseInt(request.getParameter("successfulOperations"));
		String achievements =  request.getParameter("achievement");
		String status = "N";
		String password = request.getParameter("password");
		
		int hospitalId = hospitalService.getHospitalId();
		
		
		RegistrationHospital hospital = new RegistrationHospital(hospitalId,hospitalName,addressLine1,addressLine2,city,state,pin,certifications,status,password);
		
		String result = hospitalService.addHospital(hospital);
		
		if("success".equals(result)){
			requestDispatcher = request.getRequestDispatcher("#");
		}
		else
			requestDispatcher=request.getRequestDispatcher("addhospital.jsp");
		
		requestDispatcher.forward(request, response);
		
	}
	}


