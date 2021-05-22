package com.kosta.day06.inherit;

// 자식이 부모를 선택한다.
public class Child extends Parent{
	// 자식이 추가한 변수
	int b = 20;
	// 재정의 : 부모가 물려준 것 재정의
	String a = "자바";	// Parent에서 a는 int였지만 Child에서는 String
	
	// 자식의 생성자
	Child(){
		super();	// 안써도 자동으로 부모를 생성함.
		System.out.println("자식의 생성자");
	}
	
	// 재정의(Override), 덮어쓰기
	// Override : 이름 같고 매개변수 개수, 타입도 같아야함.
	// 매개변수가 다르면 Overloading
	@Override
	void method1() {
		System.out.println("재정의한 메서드");
	}
	
	// 자식이 추가한 메서드
	void parentPrint() {
		// 부모에게 물려받은 변수 사용
		System.out.println("a= " + a);
		// 부모에게 물려받은 메서드 호출
		method1();
	}
	
	
}
