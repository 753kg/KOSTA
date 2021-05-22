package com.kosta.day12;

public class WriterThread implements Runnable{
	
	MailBox box;
	String[] messages;
	String name;
	
	public WriterThread(MailBox box, String[] messages) {
//		Thread.currentThread().setName("WriterThread");		// 안됨
		this.name = "WriterThread";
		this.box = box;
		this.messages = messages;
	}
	
	@Override
	public void run() {
		for(String s:messages) {
			box.setMessage(s);
			//System.out.println(name + "--> " + s);
			//System.out.println("***********************************");
		}
	}
	
}
