package com.kosta.day10;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class ClassTest {

	public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		method3();
	}
	

	private static void method3() throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		method6("com.kosta.day10.Book");
		method6("com.kosta.day10.Car");

	}
	
	private static void method6(String className) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		Class cls2 = Class.forName(className);
		System.out.println(cls2.getSimpleName());
		
		// 객체얻기
		Object obj = cls2.newInstance();	// className의 기본생성자를 호출
		if(obj instanceof Book) {
			String s = ((Book)obj).getTitle();
			System.out.println(s);
		}
		if(obj instanceof Car) {
			((Car)obj).setModel("모델");
			System.out.println(((Car)obj).getModel());
		}
	}

	private static void method5(String className) throws ClassNotFoundException {
		Class cls2 = Class.forName(className);		// 클래스를 메모리에 올려라
		System.out.println(cls2.getSimpleName());
		
		Method[] methods = cls2.getDeclaredMethods();
		for(Method m:methods) {
			System.out.println("Method이름: "+m.getName());
			Class[] cc = m.getParameterTypes();		// Method의 파라미터 타입
			for(Class c:cc) {
				System.out.println(c.getSimpleName());
			}
		}
		System.out.println("****************************");
	}

	private static void method4(String className) throws ClassNotFoundException {
		Class cls2 = Class.forName(className);		// 클래스를 메모리에 올려라
		System.out.println(cls2.getSimpleName());
		
		Field[] fields = cls2.getDeclaredFields();
		for(Field f:fields) {
			System.out.println(f.getName());					// 변수이름
			System.out.println(f.getType().getSimpleName());	// 변수의 타입
		}
		System.out.println("****************************");
	}
	
	
	private static void method2(String className) throws ClassNotFoundException {
		//className : 가변
		// 리플렉션??????
		Class cls2 = Class.forName(className);
		System.out.println(cls2.getSimpleName());
		
		Constructor[] constructors = cls2.getDeclaredConstructors();		// 생성자 얻기
		for(Constructor cc:constructors) {
			System.out.println("생성자이름:" + cc.getName());
			System.out.println("생성자의 파라미터 갯수:"+cc.getParameterCount());
			Class[] cls = cc.getParameterTypes();	// 생성자의 파라미터 타입
			for(Class c : cls) {
				System.out.println(c.getName());	
			}
		}
		System.out.println("----------------------------------");
	}

	private static void method1() {
		Book b = new Book("java", 10000, false);
		Class cls1 = b.getClass();			// Book의 메타데이터 얻기
		System.out.println(cls1.getName());	// 이름
		System.out.println(cls1.getPackage().getName());
		System.out.println(cls1.getModifiers());	// class의 접근지정자
		
		try {
			Class cls2 = Class.forName("com.kosta.day10.Book");		// class를 메모리에 로드
			System.out.println(cls2.getName());
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
