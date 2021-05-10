package com.kosta.model;

public class UserVO {
	String userid;
	int userpass;
	String email;
	
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public int getUserpass() {
		return userpass;
	}
	public void setUserpass(int userpass) {
		this.userpass = userpass;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	@Override
	public String toString() {
		return "UserVO [userid=" + userid + ", userpass=" + userpass + ", email=" + email + "]";
	}
	
	
}
