package com.kosta.day11;

// 생산자 쓰레드
public class ProducerThread extends Thread{
	
	DataBox dataBox;	// 공유하는 객체
	String[] message;
	
	public ProducerThread(DataBox dataBox, String[] message) {
		this.dataBox = dataBox;
		this.message = message;
	}

	@Override
	public void run() {
		for(int i=0; i<message.length; i++) {
			dataBox.setData(message[i]);
		}
	}
	
	

}
