package com.kosta.day07;

// abstract class : abstract method가 하나 이상 존재한다.
// abstract method : 함수의 정의는 있으나 구현은 없다.
// 구현은 이 class를 상속받은 자식이 반드시 해야한다.
public abstract class Shape {
	private String color;
	private String type;
	
	public Shape(String color, String type) {
		super();
		this.color = color;
		this.type = type;
	}
	
	
	
	// ----------- 규격 ---------------------
	// shape을 상속받으면 이 규격을 지켜야한다.
	public abstract double getArea();		// 면적을 구하다
	// 추상 메서드 : 정의는 있고 구현은 없다.
	// 어떤 도형인지 결정되지 않아서 면적 구하기가 불가능하다.
	
	public abstract double getPerimeter();	// 둘레를 구하다
	// 어떤 도형인지 결정되지 않아서 둘레 구하기가 불가능하다.
	// -----------------------------------------

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	@Override
	public String toString() {
		return color + " " + type;
	}
	
	
	
}
