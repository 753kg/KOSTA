package com.kosta.day11;

import java.text.DecimalFormat;
import java.text.MessageFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

public class DateTest {
	
	public static void main(String[] args) {
		method7();
	}

	private static void method8() {
		Date d1 = new Date();	// 지금
		
	}

	private static void method7() {
		LocalDate d = LocalDate.now();	// 지금
		LocalDate d3 = d.minusDays(7);	// 7일 전
		System.out.println(d);
		System.out.println(d.getYear());
		System.out.println(d.getMonth());		// MARCH
		System.out.println(d.getMonthValue());	// 3
		
		System.out.println("오늘:" + d);
		System.out.println("일주일 전:" + d3);
		
		
		LocalDateTime d2 = LocalDateTime.now();
		System.out.println(d2);
	}

	private static void method6() {
		String s = "자동차의 모델은 {0}이고 자동차의 가격은 {1}이다.";
		Car car = new Car("모델A", 3000);
		Object[] obj = {car.getModel(), car.getPrice()};
		String result = MessageFormat.format(s, obj);
		System.out.println(result);
	}

	private static void method5() {
		String s = "전화는 {1} 아이디는 {0}";
		String result = MessageFormat.format(s, "hong", "010-1111-2222");
		System.out.println(result);
		
	}

	private static void method4() {
		Date d = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yy/MM/dd hh:mm:ss D/365 E a w/52 W");
		String s = sdf.format(d);
		System.out.println(s);
		System.out.println(sdf.format(d));
	}

	private static void method3() {
		int su = 10000000;
		DecimalFormat df = new DecimalFormat("###,###,###");
		String s = df.format(su);
		System.out.println(s);
	}

	private static void method2() {
		Calendar cal = Calendar.getInstance();	// Calendar는 기본생성자가 없음
		TimeZone tz = TimeZone.getTimeZone("America/Los_Angeles");
		Calendar cal2 = Calendar.getInstance(tz);
		
		System.out.println(cal);
		System.out.println(cal2);
		
		System.out.println(cal.get(Calendar.YEAR));
		System.out.println(cal.get(Calendar.MONTH) + 1);
		System.out.println(cal.get(Calendar.DAY_OF_MONTH));		// 일
		System.out.println(cal.get(Calendar.HOUR));
		System.out.println(cal.get(Calendar.MINUTE));
		System.out.println(cal.get(Calendar.SECOND));
		System.out.println(cal.get(Calendar.AM_PM)==0?"오전":"오후");	// 오전:0, 오후:1
		System.out.println("-----------------------------------------------");
		System.out.println(cal2.get(Calendar.YEAR));
		System.out.println(cal2.get(Calendar.MONTH) + 1);
		System.out.println(cal2.get(Calendar.DAY_OF_MONTH));	
		System.out.println(cal2.get(Calendar.HOUR));
		System.out.println(cal2.get(Calendar.MINUTE));
		System.out.println(cal2.get(Calendar.SECOND));
		System.out.println(cal2.get(Calendar.AM_PM)==0?"오전":"오후");

	}

	private static void method1() {
		Date d = new Date();	// 어딘가에 전송할 때만 Date 사용. 활용할 땐 다른거 사용
		System.out.println(d);
		System.out.println(d.toString());
		System.out.println(d.toLocaleString());
		System.out.println(d.getYear());
		System.out.println(d.getMonth() + 1);
		System.out.println(d.getTime());	// 이거는 씀. long값으로 시간 얻음
		
		java.sql.Date d2 = new java.sql.Date(d.getTime());
		System.out.println(d2);		// sql의 Date 형태 => 많이 씀
		
		// 형태 바꿀 때
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy년도 MM월 dd일 hh:mm:ss");
		System.out.println(sdf.format(d));
	}

}
