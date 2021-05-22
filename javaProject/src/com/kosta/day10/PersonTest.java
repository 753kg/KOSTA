package com.kosta.day10;

import java.util.Arrays;

public class PersonTest {

	public static void main(String[] args) throws CloneNotSupportedException {
		sample1();
	}


	private static void sample3() {
		// 배열 비교
		String[] phone1 = new String[]{"010-1111-1111", "02-2222-2222"};
		String[] phone2 = new String[]{"010-1111-1111", "02-2222-2222"};
		boolean b = Arrays.equals(phone1, phone2);
		System.out.println(b);
	}


	private static void sample1() throws CloneNotSupportedException {
		Car c1 = new Car("SM7", 4000);
		Car c2 = new Car("SM7", 4000);
		System.out.println(c1.hashCode());	// 모델,가격 같으면 hashcode같게 재정의함
		System.out.println(c2.hashCode());	// 같다

		// 배열 선언시 new String[]이 생략돼있음
		// String[] phone = {"010-1111-1111", "02-2222-2222"};

		String[] phone1 = new String[]{"010-1111-1111", "02-2222-2222"};
		String[] phone2 = new String[]{"010-1111-1111", "02-2222-2222"};

		Person p1 = new Person("홍길동", 20, c1, phone1);
		Person p2 = new Person("김길동", 30, 
				new Car("그랜져", 5000), 
				new String[]{"010-3333-3333", "02-4444-4444"});
		Person p3 = new Person("홍길동", 20, c2, phone2);
		
		// 복제 X, 같은 주소 참조
		Person p4 = p3;		
		p3.setName("박가산");
		System.out.println("p3: " + p3);
		System.out.println("p4: " + p4);
		// 복제 : 원본이 수정되어도 복제된 객체는 수정되지않는다. 각자의 정보를 관리
		// 얕은복제는 impements Cloneable, clone()메서드 추가
		// 깊은복제는 clone()메서드에 코드 추가
		Person p5 = (Person)p3.clone();
		p3.setName("김길동");
		p3.setAge(50);
		p3.getCar().setModel(null);		// 수정된 모델
		p3.getPhone()[0] = "0000";		// 복제가 아님을 확인
//		p3.setCar(new Car("수정모델", 1000));	// 신규 생성해서 참조 객체를 바꿔버림. 당연히 주소가 바뀜
//		p3.setPhone(new String[] {"1234", "5678"});
		System.out.println("p3: " + p3);
		System.out.println("p5: " + p5);
		
		System.out.println(p1.hashCode());
		System.out.println(p3.hashCode());
		System.out.println(p1.equals(p3)?"이름,나이,차같다":"다름");	// name이 같으면 같다로 재정의했음
		
	}

}
