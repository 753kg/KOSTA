package com.kosta.day08;

public class Television implements RemoteControl {
	private int volume;

	@Override
	public void turnOn() {
		System.out.println("TV의 전원을 켠다.");
	}

	@Override
	public void turnOff() {
		System.out.println("TV의 전원을 끈다.");
	}

	@Override
	public void setVolume(int volume) {
		if(volume > RemoteControl.MAX_VALUE)
			this.volume = RemoteControl.MAX_VALUE;
		else if(volume < RemoteControl.MIN_VALUE)
			this.volume = RemoteControl.MIN_VALUE;
		else
			this.volume = volume;
		System.out.println("TV 현재 볼륨 : " + this.volume);
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Television [volume=").append(volume).append("]");
		return builder.toString();
	}
	
	

}
