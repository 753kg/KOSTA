package com.kosta.day06.inherit;

public class Student extends Person {
	String studentNo;
	String major;
	
	public Student(String name, int age, String phone, String studentNo, String major) {
		super(name, age, phone);
		this.studentNo = studentNo;
		this.major = major;
	}
	
	void study() {
		System.out.println("공부한다");
	}
	void test() {
		System.out.println("시험본다");
	}

	@Override
	public String toString() {
		// super : 상위 class
		// 상위 class의 toString()을 호출
		String s = super.toString();
		return s + " 자식의 정보는 Student [studentNo=" + studentNo + ", major=" + major + "]";
	}
	
	
	
	
}
