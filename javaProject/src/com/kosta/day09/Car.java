package com.kosta.day09;

import java.util.Arrays;

public class Car implements Cloneable{
	String model;
	int price;
	String[] 악세사리;
	
	
	
	public Car(String model, int price, String[] 악세사리) {
		super();
		this.model = model;
		this.price = price;
		this.악세사리 = 악세사리;
	}

	public Car(String model, int price) {
		super();
		this.model = model;
		this.price = price;
	}
	
	@Override
	protected Object clone() throws CloneNotSupportedException {
		Car car = (Car) super.clone();	// 얕은 복제, 배열은 복제가 안됨
		car.악세사리 = Arrays.copyOf(this.악세사리, this.악세사리.length);	// 배열 복제 ==> 깊은 복제
		return car;		// 자동형변환됨
	}

	// 내용이 같으면 hashCode가 똑같도록 재정의
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((model == null) ? 0 : model.hashCode());
		result = prime * result + price;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)	// 주소가 같은지 = 같은 객체를 참조하는지
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Car other = (Car) obj;
		if (model == null) {
			if (other.model != null)
				return false;
		} else if (!model.equals(other.model))
			return false;
		if (price != other.price)
			return false;
		return true;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Car [model=").append(model).append(", price=").append(price).append(", 악세사리=")
				.append(Arrays.toString(악세사리)).append("]");
		return builder.toString();
	}

	
	
	
	/*
	@Override
	public boolean equals(Object obj) {
		// 모델이 같으면 같다로 리턴
		// Car -> Object -> Car
		if(!(obj instanceof Car)) return false;
		Car c = (Car) obj;
		
		return model.equals(c.model) && price == c.price;	
		// String은 equals로 문자열 비교하기
		// 기본형은 == 으로 비교
	}

	@Override
	public int hashCode() {
		
		return model.hashCode();
		// model은 String이니까 내용이 같으면 같은 hashCode가 나옴
	}
	
	*/
	
	
	
}
