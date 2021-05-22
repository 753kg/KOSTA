package com.kosta.day10;

import java.util.Arrays;
import java.util.Objects;

public class ObjectTest {

	public static void main(String[] args) {
		sample1();
	}
	
	private static void sample8() {
		Book[] bookList = new Book[5];
		bookList[0] = new Book("java", 25000, false);
		bookList[1] = new Book("sql", 20000, true);
		bookList[2] = new Book("html", 23000, false);
		bookList[3] = new Book("javascript", 35000, true);
		bookList[4] = new Book("javascript", 45000, false);
		
		Arrays.sort(bookList);	// 가격으로 ascending
		Arrays.sort(bookList, new BookDescendingComparator());	// 제목으로 descending, 가격으로 ascending
		
		for(Book b:bookList) {
			System.out.println(b);
		}
		
	}

	private static void sample7() {
		Car[] carList = new Car[3];
		carList[0] = new Car("A", 2000);
		carList[1] = new Car("C", 1000);
		carList[2] = new Car("A", 3000);
		System.out.println("before: "+Arrays.toString(carList));
		Arrays.sort(carList);
		System.out.println("asending sort: " + Arrays.toString(carList));
		Arrays.sort(carList, new CarDescending());
		System.out.println("desending sort: " + Arrays.toString(carList));
	}

	private static void sample6() {
		Integer[] arr = {10, 3, 5, 8, 4};
		System.out.println("before: "+Arrays.toString(arr));
		Arrays.sort(arr);	
		System.out.println("assending sort: " + Arrays.toString(arr));
		
		Arrays.sort(arr, new IntegerDescending());		// desending 구현한 클래스를 넣어줌
		System.out.println("desending sort: " + Arrays.toString(arr));
	
		}

	private static void sample5() {
		// sort
		int[] arr = {10, 3, 5, 8, 4};
		System.out.println("before: "+Arrays.toString(arr));
		
		Arrays.sort(arr);	// 오름차순
		System.out.println("after: " + Arrays.toString(arr));
		
		Car[] carList = new Car[3];
		carList[0] = new Car("A", 2000);
		carList[1] = new Car("C", 1000);
		carList[2] = new Car("A", 3000);
		System.out.println("before: "+Arrays.toString(carList));
		Arrays.sort(carList);	// Car Class에 compareTo 재정의한대로 sort됨?
		System.out.println("after: " + Arrays.toString(carList));
		}

	private static void sample4() {
		Car car1 = new Car("ABC", 7000);		
		Car car2 = new Car("DABC", 3000);
		// 누가 더 큰지 비교
		// Car implements Comparable	==> Sort
		int result = car1.compareTo(car2);
		System.out.println(result>0?"car1이더크다":"같거나 car2가더크다");
		
		
	}

	private static void sample3() {
		Object s1 = new Object();
		Object s2 = new Object();
		
	}

	private static void sample2() {
		String s1 = "A";
		String s2 = "C";
		// 누가 더 큰지?										s1   s2
		System.out.println(s1.compareTo(s2));	// A(65)-B(67) => -2
		// 앞에거 기준 - 같다:0, 작다:음수, 크다:양수
	}

	private static void sample1() {
		Car car1 = new Car("모델", 1000);
		System.out.println(car1);
		
		car1 = null;	// clear. GarbageCollector가 동작할 때 객체 소멸됨. 소멸될 때 finalize() 실행됨 
		System.gc();	// 가비지컬렉터를 수행한다. 가비지컬렉터 수행시점은 호출시점과 다르다.
		System.out.println(car1);
	}

}
