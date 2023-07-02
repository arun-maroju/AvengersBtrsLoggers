package com.avengers.bus.models.inputModels;

public class UserPasswordChange {
	
	private String email;
	private String password;
	public UserPasswordChange(String email2, String newPassword) {
		this.email=email2;
		this.password=newPassword;
		// TODO Auto-generated constructor stub
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

}
