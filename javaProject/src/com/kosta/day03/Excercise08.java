package com.kosta.day03;

public class Excercise08 {

	public static void main(String[] args) {
		// 주어진 배열 전체 항목의 합과 평균값 구하기. 중첩 for문
		
		int[][] array = {
				{95, 86},
				{83, 92, 96},
				{78, 83, 93, 87, 88}
		};
		
		int sum = 0;
		double avg = 0.0;
		double count = 0.0;
		
		for(int[] arr1:array) {
			for(int su: arr1) {
				sum += su;
				count++;
			}
		}
		
//		for(int i=0; i<array.length; i++) {
//			for(int j=0; j<array[i].length; j++) {
//				sum += array[i][j];
//				count++;
//			}
//		}
		
		avg = sum / count;
		
		System.out.println("sum : " + sum);
		System.out.println("avg : " + avg);

	}

}
