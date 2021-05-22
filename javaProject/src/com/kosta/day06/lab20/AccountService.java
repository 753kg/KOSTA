package com.kosta.day06.lab20;
/**
 * 
 * @author KOSTA
 * Service : 업무 로직 작성
 */
public class AccountService {
	// 1. 계좌생성
	// 배열생성
	static final int MAX_LENGTH = 10;
	AccountDTO[] accountList = new AccountDTO[MAX_LENGTH];
	static int count = 0;
	public void createAccount(String ano, String owner, int balance) {
		if(count >= MAX_LENGTH) {
			AccountView.print("더 이상 계좌를 만들 수 없습니다.");
			return;
		}
		accountList[count] = new AccountDTO(ano, owner, balance);
		count++;
	}
	
	// 2. 계좌목록조회
	public void accountListDisplay() {
		AccountView.print(accountList);
	}
	
	// 3. 예금
	public void deposit(int index, int amount) {
		if(accountList[index] == null) {
			AccountView.print("존재하지않는 계좌입니다.");
			return;		// 함수를 빠져나감.
		}
		int balance = accountList[index].getBalance() + amount;
		accountList[index].setBalance(balance);
	}
	
	// 4. 출금
	public void withdraw(int index, int amount) {
		if(accountList[index] == null) {
			AccountView.print("존재하지않는 계좌입니다.");
			return;
		}
		int balance = accountList[index].getBalance() - amount;
		if(balance < 0) {
			AccountView.print("잔고가 부족합니다.");
			return;
		}
		accountList[index].setBalance(balance);
	}
	
	// 계좌 찾기
	AccountDTO findAccount(String ano) {
		for(AccountDTO a:accountList) {
			if(a.getAno().equals(ano)){
				return a;
			}
		}
		return null;
	}
}
