package com.kosta.day06.inherit;

public class PersonTest {

	public static void main(String[] args) {
		Person p = new Person("김길동", 20, "010-1234-5678");
		Student s = new Student("김학생", 25, "010-3333-4444", "890101", "컴공");
		
		System.out.println(p);
		System.out.println(s);
	}

}
