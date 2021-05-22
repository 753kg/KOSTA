package com.kosta.day09;

import java.util.Arrays;
import java.util.Date;

public class ObjectTest2 {

	public static void main(String[] args) {
		method3();
	}
	
	private static void method10() {
		String[] arr = {"네비게이터","전방카메라"};
		Car car = new Car("그랜져", 5000, arr);
		Car car2 = null;
		try {
			car2 = (Car) car.clone();
		} catch (CloneNotSupportedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		car.model = "SM7";
		car.price = 6000;
		car.악세사리[0] = "자바책";
		System.out.println(car);
		System.out.println(car2);	// 배열은 복제가 안됐음 = 얕은 복제
		
	}

	private static void method9() {
		// 1. clone 쓰려면 Car 클래스에서 implements Cloneable 인터페이스를 구현해야한다. 
		// 2. clone 재정의하기
		// 3. clone의 return 타입 : Object --> 형변환하기
		// 4. clone에서 throws한 Exception처리
		Car car = new Car("그랜져", 5000);	// 주소 복사 => 복제 X
		Car car2 = null;
		try {
			car2 = (Car) car.clone();
		} catch (CloneNotSupportedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		car.model = "SM7";
		System.out.println(car);
		System.out.println(car2);
	}
	
	private static void method8() {
		Car car = new Car("그랜져", 5000);
		Car car2 = car;		// 주소 복사 => 복제 X
		car.model = "SM7";
		System.out.println(car);
		System.out.println(car2);
	}

	private static void method7() {
		// 복제... 주소 복사
		int[] a = {1, 2, 3, 4, 5};
		int[] b = a;	// 복제된게아니다
		a[0] = 99;
		System.out.println(Arrays.toString(a));
		System.out.println(Arrays.toString(b));
	}
	
	private static void method6() {
		// 복제... 값을 복사
		int a = 10;
		int b = a;		// 복제된다.
		a++;
		System.out.println(a);
		System.out.println(b);
	}
	
	private static void method5() {
		String s = new String("자바");
		String s2 = s;
		s = new String("DB");
		System.out.println(s);
		System.out.println(s2);
	}

	private static void method4() {
		Date d1 = new Date();
		System.out.println(d1);
		System.out.println(d1.toGMTString());
		try {
			Thread.sleep(2000);		// 2초 멈추기
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		
		Date d2 = new Date();
		
		System.out.println(d2);
		System.out.println(d2.toLocaleString());
	}

	private static void method3() {
		Car obj1 = new Car("자바", 1000);
		Car obj2 = new Car("자바", 1000);
		//toString : class이름@hax(hashcode)
		System.out.println(obj1);		// Car는 toString을 재정의안해서 Object와 같음
		System.out.println(obj2);		// toString 재정의했음
	}
	
	private static void method2() {
		String obj1 = new String("자바");
		String obj2 = new String("자바");
		//toString : class이름@hax(hashcode)
		System.out.println(obj1);		// String은 toString을 재정의해놔서 내용이 출력됨
		System.out.println(obj2);
		System.out.println(obj1.hashCode());		// String은 내용 같으면 같은 hashCode
		System.out.println(obj2.hashCode());
	}

	private static void method1() {
		Object obj1 = new Object();
		Object obj2 = new Object();
		//toString : class이름@hax(hashcode)
		System.out.println(obj1);		// obj1.toString()과 같음
		System.out.println(obj2);
	}

}
