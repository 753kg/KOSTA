package com.kosta.day09;

public class CellPhone {
	String model;
	double battery;
	
	public CellPhone(String model) {
		super();
		this.model = model;
	}
	
	void call(int time) {
		if(time < 0) throw new IllegalArgumentException("통화시간입력오류");
		battery -= time * 0.5;
		if(battery < 0) battery = 0;
		System.out.println("통화 시간 : " + time + "분");
	}
	
	void charge(int time) {
		if(time < 0) throw new IllegalArgumentException("충전시간입력오류");
		System.out.println("충전 시간 : " + time + "분");
		battery += time * 3;
		if(battery > 100) battery = 100;
	}
	
	void printBattery() {
		System.out.println("남은 배터리 양 : " + battery);
	}

	@Override
	public boolean equals(Object otherObject) {
		if(otherObject == null || !(otherObject instanceof CellPhone)) // null일때 인스턴스뭔지 확인할 필요 없이 빠르게 false
			return false;
		CellPhone p = (CellPhone)otherObject;
		return model.equals(p.model);
	}
	
}
