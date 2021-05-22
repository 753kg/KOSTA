package com.kosta.day04;

import java.util.Scanner;

public class BankApplication {
	
	private static Account[] accountArray = new Account[100];
	private static Scanner scanner = new Scanner(System.in);
	static int accountIndex = 0;
	
	public static void main(String[] args) {
		
		boolean run = true;
		while(run) {
			System.out.println("----------------------------------------------");
			System.out.println("1.계좌생성 | 2.계좌목록 | 3.입금 | 4.출금 | 5.종료");
			System.out.println("----------------------------------------------");
			System.out.print("선택> ");
			
			int selectNo = scanner.nextInt();
			scanner.nextLine();
			
			if(selectNo == 1) {
				createAccount();
			}else if(selectNo == 2) {
				accountList();
			}else if(selectNo == 3) {
				deposit();
			}else if(selectNo == 4) {
				withdraw();
			}else if(selectNo == 5) {
				run = false;
			}
		}
		System.out.println("프로그램 종료!!");
		

	}

	private static void createAccount() {
		System.out.println("-------");
		System.out.println("계좌생성");
		System.out.println("-------");
		
		System.out.print("계좌번호: ");
		String accountNumber = scanner.nextLine();
		
		System.out.print("계좌주: ");
		String accountOwner = scanner.nextLine();
		
		System.out.print("초기입금액: ");
		int deposit = scanner.nextInt();
		
		accountArray[accountIndex] = new Account(accountNumber, accountOwner, deposit);
		accountIndex++;
		System.out.println("결과: 계좌가 생성되었습니다.");
		
	}

	private static void accountList() {
		System.out.println("-------");
		System.out.println("계좌목록");
		System.out.println("-------");
		
		for(int i=0; i<accountIndex; i++) {
			System.out.println(accountArray[i].getAno() + "\t" + accountArray[i].getOwner() + "\t" + accountArray[i].getBalance());
		}
		
	}

	private static void deposit() {
		System.out.println("-------");
		System.out.println("예금");
		System.out.println("-------");
		
		System.out.print("계좌번호: ");
		String aNo = scanner.nextLine();
		
		System.out.print("예금액: ");
		int deposit = scanner.nextInt();
		
		Account ac = findAccount(aNo);
		int balance = ac.getBalance() + deposit;
		ac.setBalance(balance);
		
		System.out.println("결과: 예금이 성공되었습니다.");
		
//		for(int i=0; i<accountIndex; i++) {
//			if(aNo.equals(accountArray[i].getAno())) {
//				int balance = accountArray[i].getBalance() + deposit;
//				accountArray[i].setBalance(balance);
//				System.out.println("결과: 예금이 성공되었습니다.");
//				return;
//			}
//		}
//		System.out.println("일치하는 계좌번호가 없습니다.");
		
	}

	private static void withdraw() {
		System.out.println("-------");
		System.out.println("출금");
		System.out.println("-------");
		
		System.out.print("계좌번호: ");
		String aNo = scanner.nextLine();
		
		System.out.print("출금액: ");
		int withdraw = scanner.nextInt();
		
		Account ac = findAccount(aNo);
		int balance = ac.getBalance() - withdraw;
		ac.setBalance(balance);
		System.out.println("결과: 출금이 성공되었습니다.");
		
//		for(int i=0; i<accountIndex; i++) {
//			if(aNo.equals(accountArray[i].getAno())) {
//				int balance = accountArray[i].getBalance() - withdraw;
//				accountArray[i].setBalance(balance);
//				System.out.println("결과: 출금이 성공되었습니다.");
//				return;
//			}
//		}
//		System.out.println("일치하는 계좌번호가 없습니다.");
//		
	}
	
	private static Account findAccount(String ano) {
		Account a = null;
		for(int i=0; i<accountIndex; i++) {
			if(ano.equals(accountArray[i].getAno())) {
				a = accountArray[i];
			}
		}
		return a;
	}

}