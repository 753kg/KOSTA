package com.kosta.day12;

public class MailBox {
	private String message;
	
	public MailBox() {
		
	}
	
	public synchronized String getMessage() {
		if(this.message == null) {		// this. 꼭 해야함
			try {
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		// setMessage가 깨워주면 아래 코드 수행
		System.out.println("메시지 읽음: " + message);
		String returnValue = message;	// 메시지 읽은 후 비우기
		message = null;
		notify();			// wait 상태를 깨우기
		return returnValue;
	}

	public synchronized void setMessage(String message) {
		if(this.message != null) {
			try {
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		// this.message가 비어있으면 쓴다.
		this.message = message;
		notify();
		System.out.println("메시지 쓰기: " + message);
	}
}
