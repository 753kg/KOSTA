package com.kosta.day07;

public class Rectangle extends Shape {
	int width;
	int height;
	
	Rectangle(String color, int width, int height){
		super(color, "Ractangle");
		this.width = width;
		this.height = height;
	}

	@Override
	public double getArea() {
		return width * height;
	}

	@Override
	public double getPerimeter() {
		return 2 * (width + height);
	}

}
