package com.kosta.sample1;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

public class TVUser {

	public static void main(String[] args) {
		test3();
	}
	
	private static void test6() {
		// 이걸 더 많이 쓴다.
		// 사용되기 전에 빈들을 미리 로딩
		ApplicationContext ctx = new ClassPathXmlApplicationContext("sample1.xml");
		Car cc = (Car) ctx.getBean("car");
		cc.carPrint();
	}
	
	private static void test5() {
		Resource resource = new ClassPathResource("sample1.xml");
		// BeanFactory : 사용될 때 생성된다.
		// 메모리가 효율적이어서 모바일에서 사용됨
		BeanFactory factory = new XmlBeanFactory(resource);
		// getBean을 해야 생성된다.
		Car cc = (Car) factory.getBean("car");
		//cc.carPrint();
	}
	
	private static void test4() {
		// 공장을 Spring이 만든다.
		Resource resource = new ClassPathResource("sample1.xml");
		BeanFactory factory = new XmlBeanFactory(resource);
		TV tv = factory.getBean("samsung", SamsungTV.class);	// 뒤에 클래스 이름 주면 형변환 해줌
		tv.powerOn();
		tv.powerOff();
	}

	private static void test3() {
		TV tv = TVFactory.makeTV("LG");
		if(tv == null) return;
		tv.powerOn();
		tv.powerOff();
		
	}

	private static void test2() {
		// 변경사항이 생겼을 때 수정을 최소한으로 하기 위해서 인터페이스 사용
		// 사용자가 new --> 생성자가 바뀔 경우 에러.. ===> factory pattern
		TV tv = new LgTV("Acompany", "EEE");
		tv.powerOn();
		tv.powerOff();
	}

	private static void test1() {
		SamsungTV tv = new SamsungTV("DDD");
		tv.powerOn();
		tv.powerOff();
	}

}
