package com.kosta.day02;

public class Excercise04 {

	public static void main(String[] args) {
		// 두 개의 주사위를 던졌을 때
		// (눈1, 눈2) 형태로 출력
		// 눈의 합이 5가 아니면 계속 던지고, 5면 실행 멈추기
		boolean run = true;
		while(run) {
		int dice1 = (int)(Math.random() * 6 + 1);
		int dice2 = (int)(Math.random() * 6 + 1);
		int diceSum = dice1 + dice2;
		
		System.out.println("("+dice1+", "+dice2+")");
		
		if(diceSum == 5) break;
		
		}

	}

}
