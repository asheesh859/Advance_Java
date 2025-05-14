package p1;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.*;

@WebServlet("/RegistrationServlet")
public class RegistrationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public RegistrationServlet() {
		super();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		//response.getWriter().append("Served at: ").append(request.getContextPath());
		
		System.out.print("get");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		//doGet(request, response);
		
		System.out.print("post");
		
		int id = Integer.parseInt( request.getParameter("id"));
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String city = request.getParameter("city");
		
		System.out.println(name);
		System.out.println(email);
		System.out.println(city);
		System.out.println(id);
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/jdbc_connections","root","root");
			Statement smt = con.createStatement();
			String query = "INSERT INTO STUDENT VALUES ("+id+",'"+name+"','"+email+"','"+city+"')";
			smt.executeUpdate(query);	
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		
	}

}
