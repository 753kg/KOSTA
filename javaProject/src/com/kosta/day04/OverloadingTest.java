package com.kosta.day04;

public class OverloadingTest {
	
	public static void sum(int a, int b) {
		System.out.println(a + b);
	}
	
	public static void sum(double a, double b) {
		System.out.println(a + b);
	}
	
	public static void sum(String a, String b) {
		System.out.println(a + b);
	}

	public static void main(String[] args) {
		sum(10, 20);			// 자동형변환돼서 에러 안남. 자동으로 double로됨
		sum("자바", "프로그램");
		sum(3.14, 10.5);
		sum(3.14f, 10.5f);		// float -> double로 자동형변환

	}

}