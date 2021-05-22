package com.kosta.day03;

import java.util.Arrays;

// 배열 : 이름은 하나, 같은 종류(타입)의 값을 여러 개 저장하기 위한 자료구조
public class 배열연습 {

	// args : 명령행(command) 매개변수
	// >java 배열연습 100 200
	public static void main(String[] args) {
		//method1();
		//method2();
		//method3();
		
		System.out.println(args.length + "개 parameter가 들어옴");
		System.out.println(args[0]);
		System.out.println(args[1]);
		
		System.out.println(args[0]+args[1]);	// "100"+"200"="100200"
		
		// 문자열 -> 숫자 변경
		// String Class = 기능(메서드) + 속성(변수)
		// Integer Class = 기능(메서드) + 속성(변수)
		int su1 = Integer.parseInt(args[0]);
		int su2 = Integer.parseInt(args[1]);
		
		System.out.println(su1 + su2);
		System.out.println(su1 - su2);
		System.out.println(su1 * su2);
		System.out.println(su1 / su2);
		System.out.println(su1 % su2);

	}

	private static void method3() {
		// 배열 생성시 갯수는 필수이다.
		// 자동 초기화, null로 초기화
		String[] arr = new String[5];
		
		// 초기화하면서 생성시, 갯수 쓰면 안됨
		String[] arr2 = new String[] {"java","sql","html5","css3","javascript"};
		
		String[] arr3 = {"java","sql","html5","css3","javascript"};
		
		// 선언하고, 생성 초기화 할 때
		String[] arr4;
		arr4 = new String[] {"java","sql","html5","css3","javascript"};
		
		String[] arr5;
		//arr5 = {"java","sql","html5","css3","javascript"};	// 불가능
		
		for(int i=0; i<arr4.length; i++) {
			System.out.println(arr4[i]);
		}
		
		// 확장 for, 향상된 for
		for(String s : arr4) {
			System.out.println(s);
		}
	}

	private static void method2() {
		int[] arr;
		arr = new int[10];	// 자동으로 0이 들어감
		for(int i=0; i<arr.length; i++) {
			System.out.println(i+"번째:"+arr[i]);
		}
		System.out.println(Arrays.toString(arr));	//한번에 값들 확인
		
		// 기본형이 아닌 경우는 null로 초기화
		String[] arr2 = new String[5];
		System.out.println(Arrays.toString(arr2));
		
		// 선언 + 생성 + 초기화
		int[] arr3 = new int[] {100, 99, 88, 50, 10};
		int[] arr4 = {100, 99, 88, 50, 10};
		System.out.println(Arrays.toString(arr3));
		System.out.println(Arrays.toString(arr4));
		
		int total = 0;
		for(int i=0; i<arr3.length; i++) {
			total += arr3[i];
		}
		System.out.println(total);
	}

	private static void method1() {
		// 1. 배열 변수 선언
		int[] score1;
		double score2[];
		boolean[] pass;
		char[] grade;
		
		// 2. 배열 생성 ... heap영역에 만들어지는 객체는 자동 초기화된다.
		score1 = new int[30];	// int -> 4byte 30개 생성
		score2 = new double[5];
		pass = new boolean[30];
		grade = new char[30];
		
		// 3. 배열 사용
		// index(첨자)는 0부터 시작, 개수가 30개. 0~29
		System.out.println(score1.length);
		System.out.println(score2.length);
		System.out.println(score1[0]);		// int 0으로 초기화
		System.out.println(score2[0]);		// double 0.0으로 초기화
		System.out.println(pass[0]);		// boolean false으로 초기화
		System.out.println("*"+grade[0]+"*");		// char 공백으로 초기화
		
		score1[1] = 100;
		score1[2] = 99;
		System.out.println(score1[1]);
	}

}