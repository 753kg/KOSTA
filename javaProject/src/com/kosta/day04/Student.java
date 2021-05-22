package com.kosta.day04;

// class : 설계도
// object들의 공통된 특성, 행위가 들어감
public class Student {
	// 1. 멤버변수(필드)
	String name;
	String no;
	String major;
	int age;
	
	// 2. 생성자 메서드 : 생성시 자동 호출... 초기화 목적
	// 정의하지 않으면 default 생성자가 제공됨
	// 정의하면 default 생성자 없어짐(사용불가)
	// 반드시 class 이름과 동일해야한다.
	// 생성자 overloading : 갯수, 순서, 타입이 다른 여러개의 생성자 가능
	Student(){
		// default 생성자 : argument가 없음. () 안에 아무것도 없는 것.
		System.out.println("-----------------------");
		System.out.println("학생 생성");
	}
	
	Student(String name, String major){
		// 생성자가 다른 모양의 생성자를 호출
		// 유지보수를 위해 비슷한 코드는 최소화한다.
		this(name, major, "번호모름", 20);
	}
	
	Student(String name, int age){
		this(name, null, null, age);
	}
	
	Student(String name, String major, String no, int age){
		System.out.println("-----------------------");
		System.out.println("학생 생성");
		this.name = name;
		this.major = major;
		this.no = no;
		this.age = age;
	}
	
	// 3. 메서드(기능)
	void study() {
		System.out.println(name+"학생이 공부한다.");
		// return;	void는 함수 종료 후 자동으로 return된다.
	}
	
	String getMajor() {
		return name + "학생의 전공은 " + major;
	}
	
	int getAge() {
		return age;
	}
}