package com.kosta.day04;

public class Duck {
	String name;
	int legs;
	int length;
	
	void fly() {
		System.out.println("오리("+name+")는 날지 않습니다.");
	}
	void sing() {
		System.out.println("오리("+name+")가 소리내어 웁니다.");
	}
	
	void setName(String name) {
		this.name = name;
	}
	@Override
	public String toString() {
		return "Duck [name=" + name + ", legs=" + legs + ", length=" + length + "]";
	}
	
	
}