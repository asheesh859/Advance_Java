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


@WebServlet("/ReadRegistration")
public class ReadRegistration extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public ReadRegistration() {
        super();
       
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(false);
		String email = (String)session.getAttribute("email");
		try {
			DBserviceImp service = new DBserviceImp();
			service.connectionDB();
			ResultSet userIdByEmail = service.getUserIdByEmail(email);
			
			int userId = 0;
			if(userIdByEmail.next()) {
				userId = userIdByEmail.getInt(1);
			}
			
			ResultSet registrationByUser = service.getRegistrationByUser(userId);
			
			request.setAttribute("registration", registrationByUser);
			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/view/registration_list.jsp");
			rd.forward(request, response);
			
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
