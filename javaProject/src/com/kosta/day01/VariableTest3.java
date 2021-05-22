package com.kosta.day01;

public class VariableTest3 {

	public static void main(String[] args) {
		byte a = 127;
		System.out.println("byte : -128 ~ 127 가능, " + "a= " + a);
		
		// 2byte
		short b = 32767;
		System.out.println("short : -32768 ~ 32767 가능, " + "b= " + b);
		
		// 2byte, 부호 없음. 0~65535
		char c = 'A';	//A : 65로 저장됨
		System.out.println(c);
		
		// 4byte
		int d = 2147483647;
		d++; d++; d++;		
		// 범위 넘어가면 다시 제일 작은 값이 됨. -2147483648
		// 범위를 벗어나면 값이 소실된다.
		System.out.println(d);
		
		//3		0011	보수취하기 1100, 1더하기 --> -3	1101
		//-3	1101

	}

}