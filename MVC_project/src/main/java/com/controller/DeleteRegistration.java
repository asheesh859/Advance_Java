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


@WebServlet("/DeleteRegistration")
public class DeleteRegistration extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public DeleteRegistration() {
        super();
      
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			String id = request.getParameter("id");
			int Eid = Integer.parseInt(id);
			DBserviceImp service = new DBserviceImp();
			service.connectionDB();
			service.deleteRegistrationById(Eid);
			
			HttpSession session = request.getSession(false);
			String userEmail = (String)session.getAttribute("email");
			
			ResultSet userIdByEmail = service.getUserIdByEmail(userEmail);
			int userID = 0;
			if(userIdByEmail.next()) {
				userID = userIdByEmail.getInt(1);
				
			}
			ResultSet registrationByUser = service.getRegistrationByUser(userID);
			
			request.setAttribute("registration", registrationByUser);
			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/view/registration_list.jsp");
			rd.forward(request, response);
		}catch(Exception e) {
			
		}
		
		
		
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

}
