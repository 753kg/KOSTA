package com.kosta.day04;

/*
 *  >java MethodTest
 *  MethodTest의 bytecode가 method영역에 load됨
 *  static 붙은 메서드, 변수가 메모리에 올라옴
 *  static이 없는 메서드, 변수는 new 하면 올라감.
 */

public class MethodTest {
	
	// 1. 파라미터 없음, return 없음
	void sum() {
		System.out.println("1. 파라미터 없음, return 없음");
		sum(11,12);
		System.out.println("---------------------------");

	}
	
	// 2. 파라미터 있음, return 없음
	// 메서드 Overloading : 메서드 이름 같고 매개변수 사양이 다르다.
	void sum(int a, int b) {
		System.out.println("2. 파라미터 있음, return 없음");
		System.out.println(a + b);
		System.out.println("---------------------------");
	}
	
	void sum(String a, String b) {
		System.out.println("2. 파라미터 있음, return 없음");
		System.out.println(a + b);
		System.out.println("---------------------------");
	}
	
	// 3. 파라미터 있음, return 있음
	double sum(double a, double b, double c) {
		System.out.println("3. 파라미터 있음, return 있음");
		return a+b+c;
	}
	
	int gas;					//필드(멤버변수), 0으로 초기화됨
	boolean isLeftGas(int g) {	//매개변수
		int ga;					//지역변수
		if(gas == 0)
			return false;
		 
		return true;
	}
	
	public static void main(String[] args) {
		
		// static에서 static아닌 메서드 호출할때는 객체 생성해서 함.
		MethodTest a = new MethodTest();
		a.sum();
		// sum(); ===> 불가능
		a.sum(10, 20);
		a.sum("자바","프로그래밍");
		double result = a.sum(10.5, 20.5, 30.5);
		System.out.println("result=" + result);
		
		boolean b = a.isLeftGas(0);
		System.out.println(b);

	}

}