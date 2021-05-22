package com.kosta.day01;

public class VariableTest {
	
	// 지역변수가 아니면 자동으로 0으로 초기화됨
	static int speed;
	static double speed2;
	
	// main이 없으면 직접 실행 불가하다.
	public static void main(String[] args) {
		
		System.out.println("speed= " + speed);
		System.out.println("speed2= " + speed2);
		
		System.out.println("변수는?");
		System.out.println("기억장소이름이다.");
		
		//10을 저장한다.
		//1. 변수 선언
		int a; 
		
		//2. 변수에 값을 할당한다
		a = 10;
		
		//3. 값을 읽어서 출력한다.
		System.out.println(a + 20);
		System.out.println(a + 30);
		
		//선언 + 할당
		int score = 100;		// = 은 대입연산자
		score = score + 10;
		score += 10;			// 복합대입연산자
		//문자+숫자=>문자 (연결연산자)
		System.out.println("점수는 " + score);
		
		// 지역변수(local variable)는 반드시 초기화하고 사용해야한다.
		int value = 0;
		int result = value + 10;
		System.out.println(result);
		
		
	}

}