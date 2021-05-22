package com.kosta.day08.lab;

public class ShapeTest {
	
	public static void main(String[] args) {
		
		Shape[] shapeList = new Shape[2];
		
		makeShapes(shapeList);
		print(shapeList);
	}
	
	public static void print(Shape[] shapeList) {
		for(Shape shape:shapeList) {
			System.out.println("----변의 갯수: "+shape.getNumSides() + "개");
			System.out.println("area: " + shape.getArea());
			System.out.println("perimeter: " + shape.getPerimeter());
			if(shape instanceof Resizable) {
				((Resizable)shape).resize(0.5);
				System.out.println("new area: " + shape.getArea());
				System.out.println("new perimeter: " + shape.getPerimeter());
			}
			
		}
	}
	
	public static void makeShapes(Shape[] shapeList) {
		shapeList[0] = new Rectangle(5, 6);
		shapeList[1] = new RectTriangle(6, 2);
	}

}
