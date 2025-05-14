package p1;

import jakarta.servlet.ServletException;
import java.sql.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/updateRes")
public class updateRes extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public updateRes() {
		super();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("Get Request");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("Post Request");

		String city = request.getParameter("city");
		String email = request.getParameter("email");

		String connectionString = "jdbc:mysql://127.0.0.1/jdbc_connections";
		String user = "root";
		String password = "root";

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection(connectionString, user, password);

			Statement smt = con.createStatement();

			String query = "UPDATE STUDENT SET city = '" + city + "' where email='" + email + "'";

			smt.executeUpdate(query);
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
