package com.kosta.day02;

import java.io.IOException;
import java.util.Scanner;

public class WhileKeyControlExample {

	public static void main(String[] args) {
		
		boolean run = true;
		int speed = 0;
		int keycode = 0;
		Scanner sc = new Scanner(System.in);
		
		while(run) {
			
			System.out.println("-------------------------");
			System.out.println("1. 증속 | 2. 감속 | 3. 종료");
			System.out.println("-------------------------");
			System.out.print("선택하세요 >> ");
			
			keycode = sc.nextInt();
			
			if(keycode == 1) {
				speed++;
			}else if(keycode == 2) {
				speed--;
			}else if(keycode == 3) {
				run = false;
			}
			
			System.out.println("현재속도: "+speed);
		}
		
		System.out.println("프로그램 종료!!");
		

	}

}