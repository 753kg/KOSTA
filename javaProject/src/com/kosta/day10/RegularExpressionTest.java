package com.kosta.day10;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegularExpressionTest {

	public static void main(String[] args) {
		method4();
	}
	
	private static void method4() {
		String name = "010-7878-9999";
		String exp = "([01]{3})-([0-9]{4})-([0-9]{4})";
		
		Pattern p = Pattern.compile(exp);	
		Matcher m = p.matcher(name);
		boolean b = m.find(); 	// matcher가 있는지
		System.out.println(b);
		if(b) { //true면
			System.out.println(m.group());
			System.out.println(m.group(1));	
			System.out.println(m.group(2));	
			System.out.println(m.group(3));	
		}
	}
	
	private static void method3() {
		String name = "홍 길동";
		String exp = "([가-힣 ]{1}) ([가-힣 ]{2})";	// 그룹 -> Pattern.matches로는 불가능
		
		Pattern p = Pattern.compile(exp);	
		Matcher m = p.matcher(name);
		boolean b = m.find(); 	// matcher가 있는지
		System.out.println(b);
		if(b) { //true면
			System.out.println(m.group());		// 전체
			System.out.println(m.group(1));		// 홍
			System.out.println(m.group(2));		// 길동
		}
	}

	private static void method2() {
//		String phone = "010-788-89891111";
//		String exp = "[01]{3}-[0-9]{3,4}-\\d{4,}";
		String name = "홍길동";
		String exp = "[가-힣]+";		// 한글만입력가능하다
		
		
		Pattern p = Pattern.compile(exp);	
		Matcher m = p.matcher(name);
		boolean b = m.find();
		System.out.println(b);
	}

	private static void method1() {
		System.out.println("자바\t프로\n그래밍");
		String phone = "010-788-8989";
		String exp = "[01]{3}-[0-9]{3,4}-\\d{4,}";	//{4,}:4자리 이상이다
		
		boolean result = Pattern.matches(exp, phone);
		System.out.println(result);		// 정규표현식에 맞는지 검증
	}


}

/*
 * ~ : 틸드
 * ^ : 캐럿
 * ` : 백틱
 * , : 콤마
 * ; : 세미콜론
 * : : 콜론
 * " : 더블쿼테이션
 * ' : 싱글쿼테이션
 */

/*
 * RegularExpression
 * [] : 선택			[abc] -> a,b,c중 하나
 * - : 범위			[a-z] [A-Z] [0-9] -> a부터 z까지, [0-9] == \d
 * [^] : 제외			[^a-z] -> 소문자 안됨
 * ^[] : 시작			^a -> a로 시작한다
 * $ : 끝			$a -> a로 끝난다
 * {숫자} : 자릿수	
 * {숫자1,숫자2} : 숫자1~숫자2만큼 자릿수 된다. ex)[01]{3} 0,1중에서 3자리가 온다.
 * ? : 0개 또는 1개
 * * : 0개이상		a* -> a가 0개 이상온다 -> a aa aaa aaaa ... 가 된다.
 * + : 1개이상		a+
 * () : 그룹핑		
 */
	