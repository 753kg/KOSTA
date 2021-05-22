package com.kosta.day13;

interface Arg1Interface {
	void print(int num);
}

interface Arg2Interface {
	int print(int num1, int num2);
}

public class LambdaExample2 {

	public static void main(String[] args) {
		method3();
	}

	private static void method3() {
		Arg2Interface a = (num1, num2) -> num1 + num2;	// return 생략가능
		int result = a.print(100, 200);
		System.out.println("result= " + result);
	}

	private static void method2() {
		Arg2Interface a = (num1, num2) -> {
			System.out.println("num1= " + num1);
			System.out.println("num2= " + num2);
			return num1 + num2;
		};
		int result = a.print(100, 200);
		System.out.println("result= " + result);
	}

	private static void method1() {
		Arg1Interface a = (num) -> {
			System.out.println(num + 10);
			System.out.println(num - 10);
			};
		a.print(5);
	}

}
