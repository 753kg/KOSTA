package com.kosta.sample2;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class DITest {

	public static void main(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("sample2.xml");
		// Car를 2개 등록해서 생성자가 2번 호출됨
		People p1 = ctx.getBean("people2", People.class);	// id를 입력
		People p2 = ctx.getBean("people2", People.class);	// id를 입력
		System.out.println(p1);
		System.out.println(p2);
		System.out.println(p1==p2);//주소가같다
		System.out.println(System.identityHashCode(p1));
	    System.out.println(System.identityHashCode(p2));

	}

}
