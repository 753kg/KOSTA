package com.kosta.day04;

/*
 * Modifier(접근제한자)
 * 1) public		: 모든 패키지에서 접근 가능
 * 2) protected
 * 3) 생략(default)	: 같은 패키지만 접근 가능
 * 4) private		: 같은 클래스 내에서만 접근 가능 (정보은닉)
 */

public class Notebook extends Object{
	
	// 멤버변수: 
	// instance변수
	private String macAddress;		// 정보은닉, 캡슐화
	public String model;
	int price;
	// class변수
	private static int count;
	
	// 생성자메서드
	public Notebook(String macAddress, String model, int price) {
		super();	//부모 먼저 실행 후 자식 실행
		this.macAddress = macAddress;
		this.model = model;
		this.price = price;
		count++;
	}
	
	// 일반메서드 ...instance메서드
	public String getMacAddress(){
		return macAddress.substring(0, 3) + "*****";
		
	}
	
	public void setMacAddress(String macAddress) {
		this.macAddress = macAddress;
	}
	
	// 일반메서드 ...class메서드
	// new 안해도 호출할 수 있게
	public static int getCount() {
		return count;
	}

	// toString() 재정의. 주소X, 문자가 출력되게하려고
	// source > generate toSring()...
	@Override
	public String toString() {
		return "Notebook [macAddress=" + macAddress + ", model=" + model + ", price=" + price + "]";
	}
	
	
	
	
}