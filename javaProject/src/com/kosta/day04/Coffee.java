package com.kosta.day04;

public class Coffee {
	
	// field : instance변수 or class변수
	// instance변수 : new 할 때마다 만들어짐. object마다 존재. static 안붙음
	// class변수 : 객체들이 공유하는 변수, static 붙어있다.
	String menuName;
	int price;	
	static int count;	// instance들이 공유하는 변수
	
	Coffee(String menuName){
		this(menuName, 1000);
	}
	
	Coffee(String menuName, int price){
		System.out.println("감사합니다.");
		this.menuName = menuName;
		this.price = price;
		count++;
	}
	
	void print() {
		System.out.println("----주문서----");
		System.out.println("메뉴 : " + menuName);
		System.out.println("가격 : " + price);
	}
	
	// instance 메서드
	// new 해야만 사용 가능
	// static 아닌것에서 static 쓸 수 있다.
	int getCount() {
		System.out.println(menuName);	// 사용 가능
		return count;
	}
	
	// class 메서드
	// new 안해도 사용 가능
	static int getCount2() {
		// System.out.println(menuName);	// static인것에서 static아닌것은 사용불가능
		return count;
	}

}