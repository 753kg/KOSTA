package com.kosta.sample4AOP;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.springframework.util.StopWatch;

// Advice : 보조업무
public class LoggingAdvice2 implements MethodInterceptor {
	public Object invoke(MethodInvocation invocation) throws Throwable {
		// 보조업무
		System.out.println("LoggingAdvice2" + invocation.getMethod() + "메서드 호출 전");	// 주업무의 함수 이름 얻기		
		StopWatch watch = new StopWatch("계산시간");	// 이름 줌
		watch.start();

		Object object = invocation.proceed();	// 주업무를 수행

		// 보조업무
		System.out.println("LoggingAdvice2" + invocation.getMethod() + "메서드 호출 후");
		watch.stop();
		System.out.println("주 업무 수행 시간: " + watch.getTotalTimeMillis());
		System.out.println(watch.prettyPrint());
		return object;	// 주업무 수행 결과를 return
	}
}

