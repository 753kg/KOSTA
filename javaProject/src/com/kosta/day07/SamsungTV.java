package com.kosta.day07;

public class SamsungTV extends TV {

	@Override
	public void powerOn() {
		System.out.println(getClass().getSimpleName() + "의 전원을 켠다.");
	}

	@Override
	public void powerOff() {
		System.out.println(getClass().getSimpleName() + "의 전원을 끈다.");
	}
	
	public void display() {
		System.out.println(getClass().getSimpleName() + "의 display 추가 기능");
	}

}
