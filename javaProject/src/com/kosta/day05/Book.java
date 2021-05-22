package com.kosta.day05;

//업무로직(business logic)없다. 
//DTO(Data Transfer Object) : 데이터를 전송하기위한 객체 
//VO(Value Object) : 값을 넣는 가방이다. 
//Beans기술: 변수는  private접근지정자, 메서드는 public접근지정자
//     getter/setter제공,default생성자필수  
public class Book {
	private String title;
	private int price;
	public Book() {
		//default생성자 
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
