package com.kosta.day07;

public class SpringBook extends Book {
	
	public SpringBook(String title, int price) {
		super(title, price);
	}

	@Override
	void printContents() {
		System.out.println("스프링책의 목차입니다.");
		
	}

	@Override
	void solveExample() {
		System.out.println("스프링책의 예제입니다.");
		
	}
}
