package p1;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

@WebServlet("/readRes")
public class readRes extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public readRes() {
        super();
       
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.print("Get Request");
		
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		
		out.println("<table border=1>");
		out.println("<tr>");
		out.println("<th>");
		out.println("Id");
		out.println("</th>");
		
		out.println("<th>");
		out.println("Name");	
		out.println("</th>");
		
		out.println("<th>");
		out.println("Email");
		out.println("</th>");
		
		out.println("<th>");
		out.println("city");
		out.println("</th>");
		
		
		
		
		
		
		
		
		String connectionString = "jdbc:mysql://127.0.0.1:3306/jdbc_connections";
		String userName = "root";
		String password = "root";
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn = DriverManager.getConnection(connectionString , userName , password); 
			Statement smt = conn.createStatement();
			String query = "select * from student";
			ResultSet result = smt.executeQuery(query);
			while(result.next()) {
				out.println("<tr>");
				out.println("<td>");
				out.println(result.getString(1));
				out.println("</td>");
				out.println("<td>");
				out.println(result.getString(2));
				out.println("</td>");
				
				out.println("<td>");
				out.println(result.getString(3));
				out.println("</td>");
				
				out.println("<td>");
				out.println(result.getString(4));
				out.println("</td>");
				
				out.println("</tr>");
			
			}
			
			conn.close();
			
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		out.println("</table>");
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.print("Post request");
	}

}
