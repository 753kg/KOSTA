package com.kosta.day09;

// Exception을 상속받으면 됨
public class MyException extends Exception{

	private static final long serialVersionUID = 1L;
	
	String message2;

	public MyException(String message){
		super(message);
		System.out.println("나의 Exception 생성자");
		this.message2 = message;
	}
	
	public void print() {
		System.out.println("예외 발생 : " + message2);
	}
}
