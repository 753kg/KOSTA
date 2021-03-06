package com.kosta.sample5AOP;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;

// Advice : 보조업무
@Component
@Aspect
public class LoggingAdvice2{
	
	@Pointcut("execution(* sub*(..))")
	public void pointcut() {
		
	}
	
	@Before("pointcut()")
	public void beforeAA(JoinPoint jp) {
		System.out.println("-------- before " + jp.getSignature().toShortString() +" ---------");
	}
	
	@After("pointcut()")
	public void afterAA(JoinPoint jp) {
		System.out.println("-------- after ---------");
	}
	
	@AfterReturning("pointcut()")
	public void afterReturnAA(JoinPoint jp) {
		System.out.println("-------- afterReturning 예외없이 실행된 후 ---------");
	}
	
	@AfterThrowing("pointcut()")
	public void afterThrowingAA(JoinPoint jp) {
		System.out.println("-------- afterThrowing 예외 발생시 ---------");
	}
	
	@Around("pointcut()")
	public Object invoke(ProceedingJoinPoint joinPoint) throws Throwable {
		// 보조업무
		String methodName = joinPoint.getSignature().getName();
		System.out.println("[LoggingAdvice2 " + methodName + "메서드 호출 전]");	// 주업무의 함수 이름 얻기		
		StopWatch watch = new StopWatch("계산시간");	// 이름 줌
		watch.start();

		Object object = joinPoint.proceed();	// 주업무를 수행

		// 보조업무
		System.out.println("[LoggingAdvice2 " + methodName + "메서드 호출 후]");
		watch.stop();
		System.out.println("주 업무 수행 시간: " + watch.getTotalTimeNanos());
		return object;	// 주업무 수행 결과를 return
	}
}

