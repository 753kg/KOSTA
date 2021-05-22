package com.kosta.day04;

public class Person {
	//5장 LAB(객체지향 Person)
	
	static int numberOfPersons;
	int age;
	String name;
	
	public Person(){
		this(12, "Anonymous");
	}

	public Person(int age, String name) {
		super();
		this.age = age;
		this.name = name;
		numberOfPersons++;
	}
	
	void selfIntroduce() {
		System.out.println("내 이름은 " + name + "이며, 나이는 " + age + "살 입니다.");
	}
	
	static int getPopulation() {
		return numberOfPersons;
	}
	
	public static void main(String[] args) {
		System.out.println(Person.getPopulation());
		Person p1 = new Person();
		Person p2 = new Person(3, "철수");
		p1.selfIntroduce();
		p2.selfIntroduce();
		System.out.println(Person.getPopulation());
	}
	
}