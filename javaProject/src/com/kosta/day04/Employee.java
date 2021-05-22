package com.kosta.day04;

/*
 * modifier(접근제한자)
 * 1) public		: 모든 패키지에서 접근 가능
 * 2) protected		: 
 * 3) 생략(default)	: 같은 패키지에서만 접근 가능
 * 4) private		: 
 */

public class Employee {
	
	// 1. 필드(멤버변수) : 객체마다 가지는 독립된 변수
	// 멤버변수 : instance변수 + static변수
	// instance변수는 객체마다 존재
	// static변수 : class변수, class당 1개 존재, instance가 공유
	int empNo;
	String empName;
	String dept;
	String phone;
	
	// 2. Constructor(생성자 메서드)
	// 1) 기본 생성자(default생성자) : 제공됨, 다른 생성자 추가시 지워짐
	public Employee(){
		this(0, null);
	}
	// 2) 생성자 추가(Overloading)
	public Employee(int empNo, String empName){
		this(empNo, empName, null, null);
	}
	
	// 3) source > generate constructor using fields..
	public Employee(int empNo, String empName, String dept) {
		this(empNo, empName, dept, null);
	}
	
	public Employee(int empNo, String empName, String dept, String phone) {
		//super();
		this.empNo = empNo;
		this.empName = empName;
		this.dept = dept;
		this.phone = phone;
	}
	
	// 3. 메서드(기능)
	public void print() {
		System.out.println("------직원정보------");
		System.out.println("직원번호: " + empNo);
		System.out.println("이름: " + empName);
		System.out.println("부서: " + dept);
		System.out.println("연락처: " + phone);
	}
	
	// "\t" : tap
	// "\n" : new line
	public String getEmpInfo() {
		String s = "★직원번호: " + empNo + 
				"\n★이름: " + empName + 
				"\n★부서: " + dept +
				"\n★연락처: " + phone;
		return s;
	}
	
	public void changePhone(String phone) {
		this.phone = phone;
		System.out.println("전화번호가 변경되었습니다.");
	}
	
	public String changePhone2(String phone) {
		String originalNumber = this.phone;
		this.phone = phone;
		System.out.println("전화번호가 변경되고 원래 번호를 return.");
		return "originalNumber: " + originalNumber;
	}
	
}
