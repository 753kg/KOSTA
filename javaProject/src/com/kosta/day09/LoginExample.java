package com.kosta.day09;

import java.util.Scanner;

public class LoginExample {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("ID 입력>> ");
		String id = sc.next();
		System.out.print("PASS 입력>> ");
		String pass = sc.next();
		try {
			login(id, pass);
		} catch (NotExistIDException | WrongPasswordException e) {
			System.out.println(e.getMessage());
		}
		
		sc.close();
	}

	private static void login(String id, String pass) throws NotExistIDException, WrongPasswordException {
		if(!id.equals("blue")) {
			throw new NotExistIDException("ID가 틀렸습니다.");
		}
		if(!pass.equals("12345")) {
			throw new WrongPasswordException("PASS가 틀렸습니다.");
		}
		// id, pass가 맞으면
		System.out.println("로그인 성공!!!");
	}

}
