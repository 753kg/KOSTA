package com.kosta.day06.inherit;

public class Person extends Object{
	String name;
	int age;
	String phone;
	
	public Person(String name, int age, String phone) {
		super();
		this.name = name;
		this.age = age;
		this.phone = phone;
	}
	void exercise() {
		System.out.println("운동한다");
	}
	void eat() {
		System.out.println("밥먹는다");
	}
	@Override
	public String toString() {
		return "Person [name=" + name + ", age=" + age + ", phone=" + phone + "]";
	}
	
	
}
