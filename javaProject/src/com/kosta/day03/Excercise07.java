package com.kosta.day03;

public class Excercise07 {

	public static void main(String[] args) {
		// 주어진 배열 항목에서 최대값 구하기
		int max = 0;
		int[] array = {1, 5, 3, 8, 2};
		
		for(int su:array) {
			if(su > max) max = su;
		}
		
		System.out.println("max : " + max);
		
//		for(int i=0; i<array.length-1; i++) {
//			max = array[i]>array[i+1]? array[i] : array[i+1];
//		}
		

	}

}
