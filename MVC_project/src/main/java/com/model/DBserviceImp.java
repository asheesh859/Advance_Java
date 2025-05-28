package com.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class DBserviceImp implements DBservice {
	private Connection con;
	private Statement smt;
	@Override
	public void connectionDB() {
		String connectionString = "jdbc:mysql://127.0.0.1:3306/jdbc_connections";
		String userName = "root";
		String password ="root";
		
		
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection(connectionString , userName , password);
			smt = con.createStatement();
			
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public boolean verifySignIn(String email , String password) {
		String Query="SELECT * FROM user WHERE email='"+email+"' AND password ='"+password+"'";
		try {
			ResultSet result = smt.executeQuery(Query);
			return result.next();
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public ResultSet getUserIdByEmail(String email) {
		try {
			
			String Query = "SELECT * FROM user WHERE email = '"+email+"'";
			ResultSet result = smt.executeQuery(Query);
			
			return result;
		}catch(Exception e){
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public void createRegistration(String name, String course, String mobile, String email, int userId) {
		try {
			String Query = "INSERT INTO registration (name , course ,mobile ,email, user_id) VALUES ('"+name+"','"+course+"' ,'"+mobile+"','"+email+"','"+userId+"')";
			smt.executeUpdate(Query);
		}catch(Exception 	e) {
			e.printStackTrace();
		}
	}

	@Override
	public ResultSet getRegistrationByUser(int userId) {
		try {
			String Query = "Select * from registration where user_id = '"+userId+"'";
			ResultSet result =smt.executeQuery(Query);
			return result;
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public void deleteRegistrationById(int id) {
		try {
			String query = "delete from registration where id='"+id+"'";
			smt.executeUpdate(query);
			
		}catch(Exception e) {
			e.printStackTrace();
			}
		
	}

	@Override
	public ResultSet getRegistrationRecordById(int _id) {
		try {
			String query = "Select id , name, course , email , mobile ,user_id from registration where id ='"+_id+"'";
			ResultSet result = smt.executeQuery(query);
			return result;
			
		}catch(Exception e) {
			
		}
		
		return null;
	}

	@Override
	public void updateRecord(int _id, String name, String course, String email, String mobile) {
		String query = "update registration set id='"+_id+"', name = '"+name+"' , course = '"+course+"',email ='"+email+"' , mobile = '"+mobile+"' where id ='"+_id+"'";
		try {
			smt.executeUpdate(query);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
}
