package com.kosta.day02;

public class Excercise05 {

	public static void main(String[] args) {
		// 4x + 5y = 60 해 구해서 (x, y)형태로 출력
		// x와 y는 10 이하의 자연수
		
		int x, y;
		
		for(x=1; x<=10; x++) {
			for(y=1; y<=10; y++) {
				if((4*x+5*y)==60) {
					System.out.println("("+x+", "+y+")");
				}
			}
		}

	}

}
