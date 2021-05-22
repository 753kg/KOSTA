package com.kosta.day10;

import java.util.Map;
import java.util.Properties;
import java.util.Set;

public class SystemTest {

	public static void main(String[] args) {
		method3();
	}

	private static void method4() {
			//key,  value
		Map<String, String> envs = System.getenv();		// OS의 환경변수
		Set<String> keys = envs.keySet();
		for(String s:keys) {
			System.out.println(s + " ==> " + System.getenv(s));
		}
	}

	private static void method3() {
		String s = System.getenv("JAVA_HOME");
		System.out.println(s);
		s = System.getenv("path");
		System.out.println(s);
	}

	private static void method2() {
		// Properties에는 key와 값이 쌍으로 들어있다 .
		// key 값 쌍으로 있는 걸 Map이라 한다.
		// Map : interface
		Properties ps = System.getProperties();
		Set<Object> keys = ps.keySet();
		
		for(Object obj:keys) {
			System.out.println(obj + " ==> " + System.getProperty((String)obj));
		}
	}

	private static void method1() {
		// 대표적인 key값들을 넣음 p.486
		System.out.println(System.getProperty("user.name"));
		System.out.println(System.getProperty("java.version"));
		System.out.println(System.getProperty("os.name"));
	}

}
