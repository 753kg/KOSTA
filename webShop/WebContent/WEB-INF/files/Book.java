package com.kosta.day05;
// IO 연습용. 자바소스 아님
public class Book {
	private String title;
	private int price;
	public Book() {
		//default?앹꽦??
	}
	public Book(String title, int price) {
		super();
		this.title = title;
		this.price = price;
	}
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
