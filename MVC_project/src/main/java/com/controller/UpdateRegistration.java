package com.controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
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
		try {
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
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

}
