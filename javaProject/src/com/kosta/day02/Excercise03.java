package com.kosta.day02;

public class Excercise03 {

	public static void main(String[] args) {
		// for문으로 1~100까지 3의 배수의 총합 구하기
		
		int total = 0;
		
		for(int i=1; i<=100; i++) {
			if(i % 3 != 0) {
				continue;
			}
			total = total + i;
		}
		
		System.out.println(total);

	}

}
