package com.kosta.day04;

public class CoffeeShop {

	public static void main(String[] args) {
		
		System.out.println(Coffee.count + "개 주문됨");	//new 안해도 사용 가능
		
		System.out.println(Coffee.getCount2());
		
		Coffee order1 = new Coffee("아메리카노", 2000);
		Coffee order2 = new Coffee("카페라떼", 3000);		// shop마다 가격이 달라서 직접 정함.
		Coffee order3 = new Coffee("오늘의 커피");			// 오늘의 커피는 가격이 정해져있음
		
		order1.print();		// 당신이 주문하신 메뉴는 아메리카노이고, 가격은 2000원 입니다.
		order2.print();
		order3.print();
		
		System.out.println(order1.count);	// new를 해야만 사용할 수 있음.
		System.out.println(order2.count);	// 좋은 접근이 아니다.
		System.out.println(order3.count);
		System.out.println(Coffee.count + "개 주문됨");	//static변수 호출시 바람직한 방법
		
		System.out.println(order1.getCount());
		System.out.println(order1.getCount2());		// 좋은 접근이 아니다.
		System.out.println(Coffee.getCount2());		// 좋은 접근이다.

	}

}