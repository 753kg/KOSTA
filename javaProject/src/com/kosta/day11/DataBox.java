package com.kosta.day11;

// 여러 쓰레드(생산자쓰레드, 소비자쓰레드)가 공유하는 데이터
public class DataBox {
	
	private String data;
	
	// wait, notify --> synchronized
	public synchronized String getData() {
		if(this.data == null) {	// data가 아직 안만들어졌다면 기다리기
			try {
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		// 깨워주면 내려옴
		String returnValue = data;	// clear 하려고
		System.out.println("소비자 쓰레드가 읽은 데이터: " + returnValue);
		data = null;	// clear
		notify();		// wait상태의 쓰레드가 있다면 깨우기
		return returnValue;
	}

	public synchronized void setData(String data) {
		if(this.data != null) {	// data를 아직 안읽어갔다면
			try {
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		this.data = data;
		System.out.println("생산자가 만든 데이터: " + data);
		notify();		// 소비자 깨우기
	}
	
	
}
