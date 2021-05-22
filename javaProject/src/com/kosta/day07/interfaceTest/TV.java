package com.kosta.day07.interfaceTest;

// interface : 규격서, 규칙
public interface TV {
	// 1. 상수(변경불가)
	public static final String CHANNEL6 = "SBS";
	String CHANNEL9 = "KBS";	// public static final 생략 가능. 무조건 상수
	
	// 2. 추상메서드
	public abstract void powerOn();
	void powerOff();			// public abstract 생략 가능. 무조건 추상
	
	// 3. default 메서드
	// 4. static 메서드
}
