package com.kosta.sample3;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.FileSystemResource;

public class MemberTest1 {
	public static void main(String[] args) {
		method2();
	}

	private static void method3() {
		// TODO Auto-generated method stub
		ApplicationContext context = new ClassPathXmlApplicationContext("member2.xml");
		Car c1 = context.getBean("car1", Car.class);
		System.out.println(c1);
	}

	private static void method2() {
		// 2. Annotation 기반으로 bean 객체생성하여 사용하기 (XML에서 어노테이션 해석)
		ApplicationContext context = new ClassPathXmlApplicationContext("member2.xml");
		MemberServiceImpl service = context.getBean("memberServiceImpl", MemberServiceImpl.class);
		service.listMembers();
	}

	private static void method1() {
		// 1. XML에 bean을 등록하고 사용하기 (XML 설정 이용해서 bean 사용하기)
		ApplicationContext context = new ClassPathXmlApplicationContext("member.xml");
		MemberServiceImpl service = context.getBean("service1", MemberServiceImpl.class);
		service.listMembers();
	}
}
