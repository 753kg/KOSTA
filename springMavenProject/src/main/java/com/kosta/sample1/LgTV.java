package com.kosta.sample1;

public class LgTV implements TV {
	
	public LgTV(String model, String company) {
		System.out.println(company + " " + model + " LgTV를 만든다");
	}
	
	public void powerOn() {
		System.out.println(getClass().getSimpleName() + " 전원을 켠다");
	}
	
	public void powerOff() {
		System.out.println(getClass().getSimpleName() + " 전원을 끈다");
	}
}
