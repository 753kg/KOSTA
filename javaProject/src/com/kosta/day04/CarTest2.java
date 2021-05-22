package com.kosta.day04;

public class CarTest2 {

	// main은 무조건 public static void
	public static void main(String[] args) {
//		test1();
		test2();

	}

	private static void test2() {
		Car c1 = new Car("BMW520", 7000);
		Car c2 = new Car();
		Car c3 = new Car("SM7");
		
		System.out.println(c1.model);
		System.out.println(c1.price);
		System.out.println("------------");
		System.out.println(c2.model);
		System.out.println(c2.price);
		System.out.println("------------");
		System.out.println(c3.model);
		System.out.println(c3.price);
		
	}

	static void test1() {
		Car c1 = new Car();
		Car c2 = new Car();
		System.out.println(c1.company);
		System.out.println(c2.company);
		c1.model = "ABC";
		c2.model = "DDD";
		System.out.println(c1.model);
		System.out.println(c2.model);
		c1.company = "기아자동차";
		System.out.println(c1.company);
		System.out.println(c2.company);
	}

	// void : return 값이 없다.
	void method2() {
		System.out.println("method 연습");
		//return;
		
	}
	
	int method1() {
		System.out.println("method 연습");
		return 1;
		
	}

}