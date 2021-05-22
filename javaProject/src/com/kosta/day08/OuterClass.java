package com.kosta.day08;

public class OuterClass {
	// 1. field
	int java = 100;
	static int sql = 90;
	
	// 2. constructor
	
	// 3. method
	void test(final String param, String param2) {
		// final 생략해도 내부클래스에서 사용하면 final처럼 수정 불가능 
		final String localVar = "메서드 내의 지역변수";
		String localVar2 = "메서드 내의 지역변수... 내부클래스에서 사용 안함";
//		localVar = "aaa";	// 내부 클래스에서 사용되면 수정 불가능
//		param = "aaaa";		// 내부 클래스에서 사용되면 수정 불가능
		localVar2 = "수정 가능";
		param2 = "수정 가능... 내부 클래스에서 사용 안해서";
		// local inner class : method 내부에 있음
		// --------method 안에서만 사용 가능
		class LocalClass{	
			int price = 1000;
			// static int price2 = 2000; 	// 불가능
			void printPrice() {
				System.out.println("local instance method, price:"+price);
				System.out.println(param);
				System.out.println(localVar);	// 수정되는 변수는 사용 불가
				// param = "aaa";	// 수정 불가능
				//localVar = "aaa"; // 수정 불가능
			}
			/* 불가능
			static void printPrice2() {
				System.out.println("local instance method, price:"+price);
			}*/
		}
		
		LocalClass local = new LocalClass();
		System.out.println(local.price);
		local.printPrice();
		
	}
	
	// 4. static block
	
	// 5. inner class
	// instance inner class
	class InnerClass{
		int a = 10;	// instance 변수
		// static int b = 20; 		// 불가능
		
		InnerClass(){
			System.out.println("inner class 생성자");
		}
		
		void test() {
			System.out.println("inncer class instance method");
			System.out.println("outter의 instance field에 접근, java점수:" +java);
			System.out.println("outter의 static field에 접근, sql점수:" +sql);
		}
		/* 불가
		static void test2() {
			System.out.println("inncer class static method");
		}*/
	}
	
	// static inner class
	static class StaticInnerClass{
		int score = 100;
		static String grade = "A학점";
		
		StaticInnerClass(){
			System.out.println("StaticInnerClass 생성자");
		}
		
		void printScore() {
			System.out.println("instance method, score:"+score);
//			System.out.println("outter의 instance field에 접근, java점수:" +java);	//불가능
			System.out.println("outter의 static field에 접근, sql점수:" +sql);
		}
		
		static void printGrade() {
			System.out.println("static method, grade:"+grade);
//			System.out.println("outter의 instance field에 접근, java점수:" +java);	//불가능
			System.out.println("outter의 static field에 접근, sql점수:" +sql);
		}
		
	}
	
}
