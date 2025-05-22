package com.controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

import com.model.DBserviceImp;

@WebServlet("/login")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
    public LoginController() {
        super();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("get request");
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("post request");
		String email = request.getParameter("email");
		String password = request.getParameter("password");

		try {
			
			DBserviceImp db = new DBserviceImp();
			db.connectionDB();
			boolean status = db.verifySignIn(email, password);
			
			if(status) {
				HttpSession session = request.getSession(true);
				session.setAttribute("email", email);
				RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/view/registration.jsp");
				rd.forward(request, response);
			}else {
				request.setAttribute("error", "invalid email/pasword");
				RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
				rd.forward(request, response);
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

}
