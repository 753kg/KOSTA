package com.kosta.day02;

import java.util.Scanner;

public class ScannerTest {

	public static void main(String[] args) {
		method1();

	}

	private static void method1() {
		Scanner sc = new Scanner(System.in);	// 입력한 값을 받을 것
		System.out.print("이름 >> ");		// 띄어쓰기 하면 다음 변수로 들어감
		String name = sc.next();		// 단어로 읽음. 공백으로 분리
		System.out.print("나이 >> ");
		int age = sc.nextInt();

		sc.nextLine();					// 엔터 한 번 버리기
		System.out.print("주소 >> ");
		String addr = sc.nextLine();	// 
		
		System.out.println(name + " 의 나이는 " + age);
		System.out.println("주소는 " + addr);
		
		//next와 nextLine은 같이 안쓰는 게 좋다.
		
	}

}