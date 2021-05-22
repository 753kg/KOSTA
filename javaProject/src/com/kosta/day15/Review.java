package com.kosta.day15;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.Vector;

public class Review {

	public static void main(String[] args) {
		method5();
	}
		
	private static void method5() {
		Map<Student, Integer> datas = new TreeMap<>();
		datas.put(new Student("홍길동", 50), 100);
		datas.put(new Student("김길동", 70), 101);
		datas.put(new Student("박길동", 80), 102);
		datas.put(new Student("정길동", 10), 103);
		datas.put(new Student("이길동", 60), 104);
		datas.put(new Student("이길동", 60), 105);	
		
		System.out.println(datas.size());
		System.out.println("------entry 얻기------");
		for(Entry<Student, Integer> entry:datas.entrySet()) {
			System.out.println("key: " + entry.getKey());
			System.out.println("value: " + entry.getValue());
		}
		
		System.out.println("------key 얻기------");
		for(Student st:datas.keySet()) {
			System.out.println("key: " + st);
			System.out.println("value: " + datas.get(st));
		}
	}

	private static void method4() {
		// Key, Value 쌍으로
		Map<Student, Integer> datas = new HashMap<>();
		datas.put(new Student("홍길동", 50), 100);
		datas.put(new Student("김길동", 70), 101);
		datas.put(new Student("박길동", 80), 102);
		datas.put(new Student("정길동", 10), 103);
		datas.put(new Student("이길동", 60), 104);
		datas.put(new Student("이길동", 60), 105);		// key는 같을 수 없다.
		
		System.out.println(datas.size());
		System.out.println("------entry 얻기------");
		for(Entry<Student, Integer> entry:datas.entrySet()) {
			System.out.println("key: " + entry.getKey());
			System.out.println("value: " + entry.getValue());
		}
		
		System.out.println("------key 얻기------");
		for(Student st:datas.keySet()) {
			System.out.println("key: " + st);
			System.out.println("value: " + datas.get(st));
		}
		
		// JAVASCRIPT : JSON(JavaScript Object Notation)
		// JavaScript Object ---> {"name" : "홍길동", "score" : 100}
		// JavaScript Object를 문자로 변경 ---> '{"name" : "홍길동", "score" : 100}'
		// .csv -> XML(본래 자료의 3배정도 size가 커진다) -> JSON
		// JAVA, Python : map
	}
	

	private static void method3() {
			TreeSet<Student> datas = new TreeSet<>();	// TreeSet은 Comparable 꼭 구현해야함
//			Set<Student> datas = new HashSet<>();	
			datas.add(new Student("홍길동", 50));
			datas.add(new Student("김길동", 70));
			datas.add(new Student("박길동", 80));
			datas.add(new Student("정길동", 10));
			datas.add(new Student("이길동", 60));
			datas.add(new Student("이길동", 60));		// hashCode, equals 재정의하기
			System.out.println(datas.size());
			for(Student s:datas) {
				System.out.println(s);
			}
			
			// TreeSet 타입이어야함.
			System.out.println("------descending sort------");
//			NavigableSet<Student> nset = datas.descendingSet();
			for(Student s:datas.descendingSet()) {
				System.out.println(s);
			}
		
	}

	private static void method2() {
			// Set은 동일 객체인지 체크 -> HashCode, equals ... String은 둘 다 구현되어있다.
//			Set<String> datas = new HashSet<>();
			
			// binary sort : tree 구조로 정렬 ... compareTo() 재정의 돼있어야한다.... string은 되어있음.
			Set<String> datas = new TreeSet<>();
			datas.add(new String("자바2"));
			datas.add(new String("자바3"));
			datas.add("자바");
			datas.add("자바");
			datas.add(new String("자바"));		// string은 내용이 같으면 같은 hashcode
			datas.add(new String("자바"));		// 중복X
			System.out.println(datas.size());
			for(String s:datas) {
				System.out.println(s);
			}
	}

	private static void method1() {
		// Collection : List, Set, Map
		// List : 순서, 중복				... ArrayList, LinkedList, Vector
		// Set : 순서X, 중복X, key로 사용됨	... HashSet, TreeSet
		// Map : key, value의 쌍(entry)	... HashMap, TreeMap, Properties
		// Stack(LIFO) ... Class 
		// Queue(FIFO) ... LinkedList
		
//		List<String> datas = new ArrayList<>();
//		List<String> datas = new LinkedList<>();
		List<String> datas = new Vector<>();
		datas.add("자바");
		datas.add("자바");
		datas.add(new String("자바"));
		datas.add(new String("자바"));		// 중복허용
		System.out.println(datas.size());
		for(String s:datas) {
			System.out.println(s);
		}
	}

}
