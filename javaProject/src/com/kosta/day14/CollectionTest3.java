package com.kosta.day14;

import java.util.HashSet;
import java.util.NavigableSet;
import java.util.Set;
import java.util.TreeSet;

import com.kosta.day13.model.CustomerDTO;

public class CollectionTest3 {

	public static void main(String[] args) {
		method5();
	}

	private static void method5() {
		TreeSet<CustomerDTO> datas = new TreeSet<>();
		datas.add(new CustomerDTO(1, "고객1", "12", "서울"));	
		datas.add(new CustomerDTO(3, "고객2", "22", "부산"));
		datas.add(new CustomerDTO(2, "고객3", "32", "서울"));
		datas.add(new CustomerDTO(4, "고객4", "42", "부산"));
		datas.add(new CustomerDTO(4, "고객4", "42", "서울"));	
		
		System.out.println("ascending sort---------------------------");
		for(CustomerDTO s:datas) {
			System.out.println(s);
		}
		
		System.out.println("descending sort---------------------------");
		NavigableSet<CustomerDTO> descendingSet = datas.descendingSet();
		for(CustomerDTO s:descendingSet) {
			System.out.println(s);
		}
		
		System.out.println("다시 ascending sort---------------------------");
		// 다시 ascending으로 돌리기
		NavigableSet<CustomerDTO> asc = descendingSet.descendingSet();
		for(CustomerDTO s:asc) {
			System.out.println(s);
		}
	}

	private static void method4() {
		TreeSet<CustomerDTO> datas = new TreeSet<>();
		datas.add(new CustomerDTO(1, "고객1", "12", "서울"));	
		datas.add(new CustomerDTO(3, "고객2", "22", "부산"));
		datas.add(new CustomerDTO(2, "고객3", "32", "서울"));
		datas.add(new CustomerDTO(4, "고객4", "42", "부산"));
		datas.add(new CustomerDTO(4, "고객4", "42", "서울"));	
		
		System.out.println("원래: " + datas.size() + "건");
		
		while(!datas.isEmpty()) {	// datas가 비어있지 않는 동안 돌기
			// 맨 앞에서부터 꺼낸 후 제거
			CustomerDTO cust = datas.pollFirst();
			System.out.println(cust);
			System.out.println("poll: " + datas.size() + "건");
		}
		
		
	}

	private static void method3() {
		TreeSet<CustomerDTO> datas = new TreeSet<>();
		datas.add(new CustomerDTO(1, "고객1", "12", "서울"));		// CustomerDTO에 Comparable 구현해야한다.
		datas.add(new CustomerDTO(3, "고객2", "22", "부산"));
		datas.add(new CustomerDTO(2, "고객3", "32", "서울"));
		datas.add(new CustomerDTO(4, "고객4", "42", "부산"));
		datas.add(new CustomerDTO(4, "고객4", "42", "서울"));		// 중복제거하려면 CustomerDTO에 hashCode, equals 재정의하기
		
		System.out.println("첫번째 item: " + datas.first());	// TreeSet에만 있는 함수
		System.out.println("마지막 item: " + datas.last());
		
		for(CustomerDTO s:datas) {
			System.out.println(s);
		}
	}

	private static void method2() {
		Set<String> datas = new TreeSet<>();
		datas.add("월");
		datas.add("화");
		datas.add("수");
		datas.add("토");
		datas.add("토");
		
		for(String s:datas) {
			System.out.println(s);	// 아스키코드값으로 정렬돼서 나온다.
		}
	}

	private static void method1() {
		// TreeSet은 값을 넣을 때 binary tree를 이용, 크기를 비교해서 크면 오른쪽, 작으면 왼쪽에 저장.
		// 값이 들어갈 땐 속도가 느리다. 검색할 땐 빠름.
		// 자동으로 정렬돼서 나온다.
		TreeSet<Integer> datas = new TreeSet<>();	// 타입이 Set이면 Set이 가진 기능만 갖게됨
		datas.add(100);
		datas.add(50);
		datas.add(70);
		datas.add(30);
		datas.add(30);	// Set -> 중복불가
		
		System.out.println("첫번째 item: " + datas.first());	// 이미 sort가 다 되어있다.
		System.out.println("마지막 item: " + datas.last());
		
		System.out.println("기준보다 바로 아래인 item: " + datas.lower(50));		// AutoBoxing
		System.out.println("기준보다 바로 위인 item: " + datas.higher(50));
		
		// floor : 동등하거나 밑
		System.out.println("floor: " + datas.floor(50));
		// ceiling : 동등하거나 위
		System.out.println("ceiling: " + datas.ceiling(55));

		
		for(Integer i:datas) {
			System.out.println(i);	
		}
	}

}
