package com.kosta.sample2;

import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

public class People {
	String name;
	String phone;
	List<Car> carlist;
	List<String> major;
	Map<String, Book> mybook;
	Set friend;
	Properties myprofile;	//Map과 비슷 key=value, Properties는 Map을 구현한 class
	
	public People() {
		super();
	}
	public People(String name, String phone, List<Car> carlist) {
		super();
		this.name = name;
		this.phone = phone;
		this.carlist = carlist;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public List<Car> getCarlist() {
		return carlist;
	}
	public void setCarlist(List<Car> carlist) {
		this.carlist = carlist;
	}
	
	public List<String> getMajor() {
		return major;
	}
	public void setMajor(List<String> major) {
		this.major = major;
	}
	public Map<String, Book> getMybook() {
		return mybook;
	}
	public void setMybook(Map<String, Book> mybook) {
		this.mybook = mybook;
	}
	public Set getFriend() {
		return friend;
	}
	public void setFriend(Set friend) {
		this.friend = friend;
	}
	public Properties getMyprofile() {
		return myprofile;
	}
	public void setMyprofile(Properties myprofile) {
		this.myprofile = myprofile;
	}
	@Override
	public String toString() {
		return "People [name=" + name + ", phone=" + phone + ", carlist=" + carlist + ", major=" + major + ", mybook="
				+ mybook + ", friend=" + friend + ", myprofile=" + myprofile + "]";
	}
	
	
	
}
