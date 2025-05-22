package com.model;

public interface DBservice {
	public void connectionDB();
	public boolean verifySignIn(String email , String password);
	
}
