package com.kosta.sample5AOP;

import org.springframework.stereotype.Component;

//Target
@Component
public class Calculator {
	public void add() {
		System.out.println("arg 0개인 add");
	}
	
	public void add(int x) {
		System.out.println("arg 1개인 add");
	}
	
	public void add(int x, int y) {
		// 보조업무 (ex. 로그인체크, 등급 권한 확인) ==> AOP로
		
		// 주업무
		int result=x+y;
		System.out.println("결과:"+ result);
		
		// 보조업무 (ex. 로그남기기)
	}

	public void subtract(int x, int y) {
		int result=x - y;
		System.out.println("결과:"+ result);
	}

	public void multiply(int x, int y) {
		int result=x * y;
		System.out.println("결과:"+ result);
	}

	public void divide(int x, int y) {
		int result=x / y;
		System.out.println("결과:"+ result);
	}
}
