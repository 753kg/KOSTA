package com.kosta.day07;

public abstract class Book {
	private String title;
	private int price;
	
	public Book(String title, int price) {
		super();
		this.title = title;
		this.price = price;
	}

	// 목차가 없으므로 구현할 수 없다.
	abstract void printContents();	// 목차를 출력한다
	abstract void solveExample();	// 예제를 풀이한다.

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}
	
	
	
}
