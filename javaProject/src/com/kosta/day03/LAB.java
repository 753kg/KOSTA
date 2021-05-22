package com.kosta.day03;

import java.util.Arrays;

public class LAB {

	public static void main(String[] args) {
		// 4장LAB(switch,배열)
		
		// 문제 1.
		// printSeasonSwitch(args[0]);	//명령행 매개변수
		// printSeasonArray(args[0]);
		
		// 문제 2.
		// abs(args[0], args[1]);
		
		// 문제 3.
		mySort();

	}

	private static void mySort() {
		int[] arr = {3, 24, 1, 55, 17, 43, 5};
		System.out.println("before: "+Arrays.toString(arr));
		// 선택정렬
		for(int i=0; i<arr.length-1; i++) {
			for(int j=i+1; j<arr.length; j++) {
				if(arr[i] > arr[j]) {
					int temp = arr[i];
					arr[i] = arr[j];
					arr[j] = temp;
				}
			}
		}
		System.out.println("after: "+Arrays.toString(arr));
		
	}

	private static void abs(String s1, String s2) {
		int num1 = Integer.parseInt(s1);
		int num2 = Integer.parseInt(s2);
		
		int result = num1>num2 ? (num1-num2):(num2-num1);
		System.out.println(result+"만큼 차이가 난다.");
		
	}

	private static void printSeasonArray(String month) {
		String spring = "봄", summer = "여름", fall = "가을", winter = "겨울";
		String[] message = {null, winter,winter,spring,spring,spring,
				summer,summer,summer,fall,fall,fall,winter};
		
		int mon = Integer.parseInt(month);
		if(mon == 0 || mon >= message.length)
			System.out.println("1~12 사이의 숫자만 입력하셔야 합니다.");
		else
			System.out.println(message[mon]+"태어남");
		
	}

	private static void printSeasonSwitch(String month) {
		String message = null;
		switch (month) {
		case "3":
		case "4":
		case "5":
			message = "봄";
			break;
		case "6":
		case "7":
		case "8":
			message = "여름";
			break;
		case "9":
		case "10":
		case "11":
			message = "가을";
			break;
		case "12":
		case "1":
		case "2":
			message = "겨울";
			break;
		default:
			message = "1~12 사이의 숫자만 입력하셔야 합니다.";
			System.out.println(message);
			return;		//함수 나가기
		}
		
		System.out.println(message+"에 태어나셨네요.");
		
	}

}