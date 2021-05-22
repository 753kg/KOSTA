package com.kosta.day07;

// Shape은 추상클래스 
// ==> Circle은 추상클래스를 상속받았으므로 반드시 추상메서드를 구현해야한다.
public class Circle extends Shape {
	int radius;
	double circumference;
	
	Circle(String color, int radius){
		super(color, "Circle");
		this.radius = radius;
	}

	@Override
	public double getArea() {						// 면적
		return radius * radius * Math.PI;
	}

	@Override
	public double getPerimeter() {					// 둘레
		circumference = 2 * radius * Math.PI;
		return circumference;
	}

	public int getRadius() {
		return radius;
	}


}
