package com.kosta.day12;

import java.util.ArrayList;
import java.util.List;

import javax.swing.plaf.synth.SynthOptionPaneUI;

public class GenericTest {

	public static void main(String[] args) {
		method1();
	}
	
	private static void method8() {
		int result = Util.compare2(new TV(), new TV());
		System.out.println(result);
		
		// Machine을 상속받은 것만 가능
//		int result2 = Util.compare2(new Coffee(), new Coffee());
		int result2 = Util.compare2(new NoteBook(), new NoteBook());
		System.out.println(result2);
	}

	private static void method7() {
		int result = Util.compare(100, 100);
		System.out.println(result);
	}

	private static void method6() {
		Pair<String, String> p1 = new Pair();
		p1.setKey("이름");
		p1.setValue("사과");
		
		Pair<String, String> p2 = new Pair();
		p2.setKey("이름");
		p2.setValue("오렌지");
		
		boolean result1 = Util.compare(p1, p2);
		System.out.println(result1);
		
		Pair<String, Integer> p3 = new Pair();
		p3.setKey("한라봉");
		p3.setValue(1000);
		
		Pair<String, Integer> p4 = new Pair();
		p4.setKey("한라봉");
		p4.setValue(1000);
		
		boolean result2 = Util.compare(p3, p4);
		System.out.println(result2);
	}

	private static void method5() {
		Box<Integer> a = Util.boxing(100);
		Box<Integer> b = Util.<Integer>boxing(100);
		
		Box<String> c = Util.boxing("Hello");
		Box<String> d = Util.<String>boxing("Hello");
		
		Box<TV> e = Util.boxing(new TV());
		Box<TV> f = Util.<TV>boxing(new TV());
		
		System.out.println((a.getObj()));
		System.out.println((b.getObj()));
		System.out.println((c.getObj()));
		System.out.println((d.getObj()));
		System.out.println((e.getObj()));
		System.out.println((f.getObj()));

		
		
				
	}

	private static void method4() {
		// Generic : 사용하는 쪽에서 Type 결정
		Product<TV, String> p1 = new Product(new TV(), "S1234", 100);
		System.out.println(p1);
		
		Product<NoteBook, String> p2 = new Product(new NoteBook(), "N1234", 100);
		System.out.println(p2);
		
		Product<Coffee, Integer> p3 = new Product(new Coffee(), 1234, 100);
		System.out.println(p3);
	}

	private static void method3() {
		// 기본형은 안됨
		Box<Integer> b = new Box<Integer>();
		b.setObj(100);
		int i = b.getObj();			// 형변환 안해도됨
		System.out.println(i);
		
		Box<String> b2 = new Box<String>();
		b2.setObj("Hello");
		String s = b2.getObj();
		System.out.println(s);
	}

	private static void method2() {
		Box b = new Box();
		
		b.setObj(100);
		int i = (int)b.getObj();
		System.out.println(i);
		
		b.setObj("Hello");
		Integer s = (Integer)b.getObj();	// 컴파일 시 에러가 안남
		System.out.println(s);
	}

	private static void method1() {
		// 배열... 반드시 같은 타입, 여러 개의 방을 만든다. 
		// 갯수는 반드시 알아야한다. 갯수 고정
		String[] arr = new String[10];
		
		// Collection: List, Set, Map
		// 아무 타입이나 , 여러개 (갯수 가변)
		List list = new ArrayList(2);		// 연속공간 2개를 만듦
		list.add(100);
		list.add("자바");
		list.add(new MailBox());			// 2개 넘어도 넣어짐
		int i = (Integer)list.get(0);
		String s = (String)list.get(1);		// 모든 타입을 넣을 수 있지만, 형변환 불편. 사용 불편
		System.out.println(i);
		System.out.println(s);
		
		List<String> list2 = new ArrayList<String>(2);
//		list2.add(100);						// 컴파일 단계에서 에러를 알려줌 (장점)
		list2.add("자바");
//		list2.add(new MailBox());
//		int i = (Integer)list.get(0);
		String s2 = list2.get(0);			
		System.out.println(s2);
	}

}
