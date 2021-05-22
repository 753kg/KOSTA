package com.kosta.day13;

import java.util.function.IntBinaryOperator;

public class LAB5 {
	
	private static int[] scores = {10, 50, 3};
	
	public static int maxOrMin(IntBinaryOperator operator) {
		int result = scores[0];
		for(int score:scores) {
			result = operator.applyAsInt(result, score);
		}
		return result;
	}

	public static void main(String[] args) {
		// 최대값 얻기
		int max = maxOrMin( (num1, num2) -> Math.max(num1, num2) );
		System.out.println("최대값: " + max);
		
		// 최소값 얻기
		int min = maxOrMin( Math::min );		// 메소드 참조
		System.out.println("최소값: " + min);
		
		int max2 = maxOrMin( (num1, num2) -> {
			if(num1 > num2) return num1;
			return num2;
		});
		System.out.println("최대값: " + max);
	}

}
