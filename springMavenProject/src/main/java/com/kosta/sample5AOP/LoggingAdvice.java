package com.kosta.sample5AOP;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

// Advice : 보조업무

@Component	//bean으로 만듦
@Aspect 	// 이 Class 안에 PointCut, Advice가 있다 = Advisor
public class LoggingAdvice {
	
	@Pointcut("execution(* add(int))")
	public void targetMethod() {	// 함수 이름은 사용자가 정한다.
		// Pointcut은 메서드형태로 넣어야해서 targetMethod() 그냥 만듦
		// pointcut으로 target을 정함
	}
	
	// Arount : 보조업무를 전, 후 모두 실행
	@Around("targetMethod()")
	public Object arroundMethod(ProceedingJoinPoint joinPoint) throws Throwable {
		String methodName = joinPoint.getSignature().getName(); // 주업무의 함수 이름 얻기
		
		System.out.println("[메서드 호출 전 : LogginAdvice의 " + methodName + "]");

		Object object = joinPoint.proceed();	// 주업무를 수행

		System.out.println("[메서드 호출 후 : loggingAdvice의 " + methodName + "]");
		return object;	// 주업무 수행 결과를 return
	}
}

