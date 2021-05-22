package com.kosta.day05;

public class ShopService {
	static ShopService service;
	
	private ShopService() {
		
	}
	static ShopService getInstance(){
		if(service == null)
		    service = new ShopService();
		return service;
	}
}
