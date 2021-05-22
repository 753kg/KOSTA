package com.kosta.day14;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.NavigableMap;
import java.util.TreeMap;

import com.kosta.day13.model.CustomerDTO;

public class CollectionTest4 {

	public static void main(String[] args) {
		method2();
	}
	
	private static void method2() {
		
		//Map<Car, CustomerDTO> datas = new HashMap<>();	// hashCode, equals 구현
		TreeMap<Car, CustomerDTO> datas = new TreeMap<>();		// compareTo 구현
		// Car가 key
		datas.put(new Car("ABC모델", 2000), new CustomerDTO(100, "고객1", "534", "서울"));
		datas.put(new Car("DDD모델", 8000), new CustomerDTO(100, "고객2", "444", "서울"));
		datas.put(new Car("EEE모델", 1000), new CustomerDTO(100, "고객3", "129", "서울"));
		datas.put(new Car("ZZZ모델", 7000), new CustomerDTO(100, "고객4", "998", "서울"));
		
		{
		Entry<Car, CustomerDTO> entry = datas.firstEntry();
		System.out.println("first ====> " + entry);	// key = value 로 출력됨
//		System.out.println("key: " + entry.getKey());
//		System.out.println("value: " + entry.getValue());
		
		entry = datas.lowerEntry(new Car("ZZZ모델", 7000));
		System.out.println("lower ====> " + entry);
		entry = datas.higherEntry(new Car("ZZZ모델", 7000));
		System.out.println("higher ====> " + entry);
		}
		
		// 원본 출력
		for(Entry<Car, CustomerDTO> entry:datas.entrySet()) {
			System.out.println("key: " + entry.getKey());
			System.out.println("value: " + entry.getValue());
			System.out.println("-----------------------------------------------");
		}
		
		// descending
		NavigableMap<Car, CustomerDTO> dsc = datas.descendingMap();
		for(Entry<Car, CustomerDTO> entry:dsc.entrySet()) {
			System.out.println("key: " + entry.getKey());
			System.out.println("value: " + entry.getValue());
			System.out.println("-----------------------------------------------");
		}
	}

	private static void method1() {
		Map<String, Integer> datas = new TreeMap<>();
		datas.put("홍길동", 100);
		datas.put("홍길동", 90);
		datas.put("박길동", 90);
		datas.put("김길동", 20);
		datas.put("최길동", 30);
		System.out.println(datas);
	}

}
