package com.kosta.day02;

import java.util.Scanner;

public class LeapYear {

	public static void main(String[] args) {
		// 년도, 월에 해당하는 말일 계산
		// 1. 4의 배수인 해는 윤년
		// 2. 4의 배수이면서 100의 배수인 해는 윤년이 아님
		// 3. 100의 배수이면서 400의 배수인 해는 윤년
		
		Scanner sc = new Scanner(System.in);
		System.out.print("년 월을 입력하세요(2000 2) >> ");
		int year = sc.nextInt();
		int month = sc.nextInt();
		sc.close();
		
		ifTest(year, month);
		switchTest(year, month);

	}
	
	public static void switchTest(int year, int month) {
		
		int lastDay = 31;
		
		switch(month) {
		case 2:
			if(year % 4 == 0 && year % 100 != 0 ||
			year % 4 == 0 && year % 400 == 0) {
				lastDay = 28;
			} else {
				lastDay = 29;
			}
			break;
		case 4:
		case 6:
		case 9:
		case 11: lastDay = 30; break;
		}
		
		System.out.println(year+"년 "+month+"월의 말일은 "+lastDay+"입니다.");
	}
	
	public static void ifTest(int year, int month) {
		
		// 4의 배수고, 100의 배수가 아니면 윤년
		// 4의 배수이고, 400의 배수면 윤년
		// 윤년이면 2월은 29일, 아니면 28일
		// 1, 3, 5, 7, 8, 10, 12 -> 31일
		// 4, 6, 9, 11 -> 30일
		int lastDay = 31;	// 많이 있는 것으로 초기화
		
		// 우선순위는 ||보다 &&이 빠르다.
		if(month == 2) {
			if(year % 4 == 0 && year % 100 != 0 || 
					year % 4 == 0 && year % 400 == 0) {
				lastDay = 28;
			}else {
				lastDay = 29;
			}
		}else if(month == 4 || month == 6 || month == 9 || month == 11){
			lastDay = 30;
		}
			System.out.println(year+"년 "+month+"월의 말일은 "+lastDay+"입니다.");
		
	}

}