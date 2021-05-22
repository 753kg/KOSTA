package com.kosta.day14;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.Vector;

import com.kosta.day13.model.CustomerDTO;

public class CollectionTest {

	public static void main(String[] args) {
		method7();
	}
	
	private static void method7() {
		String s1 = "홍길동";
		String s2 = "홍길동";
		System.out.println(s1.equals(s2));	// 내용이 같다.
		System.out.println(s1.hashCode());	// String은 내용이 같으면 hashCode 같다
		System.out.println(s2.hashCode());
		
		Set<CustomerDTO> datas = new HashSet<>();
		
		CustomerDTO c1 = new CustomerDTO(100, "홍길동", "010-7777-8888", "서울");
		CustomerDTO c2 = new CustomerDTO(100, "홍길동", "02-7777-8888", "서울");
		System.out.println(c1.hashCode());
		System.out.println(c2.hashCode());
		System.out.println(c1.equals(c2));		// 재정의 안하면 주소 비교
		
		datas.add(c1);
		datas.add(new CustomerDTO(200, "김길동", "010-1111-8888", "부산"));
		datas.add(new CustomerDTO(300, "박길동", "010-2222-8888", "부산"));
		datas.add(new CustomerDTO(400, "정길동", "010-3333-8888", "광주"));
		datas.add(c2);		// HashSet --> hashCode, equals가 같아야 중복 제외된다.
		
		for(CustomerDTO cust:datas) {
			System.out.println(cust);
		}
		
	}

	private static void method6() {
		Set<String> datas = new HashSet<>();
		datas.add("월요일");
		datas.add("화요일");
		datas.add("수요일");
		datas.add("토요일");
		datas.add("토요일");
		datas.add("일요일");
		System.out.println(datas.size() + "건");
		System.out.println(datas);
	}

	private static void method5() {
		// Set 인터페이스를 구현한 Class : HashSet, TreeSet
		// 순서 없다. 중복 불가. Key로 사용
		Set<String> datas = new HashSet<>();
		
		datas.add("월요일");
		datas.add("화요일");
		//datas.add("수요일");
		datas.add("토요일");
		datas.add("토요일");
		datas.add("일요일");
		System.out.println(datas.size() + "건");
		System.out.println(datas);	// HashSet이 상속받은 AbstractCollection에 toString 재정의되어있음.
		
		// 값 읽기
		// 1. 일반 for ---> 불가능. get이 없음
		// 2. 향상된 for
		for(String day:datas) {
			System.out.println(day);	// 순서 없음
		}
		System.out.println("------------");
		// 3. Iterator(반복자)
		Iterator<String> it = datas.iterator();
		while(it.hasNext()) {
			String s = it.next();
			System.out.println(s);
		}
	}

	private static void method4() {
		// 배열을 리스트로
		String[] days = {"월", "화", "수", "목", "금", "토", "토", "일"};
		String s = Arrays.toString(days);
//		System.out.println(s);
		List<String> datas = Arrays.asList(days);
//		print(datas);
//		System.out.println(datas.contains("일")?"OK":"NO");
		
		// 1. 일반 for 사용 ---> for(;;)
		// 3. 향상된 for ---> for(:) ---> print()함수처럼
		// 2. Iterator 반복자 이용해서 읽기
		Iterator<String> it = datas.iterator();
		while(it.hasNext()) {	// 읽을 게 있는지 확인
			String data = it.next();	// 읽기
			System.out.println(data);
		}
		System.out.println("모두 읽음");
	}

	private static void method3() {
		// List 인터페이스를 구현한 Class : Vector
		List<String> datas = new Vector<>();
		String[] days = {"월", "화", "수", "목", "금", "토", "토", "일"};
		
		for(String day:days) {
			datas.add(day + "요일");
		}
		
		print(datas);
	}
	
	private static void method2() {
		// List 인터페이스를 구현한 Class : LinkedList
		List<String> datas = new LinkedList<>();	// LinkedList는 연속공간이 아니다. 하나씩만 만든다.
		String[] days = {"월", "화", "수", "목", "금", "토", "토", "일"};
		
		for(String day:days) {
			datas.add(day + "요일");
		}
		
		print(datas);
	}

	private static void method1() {
		// List 인터페이스를 구현한 Class : ArrayList
		// 순서가 있다. 중복 허용
		List<String> datas = new ArrayList<>(3);		// 값을 안주면 기본적으로 10개를 만듦
		String[] days = {"월", "화", "수", "목", "금", "토", "토", "일"};
		
		for(String day:days) {
			datas.add(day + "요일");
		}
		
		// 함수연습
		String s = datas.get(7);
		System.out.println("7번째값을 가져오기: " + s);
		
		//datas.clear();
		if(datas.contains("화요일")) {
			System.out.println("화요일이 존재한다.");
		}
		//print2(datas);
	}
	
	private static <T> void print2(List<T> datas) {
		for(int i=0; i<datas.size(); i++) {
			System.out.println(i + "번째-->" + datas.get(i));
		}
	}
	
	private static <T> void print(List<T> datas) {
		for(T s:datas) {
			System.out.println(s);
		}
	}

}
