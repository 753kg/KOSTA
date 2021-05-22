package com.kosta.day06;

public class CarTest {

	public static void main(String[] args) {
		
		// class method 호출
		System.out.println(Car.getCompany());
		System.out.println(Car.getCount());
		
		Car c1 = new Car();
		// instance method 호출
		System.out.println(c1.getSpeed());
		c1.print();
		
		Car c2 = new Car(100,true,2020);
		c2.print();
	}

}
