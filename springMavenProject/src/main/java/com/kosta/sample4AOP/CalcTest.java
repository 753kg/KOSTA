package com.kosta.sample4AOP;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class CalcTest {
	   public static void main(String[] args){
		  // 주 업무와 보조업무를 분리해서 spring aop가 자동으로 주입시켜줌
	      ApplicationContext context=new ClassPathXmlApplicationContext("AOPTest.xml");
	      Calculator cal=(Calculator)context.getBean("proxyCal");
	      
	      cal.add();
	      cal.add(3);
	      
	      cal.add(100,20);
	      System.out.println();
	      cal.subtract(100,20);
	      System.out.println();
	      cal.multiply(100,20);
	      System.out.println();
	      cal.divide(100,20);
	   }
	}

