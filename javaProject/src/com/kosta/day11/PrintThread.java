package com.kosta.day11;

public class PrintThread extends Thread{

	ShareAccount shareAccount;
	
	public PrintThread(ShareAccount shareAccount) {
		this.shareAccount = shareAccount;
	}

	@Override
	public void run() {
		for(int i=1; i<=12; i++) {
			shareAccount.transfer();
		}
	}
	
	
}
