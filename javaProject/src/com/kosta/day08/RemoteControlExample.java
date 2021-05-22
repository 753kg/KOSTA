package com.kosta.day08;

public class RemoteControlExample {

	public static void main(String[] args) {
		method1(new Television());
//		method3();					// SmartTelevision
		
		
		// Interface를 구현한 익명의 class
		// 한번 쓰고 버릴 일시적인 class일 때
		// new RemoteControl();		// interface는 객체생성 불가능
		// 익명클래스정의 -> 추상클래스 구현 -> 세미콜론
		// RemoteControl을 구현해서 만든 클래스인데 이름이 없어서 익명클래스
		/*
		method1(new RemoteControl() {

			@Override
			public void turnOn() {
				System.out.println("익명 class... 전원 켜기");
			}

			@Override
			public void turnOff() {
				System.out.println("익명 class... 전원 끄기");
			}

			@Override
			public void setVolume(int volume) {
				System.out.println("익명 class... 볼륨 조절 " + volume);
			}
			
		});		// 세미콜론 꼭 붙어야 함
		*/
	}

	private static void method4(RemoteControl a) {
		// SmartTelevision의 instance : SmartTelevision, RemoteControl, Serchable 다 됨
		if(a instanceof Serchable)
			((SmartTelevision)a).search("http://www.daum.net");
		a.setMute(false);
		a.setVolume(10);
		a.turnOn();
		a.turnOff();
		System.out.println("************************");
	}

	private static void method3() {
		SmartTelevision a = new SmartTelevision();
		RemoteControl a2 = new SmartTelevision();
		RemoteControl a3 = new Television();
		method4(a);
		method4(a2);
		method4(a3);
	}


	private static void method1(RemoteControl remote) {
		remote.turnOn();
		remote.setVolume(20);
		remote.setMute(true);
		remote.setMute(false);
		remote.turnOff();
		
		RemoteControl.changeBattery();
		
	}

}
