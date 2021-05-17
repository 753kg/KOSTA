package com.kosta.model;

public class UserVO2 {
	int userid;
	String userpw;
	String address;
	String phone;
	public int getUserid() {
		return userid;
	}
	public void setUserid(int userid) {
		this.userid = userid;
	}
	public String getUserpw() {
		return userpw;
	}
	public void setUserpw(String userpw) {
		this.userpw = userpw;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	@Override
	public String toString() {
		return "UserVO2 [userid=" + userid + ", userpw=" + userpw + ", address=" + address + ", phone=" + phone
				+ "]";
	}
	
	

}
