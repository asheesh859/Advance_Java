package com.model;

import java.sql.ResultSet;

public interface DBservice {
	public void connectionDB();
	public boolean verifySignIn(String email , String password);
	public ResultSet getUserIdByEmail(String email);
	public void createRegistration(String name , String course , String mobile, String email , int userId);
	public ResultSet getRegistrationByUser(int userId);
	public void deleteRegistrationById(int id);
	public ResultSet getRegistrationRecordById(int _id);
	
	public void updateRecord(int _id , String name , String course , String email , String mobile);
}
