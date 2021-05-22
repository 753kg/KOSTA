package com.kosta.day01;

public class OperatorTest {
	
	public static void main(String[] args) {
		method7();

	}

	private static void method7() {
		// 3항 연산자
		int score = 85;
		int limit = 90;
		String result = (score >= limit) ? "합격" : "불합격";
		System.out.println(result);
		
		if(score >= limit) {
			result = "합격";
		}else {
			result = "불합격";
		}
		System.out.println(result);
	}

	private static void method6() {
		// || 하나라도 참이면 참이다. 앞의 결과가 true이면 뒤문장은 수행 안함.
		// | 하나라도 참이면 참이다. 무조건 모든 문장 수행한다.
		int a = 10;
		int b = 20;
		//boolean result = a >= 10 || ++b >= 20;
		boolean result = a >= 10 | ++b >= 20;
		System.out.println("result=" + result);
		System.out.println("b=" + b);
		
	}

	private static void method5() {
		// && : 모두 참이면 참이다. 앞의 결과가 false이면 뒤문장은 수행 안함.
		// & : 모두 참이면 참이다, 모든 문장 수행.
		
		int a = 10;
		int b = 20;
		//boolean result = a < 10 && ++b >= 20;
		boolean result = a < 10 & ++b >= 20;
		System.out.println("result=" + result);
		System.out.println("b=" + b);
	}

	private static void method4() {
		int a = 10;
		int b = 20;
		// System.out.println(a = b); a에 b를 넣고 a를 출력
		System.out.println(a == b);
		System.out.println(a != b);
		
		// "자바"라는 문자는 String 클래스로 만들어진 (객체)실체인가요?
		System.out.println("자바" instanceof String);
		
	}

	private static void method3() {
		int a = 10;
		int b = 20;
		int result = a++ + ++b;
		
		System.out.println("result = " + result);	//31
		System.out.println("a= " + a);	// 11
		System.out.println("b= " + b);	// 21
		
	}

	private static void method2() {
		// 증감 연산자
		int a = 10;
		a++;
		++a;
		a += 1;
		a = a + 1;
		// 증가하고 출력한다. 15
		System.out.println("a= " + ++a);	// 전위 연산자
		// 출력하고 증가한다. 15
		System.out.println("a= " + a++);	// 후위 연산자
		System.out.println(a);	// 16
		
	}

	private static void method1() {
		// 산술 연산자 : +, -, *, /, %
		int a = 10;
		int b = 3;
		System.out.println("몫: " + a / b);
		System.out.println("나머지: " + a % b);
		System.out.println("실수결과: " + a / (double)b);
		System.out.println("실수결과: " + (double)a / b);
		System.out.println("실수결과: " + 1.0*a / b);
		
	}

}