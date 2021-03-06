package com.kosta.sample3;

import org.springframework.beans.factory.annotation.Required;

public class Car {
	String model;
	int price;
	
	public Car() {
		System.out.println("Car default 생성자...");
	}
	
	// DI(Dependency Injection) : 외부에서 값을 주면 내가 넣음
	public Car(String model, int price) {
		super();
		this.model = model;
		this.price = price;
		System.out.println("Car 생성자...");
	}

	public String getModel() {
		return model;
	}
	
	// 값을 반드시 입력해야한다
	@Required
	public void setModel(String model) {
		this.model = model;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public void carPrint() {
		System.out.println("car의 정보입니다.");
		System.out.println("차의 모델: " + model);
		System.out.println("차의 가격: " + price);
	}

	@Override
	public String toString() {
		return "Car [model=" + model + ", price=" + price + "]";
	}
	
	
}
