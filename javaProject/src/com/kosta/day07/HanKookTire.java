package com.kosta.day07;

public class HanKookTire extends Tire{
	
	int hankook = 20;
	
	// 부모거를 자동으로 호출
	@Override
	public String toString() {
		return getClass().getSimpleName();		//this.getClass() ==> HanKookTire
	}
}
