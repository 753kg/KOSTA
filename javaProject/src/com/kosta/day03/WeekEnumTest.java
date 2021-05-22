package com.kosta.day03;

public class WeekEnumTest {

	public static void main(String[] args) {
		Week w;
		w = Week.SUNDAY;
		
		System.out.println(w);
		System.out.println(w==Week.SUNDAY);			// 상수, 내용비교
		
		System.out.println(w.ordinal());
		System.out.println(w.name());			// 문자열이 뭐야
		
		System.out.println(w.name().equals("SUNDAY"));		// 문자열, 주소비교
		
		Week ww = Week.valueOf("SUNDAY");		
		Week ww2 = Week.valueOf("MONDAY");
		System.out.println("차이"+ww.compareTo(ww2));
		
		
		System.out.println(Week.valueOf("SUNDAY"));
		System.out.println("===============================");
		
		// Week에 뭐가 있는지 볼 때
		Week[] arr = Week.values();
		for(Week aa:arr) {
			System.out.println(aa);
			System.out.println(aa.ordinal());	//순번
			System.out.println(aa.name());		//이름
			System.out.println("----------");
		}

	}

}