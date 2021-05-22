package com.kosta.day07.interfaceTest;

// interface를 구현한 class
// interface내의 추상메서드는 반드시 구현할 의무가 있다.
public class KostaTV extends Object implements TV {
	
	public void display() {
		System.out.println("KostaTV에 추가된 함수이다.");
	}

	@Override
	public void powerOn() {
		System.out.println(getClass().getSimpleName() + "의 전원을 켠다.");
		System.out.println(CHANNEL6 + "채널을 본다.");
	}

	@Override
	public void powerOff() {
		System.out.println(CHANNEL9 + "채널을 보고있었다.");
		System.out.println(getClass().getSimpleName() + "의 전원을 끈다.");

	}

}
