package p1;

import jakarta.servlet.ServletException;
import java.sql.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/deleteRes")
public class deleteRes extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
    public deleteRes() {
        super();
       
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Get Request");
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Post request");
		String email = request.getParameter("email");
		
		String conString = "jdbc:mysql://127.0.0.1:3306/jdbc_connections";
		String user = "root";
		String password = "root";
		
		
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection(conString, user, password);
			
			Statement smt = con.createStatement();
			
			
			String query = "DELETE FROM STUDENT WHERE email ='"+email+"'";
			
			 smt.executeUpdate(query);
			 con.close();

		}catch (Exception e ) {
			e.printStackTrace();
		}
		
	}

}
