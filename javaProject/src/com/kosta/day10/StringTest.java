package com.kosta.day10;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Arrays;
import java.util.StringTokenizer;

public class StringTest {

	public static void main(String[] args) throws IOException {
		method9();
	}
	
	private static void method9() {
		// String : 고정문자열, 절대 변경 불가
		String s = new String("고정문자열");
		System.out.println(System.identityHashCode(s));	// s 객체의 해시코드값. 주소
		
		s = s + "수정.. 실제수정되진않음";		// 새로 만들어지고 주소를 얻음
		s.replace("수정", "***");		//원본 수정 안된다.
		System.out.println(s.replace("수정", "***"));
		
		System.out.println(s);
		System.out.println(System.identityHashCode(s));	// 새로운 주소를 가리킴
		System.out.println("======================================");
		
		// StringBuffer, StringBuilder : 가변문자열, 변경 가능, But + 연산자 불가능
		StringBuffer sb = new StringBuffer("가변문자열이다");
		System.out.println(sb);

		//		sb = sb + " + 연산자 불가능";
		sb.append("수정...실제수정된다.");
		System.out.println(sb);
	
		sb.replace(7, 9, "***");
		System.out.println(sb);
		System.out.println("======================================");

		StringBuilder sb2 = new StringBuilder("가변문자열이다");
		sb2.append("수정...실제수정된다.");
		sb2.replace(7, 9, "***");
		System.out.println(sb2);
		
	}

	private static void method8() {
		// 문자열을 분리
		String s = "최은비,장준영-이주희&남후승 김유연";
		StringTokenizer st = new StringTokenizer(s, ",|-|&| ");
		System.out.println(st.countTokens());	// 토큰 몇개있는지
		while(st.hasMoreTokens()) {
			System.out.println(st.nextToken());
		}
		System.out.println(st.countTokens());
	}

	private static void method7() {
		// 문자열을 분리
		String s = "최은비,장준영-이주희&남후승 김유연";
		String[] names = s.split(",|-|&| ");	// | : or
		for(String name:names) {
			System.out.println(name);
		}
	}

	private static void method6() throws IOException {
		byte[] arr = new byte[100];
		
		int count = System.in.read(arr);	// 입력받은 값을 arr에 저장하고, 입력된 문자 수를 int로 리턴
		System.out.println("입력받은 자릿수: "+count);	// \r \n
		System.out.println("입력받은 문자: " + Arrays.toString(arr));
		System.out.println("*" + new String(arr, 0, count-2) + "*");	// 0부터 count-2까지
		System.out.println("--------------------------");
	}

	private static void method5() throws IOException {
//		int a = System.in.read();	// 입력받은 값을 int로 1byte만 리턴
		int a;
		while ((a = System.in.read()) != 13) {	// 입력 끝날 때까지 1byte씩 리턴
			System.out.print((char)a);
		}
		System.out.println();
		System.out.println(a);
	}

	private static void method4() {
		String s = "자바가 참 재미있다";
		System.out.println(s.indexOf("참"));	// 어떤 문자가 몇번째에 있는지
		System.out.println(s.length());		//문자열 길이
		System.out.println(s.replace("참", "매우"));
		System.out.println(s);				// 원본 수정은 안됨. String 문자열은 수정 불가능
		System.out.println(s.substring(4));	// 4번째부터 끝까지 자르기
		System.out.println(s.substring(4, 5));	// 4부터 5 전까지 자르기
		
		s = "     A Hello World     ";
		System.out.println(s.toUpperCase());	// 대문자로
		System.out.println(s.toLowerCase());	// 소문자로
		System.out.println("*" + s + "*");
		System.out.println("*" + s.trim() + "*");	// 문자열 앞 뒤 공백 제거
		
		System.out.println(String.valueOf(false));	// 값을 문자로 얻어라
		System.out.println(String.valueOf('a'));	
		System.out.println(String.valueOf(123));	// 숫자를 문자로 바꿔줌
		
		String s2 = 123 + "";	// 숫자를 문자로 바꾸는 방법, 트릭
	}

	private static void method3() throws UnsupportedEncodingException {
		String s = "자바가 참 재미있다";
		System.out.println(s.charAt(0));
		System.out.println(s.charAt(4));
		
		s = "A Hello World";
		byte[] arr = s.getBytes();	//character set
		System.out.println(Arrays.toString(arr));
	}

	private static void method1() {
		// 생성자 이용하기
		String s1 = "리터럴이용";
		String s2 = new String("생성자이용");
		
		byte[] arr = {65, 66, 67};	// a, b, c
		char[] arr2 = {'A', 'B', 'C', 'D'};
		
		String s3 = new String(arr);
		String s4 = new String(arr2);
		
		byte[] arr3 = new byte[100];
		int count = method2(arr3);
		String s5 = new String(arr3, 0, count-2);	//p.497
		System.out.println(s5);
	}

	private static int method2(byte[] arr3) {
		System.out.print("입력>> ");
		int count=0;
		try {
			count = System.in.read(arr3);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		
		return count;
	}

}
//import 단축키 : ctrl+shift+o
