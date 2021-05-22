package com.kosta.day04;

public class ShopService {
	
	// 자신의 객체를 생성해 초기화
	// private : 외부에서 생성자 호출을 막음.
	private static ShopService ss = new ShopService();
	
	private ShopService() {
		
	}
	
	static ShopService getInstance() {
		return ss;
	}
	
}
