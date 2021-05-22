package com.kosta.day07;

public class JavaBook extends Book {

	// Book에 default생성자가 없어서 만들어야한다.
	public JavaBook(String title, int price) {
		super(title, price);
	}

	@Override
	void printContents() {
		System.out.println("자바책의 목차입니다.");
		
	}

	@Override
	void solveExample() {
		System.out.println("자바책의 예제입니다.");
		
	}

}
