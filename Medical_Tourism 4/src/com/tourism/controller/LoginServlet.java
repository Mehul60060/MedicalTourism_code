package com.tourism.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


import com.tourism.bean.RegistrationHospital;
import com.tourism.bean.RegistrationUser;
import com.tourism.service.HospitalService;
import com.tourism.service.HospitalServiceImpl;
import com.tourism.service.LoginService;
import com.tourism.service.LoginServiceImpl;
import com.tourism.service.UserService;
import com.tourism.service.UserServiceImpl;


@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private LoginService loginService = new LoginServiceImpl();
   
    private HospitalService hospitalService = new HospitalServiceImpl();
    private UserService userService = new UserServiceImpl();  
  
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userId = request.getParameter("userId");
		UserService userService = new UserServiceImpl();
		int id = Integer.parseInt(userId);
		String password = request.getParameter("password");
		//String userType = request.getParameter("userType");
		RequestDispatcher requestDispatcher = null;
		HttpSession session = null;
		
		if(!loginService.authenticateUserId(userId))
		{
			//System.out.println("#");
			requestDispatcher = request.getRequestDispatcher("#");
		    requestDispatcher.forward(request, response);
		}
		
		
		
		else if(loginService.authenticate(userId,password))
		{
			//System.out.println("!");
			
				//System.out.println("@");
				if("S".equals(loginService.getUserType(userId, password)))
				{
					
				session =  request.getSession();
				requestDispatcher = request.getRequestDispatcher("#");
				List<RegistrationHospital> hos = hospitalService.getAllHospitals();
			//	System.out.println(hos);
				session.setAttribute("hospital", hos);
				List<RegistrationUser> user = userService.getAllUsers();
				session.setAttribute("User", user);
				
				requestDispatcher.forward(request, response);
				
				}
				else if("H".equals(loginService.getUserType(userId, password)) && "Y".equals(hospitalService.getStatus(id)))
				{
					
					int userID = Integer.parseInt(userId);
					session =  request.getSession();
					requestDispatcher = request.getRequestDispatcher("#");
					//session.setAttribute("appointments", appointmentService.getAppointmentList(userID));
					requestDispatcher.forward(request, response);
					
					
					}
				else if("U".equals(loginService.getUserType(userId, password)))
				{
					
					
					session =  request.getSession();
					session.setAttribute("Users", userService.getUser(Integer.parseInt(userId)));
					requestDispatcher = request.getRequestDispatcher("#");
					List<RegistrationHospital> hos = hospitalService.getAllHospitals();					
					session.setAttribute("hospital", hos);
					requestDispatcher.forward(request, response);
				
					}
				
		}
		else
		{
			session.setAttribute("loginError", "Password is wrong.");
		}
	
		
			
	}
	}


