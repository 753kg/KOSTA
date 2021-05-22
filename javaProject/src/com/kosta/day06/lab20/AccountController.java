package com.kosta.day06.lab20;

import java.util.Scanner;
/**
 * 
 * @author KOSTA
 * Controller : 사용자의 요청을 받아서 service에 전달한다.
 * service에서 결과를 받아서 받은 결과를 사용자에게 응답한다.
 */

public class AccountController {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		boolean run = true;
		
		AccountService service = new AccountService();
		
		while(run) {
			System.out.println("============================================");
			System.out.println("1.계좌생성 | 2.계좌목록 | 3.예금 | 4.출금 | 5.종료");
			System.out.println("============================================");
			System.out.print("선택> ");
			int key = sc.nextInt();
			switch (key) {
			case 1:
				System.out.print("계좌번호 예금주 잔고>> ");
				service.createAccount(sc.next(), sc.next(), sc.nextInt());
				break;
			case 2:
				service.accountListDisplay();
				break;
			case 3:{//지역변수만들기
				System.out.print("입금할 계좌번호와 금액>> ");
				int index = sc.nextInt();
				int amount = sc.nextInt();
				service.deposit(index, amount);
				break;
			}
			case 4:{
				System.out.print("출금할 계좌번호와 금액>> ");
				int index = sc.nextInt();
				int amount = sc.nextInt();
				service.withdraw(index, amount);
				AccountView.print(amount+"원이 출금되었습니다.");
				break;
			}
			default:
				System.out.println("작업이 종료되었습니다.");
				run = false;
				break;
			}
		}
		
		sc.close();
	}

}
