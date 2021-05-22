package com.kosta.day02;

import java.util.Scanner;

/*
 4장LAB(if,for,scanner)
 */

// 실행 >java LAB
// JVM이 static load

public class LAB {

	public static void main(String[] args) {
		// 문제 1
		// test1();
		
		// 문제 2
		//hokeyGraphics('*', 3, true);
		//hokeyGraphics('&', 3, false);
		
		// 문제 3
		// triangle();
		
		// 4장LAB(For) 문제2
		// primePrint();
		
		// 4장LAB(For) 문제3
		factorialPrint();
	}
	
	
	private static void factorialPrint() {
		Scanner sc = new Scanner(System.in);
		System.out.print("1보다 크고 10보다 작은 정수를 입력하세요. : ");
		int num = sc.nextInt();		
		sc.close();
		
		if(num < 2 || num > 9) {
			System.out.println("잘못된 숫자가 입력되었습니다.");
		}else {
			for(int i=1; i<=num; i++) {
				int total = 1;
				for(int j=1; j<=i; j++) {
					total *= j;
				}
				System.out.println(i+" ! = "+total);
			}
		}
		
		
		for(int i=1; i<=num; i++) {
			int total = 1;
			for(int j=1; j<=i; j++) {
				total *= j;
			}
			System.out.println(i+" ! = "+total);
		}
	}


	private static void primePrint() {
		// 50 이하의 소수 출력하기
		System.out.print(2+" ");			// 2는 소수니까 그냥 출력
		AA:for(int i=3; i<50; i++) {	
			for(int j=2; j < i; j++) {
				if(i % j == 0) continue AA;	//3으로 나누어 떨어지면 4로 나눌 필요 없음
			}
			System.out.print(i+" ");
		}
		
		
	}


	private static void triangle() {
		Scanner sc = new Scanner(System.in);
		System.out.print("역삼각형 출력할 줄 수 : ");
		int num = sc.nextInt();		
		sc.close();
		
		for(int row=1; row<=num; row++) {
			for(int col=1; col<=num+1-row; col++) {
				System.out.print("*");
			}
			System.out.println();
		}
		/*
		for(int i=num; i>=1; i--) {
			for(int j=i; j>=1; j--) {
				System.out.print("*");
			}
			System.out.println();
		}
		*/
	}


	public static void hokeyGraphics(char cell, int size, boolean isRect){
		
		if(isRect) {	//true
			for(int low = 1; low <= size; low++) {	//줄
				for(int col = 1; col <= size; col++) { //칸
					System.out.print(cell);
				}
				System.out.println();	//줄바꾸기
			}
		}else {		//false
			for(int low = 1; low <= size; low++) {
				for(int col = 1; col <= low; col++) {
					System.out.print(cell);
				}
				System.out.println();
			}
		}
		
	}
	

	private static void test1() {
//		System.in 입력을 Scanner가 받음
		Scanner sc = new Scanner(System.in);
		System.out.print("숫자를 입력하세요. : ");
		int num = sc.nextInt();		
		sc.close();
		
		int start = 1;		// 홀수면 1부터 시작
		if(num % 2 == 0) {	// 짝수면 0부터 시작
			start = 0;
		}
		
		int total = 0;
		for(int i=start; i<=num; i+=2) {
						
			total += i;
			System.out.print(i);
			System.out.print(i==num?"=":"+");
		}
		System.out.println(total);
		
	}

}