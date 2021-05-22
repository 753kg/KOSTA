package com.kosta.day15;

public class Member {
	// 상수
	public static int MALE = 0;
	public static int FEMALE = 1;
	
	private String name;
	private int sex;
	private int age;
	
	public Member(String name, int sex, int age) {
		this.name = name;
		this.sex = sex;
		this.age = age;
	}

	public int getSex() { return sex; }
	public int getAge() { return age; }

	public String getName() {
		return name;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Member [name=").append(name).append(", sex=").append(sex).append(", age=").append(age)
				.append("]");
		return builder.toString();
	}
	
	
}
