package com.kosta.day12;

// Person(일반인) <--- Student(학생) <---- HighStudent
//		  		<--- Worker(직장인)
public class Person {
	private String name;

	public Person(String name) {
		super();
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Person [name=").append(name).append("]");
		return builder.toString();
	}
	
	
}
