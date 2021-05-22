package com.kosta.day11;

public class MainThreadExample {

	public static void main(String[] args) {

		// 공유 객체
		Calculator cal = new Calculator();
		
		Thread t1 = new User1("USER1-Thread", cal);
		Thread t2 = new User2("USER2-Thread", cal);
		
		t1.start();
		t2.start();
	}

}
