package com.kosta.day03;

import java.util.Scanner;

/*
 *  >java Review
 *  1. Review class가 메모리에 load됨 .....byte code가 메서드영역에 들어감
 *  2. main 호출됨
 */

public class Review {
	public static void test() {
		int a = 10;
		int b = 20;
	}
	public static void main(String[] args) {
		test();
		
		//4장 LAB scanner, datatype
		
		Scanner sc = new Scanner(System.in);
		System.out.print("[더 입력할 점수가 없으면 -1을 입력] ");
		
		int count = 0;
		double total = 0;
		
		while(true) {
			
			System.out.print("점수를 입력하십시오 : ");
			double score = sc.nextDouble();
			
			if(score == -1) break;
			
			count++;
			total += score;
			
		}
		
		double avg = total / count;
		System.out.println("입력된 점수들의 수 : " + count);
		System.out.println("점수들의 평균(double value) : " + avg);
		System.out.println("점수들의 평균(int value) : " + (int)avg);
		
		sc.close();

	}

}