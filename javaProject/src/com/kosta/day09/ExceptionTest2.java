package com.kosta.day09;

public class ExceptionTest2 {

	public static void main(String[] args) {
		// 명령행 매개변수 2개를 받아서 사칙연산수행
		// >java ExceptionTest2 10 3
		// 자동으로 예외가 발생 -> 예외처리를 하지 않았다면 JVM에 간다.
		// JVM이 예외 객체를 만들어준다.
		// 예외 객체를 받고, 프로그램 중단
		
		try {
			int v1 = Integer.parseInt(args[0]);
			int v2 = Integer.parseInt(args[1]);
			System.out.println(v1 + v2);
			System.out.println(v1 - v2);
			System.out.println(v1 * v2);
			System.out.println(v1 / v2);
			System.out.println(v1 % v2);
		} catch(ArrayIndexOutOfBoundsException e) {
			// JVM이 만들어준 예외 객체를 받아서 처리한다.
			System.out.println("예외처리: " + e.getMessage());
		} catch(NumberFormatException|ArithmeticException e) {	// 여러개쓸때 or처리
			// NumberFormatException : parseInt할 때 숫자로 변환될 수 없는 문자
			System.out.println("예외처리: " + e.getMessage());
		}
		
		System.out.println("main END");
	}

}
