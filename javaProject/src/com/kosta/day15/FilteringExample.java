package com.kosta.day15;

import java.util.Arrays;
import java.util.List;

public class FilteringExample {
	public static void main(String[] args) {
		List<String> names = Arrays.asList("홍길동", "신용권", "감자바", "신용권", "신민철");
		
		names.stream()
			.distinct()								// 중간, 중복 배제
			.forEach(n -> System.out.println(n));	// 최종
		System.out.println();
		
		names.stream()
			.filter(n -> n.startsWith("신"))			// 중간, "신"으로 시작하는 이름
			.forEach(n -> System.out.println(n));
		System.out.println();
		
		names.stream()
			.distinct()								// 중간
			.filter(n -> n.startsWith("신"))			// 중간
			.forEach(n -> System.out.println(n));
	}
}
