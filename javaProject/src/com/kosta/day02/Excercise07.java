package com.kosta.day02;

import java.util.Scanner;

public class Excercise07 {

	public static void main(String[] args) {
		// 예금, 출금, 조회, 종료 기능
		
		boolean run = true;
		
		int balance = 0;
		
		Scanner scanner = new Scanner(System.in);
		
		while(run) {
			System.out.println("-----------------------------");
			System.out.println("1.예금 | 2.출금 | 3.잔고 | 4.종료");
			System.out.println("-----------------------------");
			System.out.print("선택> ");
			
			int num = scanner.nextInt();
			if(num == 1) {
				System.out.print("예금액> ");
				int input = scanner.nextInt();
				balance = balance + input;
			}else if(num == 2) {
				System.out.print("출금액> ");
				int output = scanner.nextInt();
				if(output > balance) {
					System.out.println("잔액이 부족합니다.");
				}else {
					balance = balance - output; 
				}
			}else if(num == 3) {
				System.out.println("잔고> "+balance);
			}else if(num == 4) {
				break;
			}
		}
		
		System.out.println("프로그램 종료!!");

	}

}