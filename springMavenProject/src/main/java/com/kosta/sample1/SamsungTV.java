package com.kosta.sample1;

public class SamsungTV implements TV {
	
	public SamsungTV() {
		System.out.println("SamsungTV default 생성자");
	}
	
	public SamsungTV(String model) {
		System.out.println(model + " SamsungTV를 만든다");
	}
	
	public void powerOn() {
		System.out.println(getClass().getSimpleName() + " 전원을 켠다");
	}
	
	public void powerOff() {
		System.out.println(getClass().getSimpleName() + " 전원을 끈다");
	}
}
