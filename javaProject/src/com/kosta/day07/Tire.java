package com.kosta.day07;

public class Tire {
	
	int a = 10;
	
	public void run() {
		System.out.println("일반 타이어가 굴러갑니다.");
	}

	@Override
	public String toString() {
		return getClass().getSimpleName();
	}
	
}
