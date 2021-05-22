package com.kosta.day08.lab;

// 직사각형
public class Rectangle extends Shape implements Resizable{
	
	double width, height;
	
	Rectangle(double w, double h){
		super(4);			// numSides = 4
		this.width = w;
		this.height = h;
	}

	@Override
	public double getArea() {
		return width * height;
	}

	@Override
	public double getPerimeter() {
		return (width + height) * 2;
	}

	@Override
	public void resize(double s) {
		width *= s;
		height *= s;
		
	}

}
