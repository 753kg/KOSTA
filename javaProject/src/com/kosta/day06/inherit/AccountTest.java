package com.kosta.day06.inherit;

public class AccountTest {

	public static void main(String[] args) {
		
		//method1();
		method2();
		

	}

	private static void method2() {
		CheckingAccount account = new CheckingAccount("222-2222", "lee", 1000, "2222");
		account.deposit(2000);
		System.out.println(account.withdraw(50000)+"원 출금");
		System.out.println(account);
		System.out.println(account.pay("2222", 5000)+"원 출금");
		System.out.println(account);
		
	}

	private static void method1() {
		Account account = new Account("111-1111", "kim", 1000);
		account.deposit(2000);
		System.out.println(account.withdraw(500)+"원 출금");
		System.out.println(account);
		
	}

}
