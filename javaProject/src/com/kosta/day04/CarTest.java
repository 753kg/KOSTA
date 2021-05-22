package com.kosta.day04;

public class CarTest {

	public static void main(String[] args) {
		// 1. 객체 참조 변수 선언
		int[] arr;
		Car c1;			// Car : data type, c1에 Car를 담을것이다.
		int i;
		
		// 2. 객체 생성 ...자동초기화됨.
		arr = new int[5];
		c1 = new Car();		
		// c1 : object, instance 주소가 들어 있음
		// new Car() : heap영역에 instance 생성됨. 실체
		
		// 3. 객체 사용
		arr[0] = 100;
		i = 10;
		System.out.println("arr의 주소: "+arr);	// 주소가 나옴
		System.out.println("c1의 주소: "+c1);		// 주소가 나옴
		
		// 필드는 자동으로 초기화된다.
		System.out.println("c1의 color: "+c1.color);
		System.out.println("c1의 model: "+c1.model);
		System.out.println("c1의 price: "+c1.price);
		System.out.println("c1의 year: "+c1.year);
		
		Car c2 = new Car();
		c2.color = "black";
		c2.model = "그랜져";
		c2.price = 5000;
		c2.year = 2021;
		
		System.out.println("c2의 color: "+c2.color);
		System.out.println("c2의 model: "+c2.model);
		System.out.println("c2의 price: "+c2.price);
		System.out.println("c2의 year: "+c2.year);
		
		// 1. 객체 참조 변수 선언
		String s1;
		// 2. 객체 생성
		s1 = new String("java");		// 주소를 s1에 담음
		// 3. 객체에 접근
		System.out.println(s1.charAt(0));	//0번째 한글자만 찍어라

	}

}