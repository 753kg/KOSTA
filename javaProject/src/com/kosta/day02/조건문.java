package com.kosta.day02;

public class 조건문 {

	public static void main(String[] args) {
		System.out.println("main start");
		//ifTest();
		//ifElseTest();
		ifElseIfTest();
		System.out.println("main end");

	}
	
	private static void ifElseIfTest() {
		int score = 100;
		char grade = 'F';		
		if(score >= 90) {
			System.out.print("참 잘했습니다... A");
			if(score >= 95) {
				grade = '+';
			}else {
				grade = '-';				
			}
		}else if(score >= 80) {
			grade = 'B';
		}else if(score >= 70) {
			grade = 'C';
		}else if(score >= 60) {
			grade = 'D';
		}
//		else {
//			grade = 'F';
//		}
		// else는 없어도 된다.
		System.out.println(grade + " 입니다.");
		
	}

	private static void ifElseTest() {
		int score = 100;
		
		if(score >= 60) {
			//조건의 결과가 참인 경우만 실행
			System.out.println("합격");
		}else {
			//조건의 결과가 거짓인 경우만 실행
			System.out.println("불합격");
		}
		
		//3항연산자
		System.out.println(score>=60?"합격":"불합격");
		
		System.out.println("if-else 끝");
		
	}

	private static void ifTest() {
		int score = 99;
		
		// 조건문에 실행문이 여러문장이면 반드시 블럭을 사용한다.
		if(score >= 90) {
			System.out.println("합격");
			System.out.println("축하합니다.");
		}
		
		//조건문에 실행문이 1문장인 경우, {} 생략 가능
		if(score >= 90) 
			System.out.println("합격");
		
		//삼항연산자
		System.out.println(score>=90?"합격":"");
		
		System.out.println("if 종료");
	}

}