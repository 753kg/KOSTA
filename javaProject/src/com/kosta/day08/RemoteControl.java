package com.kosta.day08;

public interface RemoteControl {
	
	// 1. 상수.. public static final 생략 가능
	public static final int MAX_VALUE = 10;
	int MIN_VALUE = 0;
	
	// 2. 추상메서드.. 정의만 있고 구현은 없다.
	// public abstract 생략 가능
	public abstract void turnOn();
	void turnOff();
	void setVolume(int volume);
	
	// 3. default method.. 구현 class들이 공통적으로 사용하는 기능을 구현
	default void setMute(boolean mute) {
		if(mute) {	// mute가 true이면
			System.out.println("무음 처리합니다.");
		}else {
			System.out.println("무음 해제합니다.");
		}
	}
	
	// 4. static method.. interface의 method. 구현class의 method가 아니다.
	// 호출 방법 => RemoteControl.changeBattery();
	// 리모컨의 배터리를 교체
	static void changeBattery() {
		System.out.println("건전지를 교체합니다.");
	}
	
	

}
