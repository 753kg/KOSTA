package com.kosta.day08.lab;

// 직각삼각형
public class RectTriangle extends Shape {
	
	double width, height;
	
	RectTriangle(double w, double h){
		super(3);			// numSides = 3
		this.width = w;
		this.height = h;
	}

	@Override
	public double getArea() {
		return width * height * 0.5;
	}

	@Override
	public double getPerimeter() {
		// Math.sqrt(width*width + height*height)
		double slope = Math.sqrt(Math.pow(width, 2) + Math.pow(height, 2));
		return width + height + slope;
	}

}
