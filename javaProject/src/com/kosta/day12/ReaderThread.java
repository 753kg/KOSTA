package com.kosta.day12;

public class ReaderThread extends Thread{
	MailBox box;
	int count;
	
	public ReaderThread(MailBox mailBox, int count) {
		setName("ReaderThread");
		this.box = mailBox;
		this.count = count;
	}

	@Override
	public void run() {
		for(int i=0; i<count; i++) {
			String name = getName();
			String m = box.getMessage();
			//System.out.println(name + "--> " + m);
			//System.out.println("--------------------------------");
		}
	}
	
	
}
