package com.kosta.day07;

public class AccountTest {

	public static void main(String[] args) {
//		method1();
//		method2();
//		method3();
		method4();
//		method5();

	}
	
	private static void method5() {
		BonusAccount acc = new BonusAccount("555", "lee", 10000, 50);
		acc.deposit(2000);
		acc.deposit(2000);
		System.out.println(acc.bonusPoint + "포인트");
		System.out.println(acc);
	}

	private static void method4() {
		CreditLineAccount acc = 
				new CreditLineAccount("112-1555",
						"홍길동",1000, 500);
		acc.deposit(2000);
		System.out.println(acc.withdraw(3500) + "출금");
		System.out.println(acc);
		
	}

	private static void method3() {
		// CheckingAccount를 new하면
		// Object 생성 -> Account 생성 -> CheckingAccount 생성됨
		CheckingAccount acc = new CheckingAccount("111", "kim", 1000, "5555");
		
		// 자식클래스는 부모클래스의 타입이기 때문에 "자식클래스 객체 instanceof 부모클래스 타입"은 true가 됩니다.
		System.out.println(acc instanceof Object);
		System.out.println(acc instanceof Account);
		System.out.println(acc instanceof CheckingAccount);
		
		System.out.println(acc);
		acc.deposit(2000);
		System.out.println(acc.withdraw(500));
		System.out.println(acc.pay("5555", 200));
		System.out.println(acc);
	}
	
	private static void method2() {
		CheckingAccount acc = new CheckingAccount();
		acc.setAccNo("111");
		acc.setOwnerName("kim");
		acc.setBalance(1000);
		//acc.setCardNo("5555");
		System.out.println(acc);
		
		acc.deposit(2000);
		System.out.println(acc.withdraw(500));
		System.out.println(acc.pay("5555", 200));
		System.out.println(acc);
	}

	private static void method1() {
		Account acc = new Account();
		acc.setAccNo("111");
		acc.setOwnerName("kim");
		acc.setBalance(1000);
		System.out.println(acc);
		
		acc.deposit(2000);
		System.out.println(acc.withdraw(500));
		System.out.println(acc);
	}

}
