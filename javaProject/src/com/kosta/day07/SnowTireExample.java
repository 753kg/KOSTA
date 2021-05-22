package com.kosta.day07;

public class SnowTireExample {

	public static void main(String[] args) {
		SnowTire snowTire = new SnowTire();
		Tire tire = snowTire;
		
		snowTire.run();
		tire.run();			// 재정의된 메서드가 실행된다.

	}

}
