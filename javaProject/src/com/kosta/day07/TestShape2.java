package com.kosta.day07;

public class TestShape2 {

	public static void main(String[] args) {
		method1();

	}

	private static void method1() {
		method2(new Circle("red", 10));
		method2(new Rectangle("blue", 3, 4));
		
		
	}
	
	private static void method2(Shape s) {
		// 도형의 면적을 구한다.
		System.out.println(s.getArea());
		
		
	}

}
