package com.kosta.day13;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Vector;

public class CollectionTest {

	public static void main(String[] args) {
		method4();
	}
	
	private static void method4() {
		List<String> datas = new Vector<String>();	// 값은 순차적으로 들어가야함.
		datas.add(0, "Hello0");
		datas.add(1, new String("Hello1"));
		datas.add("Hello2");
		datas.add("Hello3");
		datas.add("JAVA");
		System.out.println(datas.size() + "건");
		datas.remove(2);				// 지우면 한칸씩 앞으로 땡겨짐
		for(String s:datas) {
			System.out.println(s);
		}
	}
	
	private static void method3() {
		List<String> datas = new LinkedList<String>();	// 값은 순차적으로 들어가야함.
		datas.add(0, "Hello0");
		datas.add(1, new String("Hello1"));
		datas.add("Hello2");
		datas.add("Hello3");
		datas.add("JAVA");
		System.out.println(datas.size() + "건");
		datas.remove(2);				// 지우면 한칸씩 앞으로 땡겨짐
		for(String s:datas) {
			System.out.println(s);
		}
	}

	private static void method2() {
		ArrayList<String> datas = new ArrayList<String>();	// 값은 순차적으로 들어가야함.
		datas.add(0, "Hello0");
		datas.add(1, new String("Hello1"));
		datas.add("Hello2");
		datas.add("Hello3");
		datas.add("JAVA");
		System.out.println(datas.size() + "건");
		datas.remove(2);				// 지우면 한칸씩 앞으로 땡겨짐
		for(String s:datas) {
			System.out.println(s);
		}
	}

	private static void method1() {
		// Collection과 배열의 차이점 : 여러타입을 넣을 수 있다. (Object 타입으로 자동형변환) 
		//							갯수가 자동.
		// List Interface : 순서있음 , 중복허용
		// 구현 Class : ArrayList, LinkedList, Vector
		
		// 제네릭을 안 쓴 경우
		ArrayList datas = new ArrayList();
		datas.add(100);		// AutoBoxing
		datas.add(new Integer(100));
		datas.add(2, "Hello");
		datas.add(3, new String("Hello"));
		datas.add(new Student("홍길동", "남", 20));
		// 강제 타입변환 필요(단점)
		Student s = (Student) datas.get(4);
		System.out.println(s);
		
	}

}
