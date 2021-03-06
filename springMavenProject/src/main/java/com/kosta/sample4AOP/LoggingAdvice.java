package com.kosta.sample4AOP;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

// Advice : 보조업무
public class LoggingAdvice implements MethodInterceptor {
	public Object invoke(MethodInvocation invocation) throws Throwable {
		System.out.println("[메서드 호출 전 : LogginAdvice");
		System.out.println(invocation.getMethod() + "메서드 호출 전");	// 주업무의 함수 이름 얻기

		Object object = invocation.proceed();	// 주업무를 수행

		System.out.println("[메서드 호출 후 : loggingAdvice");	// 주업무 아래에 들어와서 보조업무 수행
		System.out.println(invocation.getMethod() + "메서드 호출 후");
		return object;	// 주업무 수행 결과를 return
	}
}

