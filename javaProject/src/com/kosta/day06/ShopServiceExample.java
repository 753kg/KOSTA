package com.kosta.day06;

public class ShopServiceExample {

	public static void main(String[] args) {
		
		ShopService service1 = ShopService.getInstance();
		ShopService service2 = ShopService.getInstance();
		
		if(service1 == service2) {
			System.out.println("같은 객체이다.");		// 주소가 같다.
		} else {
			System.out.println("다른 객체이다.");		// 주소가 다르다.
		}

	}

}
