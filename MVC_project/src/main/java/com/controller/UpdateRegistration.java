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

@WebServlet("/UpdateRegistration")
public class UpdateRegistration extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public UpdateRegistration() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
			HttpSession session = request.getSession(false);
			String _email = (String)session.getAttribute("email");
			
			
		try {
			if(_email!=null) {
			int _id = Integer.parseInt(request.getParameter("id"));

			DBserviceImp service = new DBserviceImp();
			service.connectionDB();

			ResultSet _data = service.getRegistrationRecordById(_id);
			int id = 0;
			String name = null;
			String course = null;
			String email = null;
			String mobile = null;

			if (_data.next()) {
				id = _data.getInt(1);
				name = _data.getString(2);
				course = _data.getString(3);
				email = _data.getString(4);
				mobile = _data.getString(5);
			}
			
			request.setAttribute("id", id);
			request.setAttribute("name", name);
			request.setAttribute("course", course);
			request.setAttribute("email", email);
			request.setAttribute("mobile", mobile);

			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/view/update_registration.jsp");
			rd.forward(request, response);
			
			}else {
				RequestDispatcher requestDispatcher = request.getRequestDispatcher("index.jsp");
				requestDispatcher.forward(request, response);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			HttpSession session = request.getSession(false);
			String email = (String)session.getAttribute("email");
			
			int _id = Integer.parseInt(request.getParameter("id"));
			String _name = request.getParameter("name");
			String _course = request.getParameter("course");
			String _email = request.getParameter("email");
			String _mobile = request.getParameter("mobile");
			
			DBserviceImp service = new DBserviceImp();
			service.connectionDB();
			
			
			service.updateRecord(_id, _name, _course, _email, _mobile);
			
			ResultSet result = service.getUserIdByEmail(email);
			
			int id = 0;
				if(result.next()) {
					id = result.getInt(1);
				}
				
				ResultSet registration = service.getRegistrationByUser(id);
				request.setAttribute("registration",registration);
				RequestDispatcher requestDispatcher = request.getRequestDispatcher("/WEB-INF/view/registration_list.jsp");
				requestDispatcher.forward(request, response);
			
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

}
