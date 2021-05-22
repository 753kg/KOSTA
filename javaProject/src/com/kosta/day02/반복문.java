package com.kosta.day02;

// java.util 패키지에 있는 Scanner 클래스를 
// 반복문이라는 class에서 사용 허락 받음
import java.util.Scanner;

public class 반복문 {

	public static void main(String[] args) {
		//forTest();
		//whileTest();
		//dowhileTest();
		//sum();
		//sum2();
		//sum3();
		
		// 사용자가 키보드로 값을 입력하고, 입력된 숫자까지의 합계를 출력.
		// System.out : 표준 출력(모니터)
		// System.in : 표준 입력(키보드)
		// System.in.read -> 1byte씩만 읽을 수 있음.
		// Scanner class : 표준 입출력을 쉽게 하도록 도와줌.
		
		// java.lang 패키지에 들어있는 클래스는 무조건 사용 가능.
		// 다른 패키지에 들어있는 클래스는 import 하고 사용.
		
		Scanner sc = new Scanner(System.in);
		
		for(; ; ) {
			System.out.print("숫자를 입력하세요 >> ");
			int num = sc.nextInt();
			if(num == 0) {
				System.out.println("종료!!");
				break;	// 반복문에서 빠져나감. if는 반복문 아님
			}
			sum4(num);
		}
		
		sc.close();

	}
	
	// 함수: 기능, 동작
	// 파라미터(argument), 인자
	
	private static void sum4(int limit) {
		
		int i;
		int total = 0;
		for(i=1; i<=limit; i++) {
			total = total + i;
		}
		System.out.println(limit + "까지의 합계는 " + total);
		
	}
	
	private static void sum3() {
		// TODO Auto-generated method stub
		int i=1;
		int total = 0;
		do {
			total = total + i;
			i++;
		}while(i<=10);
		System.out.println("합계는 " + total);
	}

	private static void sum2() {
		// TODO Auto-generated method stub
		int i=1;
		int total = 0;
		while(i<=10) {
			total = total + i;
			i++;
		}
		System.out.println("합계는 " + total);
	}

	private static void sum() {
		// 1~10까지 더하기
		int i;
		int total = 0;
		for(i=1; i<=10; i++) {
			total = total + i;
		}
		System.out.println("합계는 " + total);
		
	}

	private static void dowhileTest() {
		int i=0;
		do {
			System.out.println(i+":Hello");
			i++;
		}while(i > 5);
		System.out.println(i+":do-while end");
		
	}

	private static void whileTest() {
		int i=0;
		while(i < 5) {
			System.out.println(i+":Hello");
			i++;
		}
		System.out.println("while end");
		
	}

	private static void forTest() {
		System.out.println("for start!--------");
		int i;
		// 1. 초기값 설정 (1번 반드시 수행됨)
		// 2. 조건문 체크, 조건에 맞으면 looping, 안맞으면 빠져나옴
		// 3. for 안에 있는 문장들 수행
		// 4. 증감 수행
		// 5. 2번으로 감. 다시 조건문 체크
		for(i=1; i<=5; i++) {
			System.out.println(i + ":Hello");
		}
		System.out.println(i + ":for end!---------");
		
		i=1;
		for(; ; ) {
			if(i > 5) {
				System.out.println("for 문장을 빠집니다.");
				break;
			}
			System.out.println(i + ":Hello");
			i++;
		}
		System.out.println(i + ":for end!---------");
	}

}