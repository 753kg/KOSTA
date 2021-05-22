package com.kosta.day13.view;

import java.util.List;

import com.kosta.day13.model.CustomerDTO;

// 목적 : 고객 정보 보여주기
// 나중에는 Web으로 전환... HTML, CSS 이용
public class CustomerView {
	
	// 다형성, 오버로딩
	public static void display(List<CustomerDTO> custlist) {	// 고객 정보가 여러 건 들어온다.
		System.out.println("*****고객정보 여러건*****");
		for(CustomerDTO cust:custlist) {
			System.out.println(cust);
		}
	}
	
	public static void display(CustomerDTO cust) {	// 고객 정보가 한건 들어온다.
		System.out.println("*****고객정보 1건*****");
		System.out.println(cust);
	}
	
	public static void display(String message) {
		System.out.println(message);
	}
}
