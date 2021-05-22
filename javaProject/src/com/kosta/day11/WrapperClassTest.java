package com.kosta.day11;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class WrapperClassTest {

	public static void main(String[] args) {
		method7();
	}

	private static void method7() {
		// Set ... 중복없음
		Random r = new Random();
		Set<Integer> luckNum = new HashSet<>();
		while(luckNum.size() != 6) {
			int su = r.nextInt(45) + 1;
			luckNum.add(su);	// 중복이면 안들어감
		}
		System.out.println(luckNum);
	}

	private static void method6() {
		int[] arr = new int[6];
		Random r = new Random();
		for (int i = 0; i < arr.length; i++) {
			arr[i] = r.nextInt(45) + 1;
			for (int j = i - 1; j >= 0; j--) {
				while (arr[i] == arr[j]) {
					arr[i] = r.nextInt(45) + 1;
					j = 0;
				}
			}
		}
		System.out.println(Arrays.toString(arr));
	}

	private static void method5() {
		// 로또 번호 6개 무작위 추출, 중복 X
		int[] arr = new int[6];
		Random r = new Random();
		int su;
		int last = 0;
		AA:while(true) {
			if(last == arr.length) break;
			su = r.nextInt(45) + 1;
			for(int i=0; i<last; i++) {
				if(su == arr[i]) continue AA;
			}
			arr[last] = su;
			last++;
		}
		System.out.println(Arrays.toString(arr));
	}

	private static void method4() {
//		Random r = new Random();
		Random r = new Random(1);				// 같은 랜덤값 주기
		System.out.println(r.nextInt());		// random 정수가 나옴
		System.out.println(r.nextInt(45));		// 0<=  < 45
		System.out.println(r.nextInt(45)+1);	// 1 <=  < 46
	}

	private static void method3() {
		double a = Math.random();
		System.out.println(a);					// 0 <=		< 1.0
		System.out.println(a * 45); 			// 0 <=		< 45.0
		System.out.println((int)(a * 45));		// 0 <=		< 45		정수값만
		System.out.println((int)(a * 45)+1);	// 1 <=		< 46
	}

	private static void method2() {
		int a = 10;
		int b = 20;
		System.out.println(Math.max(a, b));	// 둘 중 큰 값
		System.out.println(Math.round(98.5));	// 반올림
		System.out.println(Math.ceil(98.1));	// 올림
		System.out.println(Math.floor(98.9));	// 버림
	}

	private static void method1() {
		byte b = 10;
		short s = 10;
		char c = 'A'; 	// 65라고 줘도됨
		int i = 10;
		long l = 10L;
		float f = 3.14f;
		double d = 3.14;
		boolean bl = true;
		
						// AutoBoxing
		Byte b2 = 10;	// new Byte(10)
		Short s2 = 10;
		Character c2 = 'A';
		Integer i2 = 10;
		Long l2 = 10L;
		Float f2 = 3.14f;
		Double d2 = 3.14;
		Boolean bl2 = true;
		
		// UnBoxing
		// System.out.println(b2.byteValue() + 20);
		System.out.println(b2 + 20);
		System.out.println(s2 + 20);
		System.out.println(c2 + 20);
		System.out.println(i2 + 20);
		System.out.println(l2 + 20);
		System.out.println(f2 + 20);
		System.out.println(d2 + 20);
		System.out.println(bl2);
		
		String str = "100";
		System.out.println(Integer.parseInt(str));
		System.out.println(Double.parseDouble(str));
		
		String str2 = "true";
		if(Boolean.parseBoolean(str2)) {
			System.out.println("참이다.");
		}else {
			System.out.println("거짓이다.");
		}
	}

}
