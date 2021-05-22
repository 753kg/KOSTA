package com.kosta.day01;

public class VariableTest2 {
	
	// class 안에 쓸 수 있는 것?
	// 1. 멤버변수 ...자동초기화된다.
	static int speed;
	// 2. 메서드
	// 3. static block
	// 4. instance block
	// 5. inner class
	
	// System.out.println("a"); -> 못씀
	
	public static void main(String[] args) {
		// 지역변수는 반드시 초기화 해야한다.
		int speed2;
		// static int speed2; -> 이렇겐 안됨
		
		System.out.println("aaaa");
		
		speed++;			// 1 증가
		speed = speed + 1;
		speed += 1;
		speed2 = 100;
		
		System.out.println(speed);
		System.out.println(speed2);
		
		//int a = 100;
		{
			int a = 10;
			System.out.println("a= " + a);
			
		}
		
		//System.out.println("a= " + a);
		
	}
}