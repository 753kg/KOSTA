package com.kosta.day15;

import java.util.stream.IntStream;

public class FromIntRangeExample {
	public static int sum;
	
	public static void main(String[] args) {
//		IntStream stream = IntStream.rangeClosed(1,  100);	// 범위 : 1~100, 마지막값 포함
		IntStream stream = IntStream.range(1,  100);	// range -> 마지막값 제외
		stream.forEach(a -> sum += a);
		System.out.println("총합: " + sum);
		
		
	}
}
