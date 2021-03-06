package com.kosta.sample1;

public class Car {
	String model;
	int price;
	
	// DI(Dependency Injection) : 외부에서 값을 주면 내가 넣음
	public Car(String model, int price) {
		super();
		this.model = model;
		this.price = price;
		System.out.println("Car 생성자...");
	}

	public void carPrint() {
		System.out.println("car의 정보입니다.");
		System.out.println("차의 모델: " + model);
		System.out.println("차의 가격: " + price);
	}
}
