package com.kosta.day11;

public class TransferThread extends Thread{

	ShareAccount shareAccount;
	
	public TransferThread(ShareAccount shareAccount) {
		this.shareAccount = shareAccount;
	}

	@Override
	public void run() {
		for(int i=1; i<=3; i++) {
			System.out.println("잔액합계:" + shareAccount.getTotal());
		}
	}
	
	
}
