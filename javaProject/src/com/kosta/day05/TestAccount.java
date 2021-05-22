package com.kosta.day05;


class Account{
	private String accNo;
	private int balance;
	
	Account(String accNo){
		this.accNo = accNo;
		String message =  " 개설되었습니다.";		 
		print(message);
	}	
	void save(int amount) {
		balance += amount;		
		String message = amount + "만원이 입금되었습니다.";
		print(message);		
	}
	void deposit(int amount) {
		balance -= amount;
		String message =  amount + "만원이 출금되었습니다.";
		print(message);
	}
	int getBalance(){
		return balance;
	}
	String getAccNo(){
		return accNo;
	}	
	void print(String message) {
		System.out.println(accNo + "계좌 " + message);
		//System.out.println(accNo + "계좌의 잔고는 " + balance  + "만원입니다.");
		System.out.println(getAccNo() + "계좌의 잔고는 " + 
				getBalance()  + "만원입니다.");		
	}
	
	
}

public class TestAccount {
	public static void main(String[] args) {
		Account a = new Account("078-3762-293");
		a.save(100);
		a.deposit(30);
		
		String s = new String("자바");
		System.out.println(s);
		System.out.println(s.toString());
		
		
		System.out.println(a);
		System.out.println(a.toString());
		
	}
   
}