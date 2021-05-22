package com.kosta.day10;

/*
 * 기본형 >> 값 저장, 연산, 비교를 위해 사용
 * WrapperClass >> 기본형에 기능을 추가해서 만든 클래스
 * 1. byte		==> Byte
 * 2. short		==> Short
 * 3. char		==> Character
 * 4. int		==> Integer
 * 5. long		==> Long
 * 6. float		==> Float
 * 7. double	==> Double
 * 8. boolean
 */
public class WrapperClassTest {

	public static void main(String[] args) {
		method2();
	}

	private static void method2() {
		char c1 = 'a';	//a(97), A(65)
		System.out.println("대문자로 출력: ");
		System.out.println((char)(c1 - (c1 - 'A')));
		
		Character c2 = 'a';
		System.out.println(Character.toUpperCase(c2));
		System.out.println(Character.isAlphabetic(c2));
		System.out.println(Character.isAlphabetic('1'));
		System.out.println(Character.isDigit('1'));


	}

	private static void method1() {
		int a = 10;
		Integer b = new Integer(20);
		Integer c = 30;		// AutoBoxing ==> 자동으로 new Integer(30) 해줌
		System.out.println(c.floatValue());
		System.out.println(c.intValue());
		System.out.println(c);		// AutoUnBoxing ==> 자동으로 int 값 됨
		System.out.println(c + 100);
		System.out.println(c == 30);	// 저장 연산, 비교 + 다른 기능 cc.기능
	}

}
