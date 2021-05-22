package com.kosta.day01;

public class VariableTest4 {

	public static void main(String[] args) {
		// 자바의 기본타입 8가지
		// 데이터 타입 (데이터 성격)
		// 1. 정수 byte(1) < short(2) < int(4) < long(8)
		//					char(2)
		// 2. 실수 float(4) < double(8)
		// 3. 논리 boolean
		
		// 실수가 더 크다.
		// byte < short < int < long < float < double
		
		byte b = 127;
		short s = 32767;
		char c = 65535;
		int i = 2147483647;		// 4기가
		long lo = 2147483648L;	// 정수 default는 int
		float f = 3.14f;
		double d = 3.14;		// 소수점 default는 double
		boolean bo = 10 > 20;	// 결과 true or false
		System.out.println(bo);
		i++;
		System.out.println(i);
		
		// data 형변환 : 자동, 강제(명시적)
		// 1. 자동 (큰방 = 작은값)
		byte aa = 127;
		short ss = 100;
		char cc = 'A';		//1000001
		cc = 'a';			//1100001
		int ii = ss;
		double dd = ii;
		// ss = cc;		char와 short는 불가능. 범위가 달라서
		ii = cc;
		
		System.out.println("ii= " + ii);
		System.out.println("dd= " + dd);
		
		// 2. 강제형변환 (작은방 = 큰값)
		// 범위를 벗어나면 값이 손실된다.
		byte b2 = 100;		// -128 ~ 127
		int i2 = 100;
		
		//i2 = b2;	(자동)
		b2 = (byte) i2;
		System.out.println(b2);
		
		// 97(a) 98 99 100(d)
		char c2 = (char) i2;
		System.out.println(c2);			// d
		
		System.out.println('A');
		System.out.println((int)'A');	//65

	}

}