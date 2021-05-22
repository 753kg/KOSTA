package com.kosta.day05;


class Calculator{
	//1.멤버변수(field):non-static(instance변수), static(class변수)
	static double pi = 3.14;
	String color;
	//2.생성자
	//3.메서드:non-static(instance메서드), static(class메서드)
	int plus(int a, int b) {
		return a+b;
	}
	static int minus(int a, int b) {
		return a-b;
	}
	//4.static block, instance block(생성자와 유사) 
	{
		System.out.println("instance block....new시에 자동실행1");
	}
	{
		System.out.println("instance block....new시에 자동실행2");
	}
	static {
		System.out.println("static block1");
	}
	static {
		System.out.println("static block2");
		System.out.println(pi);
		//instance변수 사용불가 System.out.println(color);
		minus(10, 20);
		//instance메서드 사용 불가 plus(10,20);
		//this사용 불가  this.pi = 3;
	}
	
	
	
	//5.inner class
}

public class StaticTest {
	public static void main(String[] args) {
		System.out.println(Calculator.pi); //좋은표현 
		Calculator cal1 = new Calculator();
		Calculator cal2 = new Calculator();
		Calculator.pi = 3.141592;
		cal1.color = "red";
		cal2.color = "blue";
		System.out.println(cal1.pi);//바람직한 사용아님
		System.out.println(cal2.pi);//바람직한 사용아님
		System.out.println(Calculator.pi); //좋은표현 
		System.out.println(cal1.color + ":" + cal2.color);
		System.out.println("-------------------------");
		System.out.println("instace메서드 호출:"+ cal1.plus(10,20));
		System.out.println("static메서드 호출:"+ cal1.minus(10,20));//바람직한 사용아님
		System.out.println("static메서드 호출:"+ 
		                    Calculator.minus(10,20));//좋은표현 

	}

}