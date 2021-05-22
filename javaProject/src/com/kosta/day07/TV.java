package com.kosta.day07;

// 생성 목적이 아님. new 안함
// **규격서
// abstract class : 생성자정의가능(생성은안함) 
// interface : 생성자없음. 상수, 추상메서드만 가능. 일반메서드는 불가능 
public abstract class TV {
	
	// 1. 필드(변수, 상수)
	public static final String CHANNEL6 = "SBS";
	
	
	// 3. 일반메서드, 추상메서드
	public abstract void powerOn();
	public abstract void powerOff();
}
