package com.kosta.day14;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Collection;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Properties;
import java.util.Set;

import com.kosta.day13.Student;
import com.kosta.day13.model.CustomerDTO;

public class CollectionTest2 {

	public static void main(String[] args) throws FileNotFoundException, IOException {
		method7();
	}
	
	private static void method7() throws FileNotFoundException, IOException {
		// Properties : 설정을 읽어올 때 많이 쓴다.
		Properties pro = new Properties();	// 1. 객체생성
		String fname = "src/com/kosta/day14/oracleInfo.properties";
		pro.load(new FileReader(fname));
		for(Entry entry:pro.entrySet()) {
			System.out.println("key: "+entry.getKey());
			System.out.println("value: "+entry.getValue());
		}
	}

	private static void method6() {
		Properties datas = System.getProperties();		// 환경변수 가져옴
		for(Entry entry:datas.entrySet()) {
			System.out.println("key: "+entry.getKey());
			System.out.println("value: "+entry.getValue());
		}
	}

	private static void method5() {
		Map<String, String> datas = System.getenv();		// 환경변수 가져옴
		for(Entry<String, String> entry:datas.entrySet()) {
			System.out.println("key: "+entry.getKey());
			System.out.println("value: "+entry.getValue());
		}
	}

	private static void method4() {
		Properties datas = new Properties();
		datas.put("자바", "이것이자바다");
		datas.put("SQL", "SQL정복");
		datas.put("HTML", "web정복");
		
		for(Entry<Object, Object> entry:datas.entrySet()) {
			System.out.println("key: "+entry.getKey());
			System.out.println("value: "+entry.getValue());
		}
		
	}

	private static void method3() {
//		Map<Student, CustomerDTO> datas = new HashMap<>();
		Map<Student, CustomerDTO> datas = new Hashtable<>();	// hashtable은 멀티스레드환경에서 안전하게 사용할 수 있다.
																// 기능은 hashmap이랑 같다.
		datas.put(new Student("학생1", "남", 100), new CustomerDTO(1, "고객1", "02-1234-5678", "서울"));
		datas.put(new Student("학생2", "남", 100), new CustomerDTO(2, "고객2", "02-1234-5678", "서울"));
		datas.put(new Student("학생3", "남", 100), new CustomerDTO(3, "고객3", "02-1234-5678", "서울"));
		
		// 모두 제거
		// datas.clear();
		
		// 1건 지우기
		CustomerDTO cust = datas.remove(new Student("학생3", "남", 100));	 //equals와 hashCode가 꼭 재정의되어있어야한다.
		System.out.println(cust + "가 지워짐");
		
		for(Entry<Student, CustomerDTO> entry:datas.entrySet()) {
			System.out.println("key(학생): " + entry.getKey());
			System.out.println("value(고객): " + entry.getValue());
			System.out.println("----------------------------------");
		}
	}

	private static void method2() {
		Map<String, Integer> datas = new HashMap<>();
		datas.put("홍길동", 100);
		datas.put("홍길동", 90);
		datas.put("박길동", 90);
		datas.put("김길동", 20);
		datas.put("최길동", 30);
		
		// 키가 있는지?
		System.out.println(datas.containsKey("바길동"));
		// 값이 있는지?
		System.out.println(datas.containsValue(90));
		
		Collection<Integer> scores = datas.values();	// 값들만 얻기
		int sum = 0;
		for(Integer score:scores) {
			sum += score;
		}
		System.out.println("총점은: " + sum);
	}

	private static void method1() {
		// Map interface 구현 클래스: HashMap, TreeMap, Properties ...
		// 키와 값의 쌍이다. (Map.Entry)
		// 제네릭에 기본형타입은 쓸수없음
		Map<String, Integer> datas = new HashMap<>();
		datas.put("홍길동", 100);
		datas.put("홍길동", 90);		// 같은 key가 이미 존재하면 덮어쓰기함
		datas.put("박길동", 10);
		datas.put("김길동", 20);
		datas.put("최길동", 30);
		System.out.println(datas);	// toString 재정의되어있다.
		
		// key를 이용해서 값을 얻는다.
		int value = datas.get("홍길동");
		System.out.println("val= " + value);
		
		// 모든 key 얻기
		Set<String> keys = datas.keySet();
		for(String key:keys) {
			System.out.println(key + "--> " + datas.get(key));
		}
		System.out.println("-----------------------------------------------------------");
		for(String key:datas.keySet()) {
			System.out.println(key + "--> " + datas.get(key));
		}
		System.out.println("*********************************************************");
		// entry 얻기. entry : 키-값 쌍으로 구성된 객체?
		Set<Entry<String, Integer>> entrys = datas.entrySet();
		Iterator<Entry<String, Integer>> it = entrys.iterator();
		while(it.hasNext()) {
			Entry<String, Integer> entry = it.next();
			System.out.println("key: "+entry.getKey());
			System.out.println("value: "+entry.getValue());
			System.out.println("----------------------------");
		}
		System.out.println("*********************************************************");
		for(Entry<String, Integer> e:entrys) {
			System.out.println("key: "+e.getKey());
			System.out.println("value: "+e.getValue());
			System.out.println("----------------------------");
		}
		

	}

}
