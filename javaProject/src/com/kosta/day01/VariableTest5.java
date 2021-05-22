package com.kosta.day01;

public class VariableTest5 {
	
	// test 1 함수 정의
	public static void test1() {
		System.out.println("test1 시작");
		System.out.println("-----자동형변환-----");
		int i;
		byte b = 127;
		i = b;
		System.out.println("i= " + i);
	}
	
	// test 2 함수 정의
	public static void test2() {
		System.out.println("test2 시작");
		System.out.println("-----강제형변환-----");
		int i = 2147483647;
		byte b;
		b = (byte) i;
		System.out.println("b= " + b);
	}
	
	public static void test3() {
		int a = 255;
		// Wrapper Class
		// 기본형 기능(값 저장, 연산, 비교)
		// int + 기능추가 -> Integer 
		System.out.println(Integer.MAX_VALUE);
		System.out.println(Integer.toBinaryString(a));	//2진수로
		System.out.println(Integer.toHexString(a));		//16진수
		System.out.println(Integer.toOctalString(a));	//8진수
	}
	
	public static void test4() {
		// 여러 타입을 연산 ==> 결과는 어떤 타입일까? 작은 타입이 큰 타입으로 자동 형변환
		// 연산식에서 자동으로 형변환
		int a = 10;
		double b = 3.14;
		
		double result = a + b;
		System.out.println("result= " + result);
		
		int result2 = (int)(a + b);
		System.out.println("result2= " + result2);
		
		char c = '가';
		String s1 = "자바문자열:";
		System.out.println(s1 + 10 + 20);
		System.out.println(s1 + (10 + 20));
		
		// 연산자 우선순위는 문자가 더 높다.
		int su1 = 10, su2 = 20;
		System.out.println("더하기는 " + (su1 + su2));
		System.out.println("빼기는 " + (su1 - su2));
		System.out.println("곱하기는 " + su1 * su2);
		System.out.println("나누기는 " + su1 / su2);
	}

	// main 함수 정의.. main은 자바 가상머신이 자동으로 호출한다.
	// 나머지 함수는 호출하지 않음.
	// 개발자가 main에서 호출해야한다.
	public static void main(String[] args) {
		System.out.println("main 시작");
		
		// test1(), test2() 함수 호출
		//test1();
		//test2();
		//test3();
		test4();
		
		System.out.println("main END");
	}

}