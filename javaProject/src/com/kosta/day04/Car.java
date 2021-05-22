package com.kosta.day04;

// class : object를 만드는 틀이다. template, 설계도, 붕어빵틀
//			클래스는 변수와 메서드들의 묶음이다.
// object : class를 이용해서 만든 독립된 개체이다. 독립된 특징을 갖고 있음.
// instance : object 실체. object=instance
public class Car {
	// 1. 특징 (멤버변수, 필드)
	// 객체마다 각각 가진다.
	String model;
	int year;
	int price;
	String color;
	String company = "현대자동차";
	
	// 2. 생성자 메서드 : 생성시(new) 자동으로 실행됨. 
	// 생성자는 반드시 class 이름과 같아야한다.
	// return을 가질 수 없음. (값이 없는게 아님)
	// 목적 : 변수 초기화
	// 오버로딩(이름 같고 매개변수 다름), 다형성(이름은 똑같은데 형태가 여러가지)
	// this : 현재 객체를 의미. new한 객체의 model, price ..
	// 매개변수와 멤버변수(필드)가 충돌되는 경우 
	// 생성자가 여러개 있다 -> 하나의 생성자가 다른 생성자를 호출.
	public Car(){
		// this() : 호출
		this("모델미결정",2000);
		System.out.println("(default)자동차가 생성됩니다.");
	}
	
	public Car(String model){
		this(model, 4000);
		System.out.println("(parameter1)자동차가 생성됩니다.");
	}
	
	public Car(String model, int price){
		System.out.println("(parameter2)자동차가 생성됩니다.");
		this.model = model;		// 현재 객체의 model = 매개변수
		this.price = price;
	}
	
	// 3. 기능 (메서드, 함수)
	void go() {
		System.out.println("자동차가 앞으로 간다.");
	}
	
	void back() {
		System.out.println("자동차가 뒤로 간다.");
	}
	

}