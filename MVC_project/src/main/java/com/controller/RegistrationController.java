package com.controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.sql.ResultSet;

import com.model.DBserviceImp;

@WebServlet("/RegistrationController")
public class RegistrationController extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
    public RegistrationController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("WEB-INF/view/registration.jsp");
		requestDispatcher.forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
		HttpSession session = request.getSession(false);
		String email = (String)session.getAttribute("email");
		if(email!=null) {
		System.out.println(email);
		DBserviceImp db = new DBserviceImp();
			db.connectionDB();
			ResultSet result = db.getUserIdByEmail(email);
			int userId = 0;
			if(result.next()) {
				userId= result.getInt(1);
			}
			
			String name = request.getParameter("name");
			String course = request.getParameter("course");
			String mobile = request.getParameter("mobile");
			String emailId = request.getParameter("email");
			
			db.createRegistration(name, course, mobile, emailId, userId);
			
			request.setAttribute("message", "successfully register");
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("WEB-INF/view/registration.jsp");
			requestDispatcher.forward(request, response);
		}else {
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("index.jsp");
		requestDispatcher.forward(request, response);
		}
		}catch(Exception e){
			e.printStackTrace();
		}
		
		
		
		
	}

}
