package com.tourism.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.tourism.bean.RegistrationUser;
import com.tourism.service.UserService;
import com.tourism.service.UserServiceImpl;



@WebServlet("/RegistrationUserServlet")
public class RegistrationUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UserService userService = new UserServiceImpl();
    
    public RegistrationUserServlet() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
RequestDispatcher requestDispatcher = null;
HttpSession httpSession = null;
		
		String firstName = request.getParameter("firstname");
		String lastName =  request.getParameter("lastname");
		int age = Integer.parseInt(request.getParameter("age"));
		String gender =  request.getParameter("gender");
		String contactNumber = request.getParameter("contact");
		String address =  request.getParameter("address");
		String city =  request.getParameter("city");
		int zipCode = Integer.parseInt(request.getParameter("zip"));
		String password = request.getParameter("password");
		
		
		int userId = userService.getUserId();
		
		System.out.println(userId);
		
		RegistrationUser user = new RegistrationUser(userId,password,firstName,lastName,age,gender,contactNumber,address,city,zipCode);
		
		String result = userService.addUser(user);
		
		if("success".equals(result)){
			
			httpSession = request.getSession();
			requestDispatcher = request.getRequestDispatcher("#");
			httpSession.setAttribute("userId", userId);
			requestDispatcher.forward(request, response);
		}
		else
			requestDispatcher=request.getRequestDispatcher("adduser1.jsp");
		
		requestDispatcher.forward(request, response);
	}
	}


