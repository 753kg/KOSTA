package com.kosta.day08;

public class ClassRoom {	//Outer Class
	
	String title1 = "instance변수";
	static String title2 = "static변수";
	
	// Inner Class 종류
	// 1. instance inner class
	class Desk{
		String title3 = "instance inner class instance변수";
//		불가 static String title4 = "instance inner class static변수";
	}
	
	// 2. static inner class
	static class Chair{
		String title5 = "static inner class instance변수";
		static String title6 = "static inner class static변수";
	}
	
	// 3. local inner class
	void test(String param, String param2) {	// param : 로컬변수
		// 메서드 안에 있는 변수는 로컬 변수
		String title8 = "local 변수";
		String title9 = "local 변수";
//		param = "로컬클래스에서 사용되면 수정 불가능";		// final String param. final이 생략됨
		param2 = "사용한 적 없으면 수정 가능";
//		title8 = "로컬클래스에서 사용되면 수정 불가능";	// final String title8. 로컬에서 사용되면 final이다.
		title9 = "변수 수정 가능";
		
		class Computer{		// local class는 static 붙일 수 없음
			String title7 = "local inner class instance변수";
//			불가 static String title8 = "local inner class static변수";
			
			void print() {
				System.out.println(param);
				System.out.println(title8);
			}
		}
		
		// 로컬 클래스 사용
		Computer c = new Computer();
		c.print();
		System.out.println(c.title7);
		
	}

}
