package com.kosta.day08;

// 다중 인터페이스 구현 클래스
public class SmartTelevision implements RemoteControl, Serchable {

	@Override
	public void search(String url) {
		System.out.println(url + " search합니다.");

	}

	@Override
	public void turnOn() {
		System.out.println("SmartTelevision class의 turnOn 메서드");

	}

	@Override
	public void turnOff() {
		System.out.println("SmartTelevision class의 turnOff 메서드");

	}

	@Override
	public void setVolume(int volume) {
		System.out.println("SmartTelevision class의 setVolume 메서드");

	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("SmartTelevision []");
		return builder.toString();
	}
	
	

}
