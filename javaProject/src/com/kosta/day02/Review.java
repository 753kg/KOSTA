package com.kosta.day02;
/*
 * 2021.02.16 김채연
 * 복습
 * 1. Review.java 소스 작성
 * 2. 컴파일 > javac Review.java
 * 	(byte code로 변경, binary 아님, 중간언어, 
 * 	어셈블리언어와 비슷
 * 	c = a+b	->	add a,b)
 * 3. JVM이 실행 > java Review
 * 	add a,b -> 011001010 (기계어로 바뀜)
 */
public class Review {

	// main은 자바가상머신이 자동으로 시작
	// 프로그램은 main에서 시작해서 main에서 끝남
	public static void main(String[] args) {
		System.out.println("main 시작!");
		
		dataTypeTest();
		castTest();

		System.out.println("main 끝!");
	}

	private static void castTest() {
		int i;
		char c = 'A';
		i = c;					// 'A'가 숫자로 뭐야
		System.out.println(i);	//65
		
		c = (char) i;					// 65가 문자로 뭐야
		c++;
		System.out.println(c);	// B
		
	}

	private static void dataTypeTest() {
		// 기본형 : byte(1), short(2), char(2), int(4), long(8), 
		//			float(4), double(8),
		// 			boolean(1)
		// 목적 : 데이터 저장, 연산, 비교
		// Wrapper class : 기본형 + 기능 ==> class
		// 1. 변수 선언
		int javaScore;
		long a = Integer.MAX_VALUE + 1L;	//long과 int 더하면 long됨, 자동형변환
		double pi = 3.141592;
		float pi2 = 3.141592f;
		// 2. 값 할당(대입)
		javaScore = 100;
		// 3. 사용
		System.out.println(javaScore + 10);
		System.out.println(a);
		System.out.println(pi);
		System.out.println(pi2);
		
		
	}

}

// ctrl+shift+F 코드 정리
// help -> show active keybindings