package com.kosta.day06;

// 싱글톤 : 한번만 생성하겠다.
// JSP/Servlet : 서버에서 실행되는 자바프로그램
// Servlet : 싱글톤으로 사용된다.
public class ShopService {
	
	// class가 load될 때 new함.
	static ShopService shopService = new ShopService();
	
	// 객체를 생성하지 않고도 실행되어야 하기 때문에 static 붙음
	public static ShopService getInstance() {
//		if(shopService == null)
//			shopService = new ShopService();
		return shopService;
	}
}
