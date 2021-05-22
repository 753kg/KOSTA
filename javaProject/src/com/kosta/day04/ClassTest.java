package com.kosta.day04;

import java.io.InputStream;
import java.util.Calendar;
import java.util.Scanner;

public class ClassTest {

	public static void main(String[] args) {
		
		// 1. 객체참조변수 선언
		String s1, s2, s3, s4;				// s1은 String을 담을 수 있습니다.
		
		// 2. 객체 생성
		s1 = new String();
		s2 = new String("자바");
		byte[] b = {65, 66, 67};		//-128~127
		char[] c = {'a','b','c','d'};
		s3 = new String(b);				//65:A
		s4 = new String(c);				//
		
		// 3. 객체 사용
		System.out.println("*"+s1+"*");		//String은 주소가 아니라 문자가 찍힘.
		System.out.println("*"+s2+"*");	
		System.out.println("*"+s3+"*");	
		System.out.println("*"+s4+"*");	
		
		// 키보드입력 : InputStream -> System.in
		
		
		InputStream aa = System.in;		//표준입력받기(키보드)
		//aa.read();		// 1byte씩 읽음
		Scanner sc = new Scanner(aa);
		String s = sc.nextLine();		// 문장입력받기
		System.out.println("당신의 입력은:"+s);
		
		// Calendar는 new 못함.
		Calendar.getInstance();
		
		
	}

}