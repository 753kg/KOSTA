package com.kosta.day11;

public class ConsumerThread extends Thread{
	
	DataBox dataBox;
	int count;
	
	public ConsumerThread(DataBox dataBox, int count) {
		this.dataBox = dataBox;
		this.count = count;
	}

	@Override
	public void run() {
		for(int i=0; i<count; i++) {
			System.out.println("Consumer Thread: " + dataBox.getData());
		}
	}
	
	

}
