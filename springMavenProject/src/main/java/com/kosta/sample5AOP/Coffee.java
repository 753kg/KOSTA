package com.kosta.sample5AOP;

import org.springframework.stereotype.Component;

@Component
public class Coffee {
	
	public void add(int shot) {
		///
		System.out.println("Coffee " + shot + " 샷 추가");
		///
	}
}
