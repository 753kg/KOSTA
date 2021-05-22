package com.kosta.day13.review.view;

import java.util.List;

import com.kosta.day13.review.model.CustomerDTO;


public class CustomerView {
	
	public static void display(List<CustomerDTO> custlist) {
		for(CustomerDTO cust:custlist) {
			System.out.print("ID: " + cust.getCustId() + "\t");
			System.out.println("이름: " + cust.getCustName());
		}
	}
	
	public static void display(CustomerDTO cust) {
		System.out.println(cust);
	}
	
	public static void display(String message) {
		System.out.println(message);
	}
}
