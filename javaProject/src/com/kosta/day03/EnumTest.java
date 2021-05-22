package com.kosta.day03;

import java.util.Calendar;
import java.util.Date;

public class EnumTest {
	
	// 상수 final
	public static final String SUCCESS="OK";
	public static final String FAIL="NO";
	public static final String LOGIN="OK";

	public static void main(String[] args) {
		
//		method1();
//		method2();
//		method3();
//		System.out.println("****************");
//		Week w = Week.WEDNESDAY;
//		call(w);
		
		EnumWeekExample();
		

	}

	private static void EnumWeekExample() {
		// 오늘이 무슨요일인지
		
		Date d = new Date();
		System.out.println(d);
		System.out.println(d.getYear()+1900);	// 권장되지않음
		
		Calendar cal = Calendar.getInstance();	// calender 쓰는법
		System.out.println(cal.get(Calendar.YEAR)+"년도");
		System.out.println(cal.get(Calendar.MONTH)+1 +"월");
		System.out.println(cal.get(Calendar.DAY_OF_MONTH)+"일");
		System.out.println(cal.get(Calendar.DAY_OF_WEEK)+"요일");	
		// 1(일),2(월),3,4,5,6,7(토)
		
		call2(cal.get(Calendar.DAY_OF_WEEK));
		
	}

	private static void call2(int dayNum) {
		Week w = null;
		switch (dayNum) {
		case 1:
			w = Week.SUNDAY; break;
		case 2:
			w = Week.MONDAY; break;
		case 3:
			w = Week.TUESDAY; break;
		case 4:
			w = Week.WEDNESDAY; break;
		case 5:
			w = Week.THURSDAY; break;
		case 6:
			w = Week.FRIDAY; break;
		case 7:
			w = Week.SATURDAY; break;

		default:
			break;
		}
		
		// 한글로 출력
		call(w);
		
	}

	private static void call(Week w) {
		switch (w) {
		case MONDAY:
			System.out.println("월요일"); break;
		case TUESDAY:
			System.out.println("화요일");	break;
		case WEDNESDAY:
			System.out.println("수요일");	break;
		case THURSDAY:
			System.out.println("목요일");	break;
		case FRIDAY:
			System.out.println("금요일");	break;
		case SATURDAY:
			System.out.println("토요일");	break;
		case SUNDAY:
			System.out.println("일요일");	break;

		//default: 필요없으면 안써도됨
		}
		
	}

	private static void method3() {
		Week[] aa = Week.values();
		for(Week w:aa) {
			System.out.println(w);
		}
		
	}

	private static void method2() {
		//열거타입 변수
		LoginResult result;
		//열거타입.상수
		result = LoginResult.LOGIN_SUCCESS;
		result = LoginResult.LOGIN_FAIL;
		
		if(result == LoginResult.LOGIN_FAIL) {
			System.out.println("로그인 실패");
		}
		
		// 모든 열거 객체들을 배열로 리턴
		LoginResult[] arr = LoginResult.values();
		for(int i=0; i<arr.length; i++) {
			System.out.println(arr[i]);
		}
		
	}

	private static void method1() {
		String result = "OK";
		if(result == LOGIN) {
			System.out.println("로그인 성공");
		}else if(result == FAIL){
			System.out.println("로그인 실패");
		}
		
	}

}