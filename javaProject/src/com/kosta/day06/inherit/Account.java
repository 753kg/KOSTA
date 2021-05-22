package com.kosta.day06.inherit;

public class Account {
	private String accNo;
	private String ownerName;
	private int balance;
	
	
	public Account(String accNo, String ownerName, int balance) {
		this.accNo = accNo;
		this.ownerName = ownerName;
		this.balance = balance;
	}

	public void deposit(int amount) {
		balance += amount;
	}
	
	public int withdraw(int amount) {
		if(amount > balance) {
			System.out.println("잔액이 부족합니다. 잔액: " + balance);
			return 0;
		}
		balance -= amount;
		return amount;
	}

	@Override
	public String toString() {
		return "Account [accNo=" + accNo + ", ownerName=" + ownerName + ", balance=" + balance + "]";
	}
	
}
