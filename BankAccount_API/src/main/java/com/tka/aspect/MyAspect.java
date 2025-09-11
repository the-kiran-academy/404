package com.tka.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class MyAspect {

//	@Before("execution(* com.tka.controller.*.*(..))")
//	public void runBefore() {
//		System.out.println("API Execution Started...");
//	}
//	
//	@After("execution(* com.tka.controller.*.*(..))")
//	public void runAfter() {
//		System.out.println("API Execution Ended...");
//	}
//	@Around("execution(* com.tka.controller.*.*(..))")
//	public Object runAround(ProceedingJoinPoint pj) throws Throwable {
//		System.out.println("API Execution Started...");
//		Object obj = pj.proceed();
//		System.out.println("API Execution Ended...");
//		return obj;
//	}
	
//	@AfterReturning(pointcut="execution(* com.tka.controller.*.*(..))",returning="res")
//	public void runafterReturn(Object res) {
//		System.out.println("API Execution Successfully Completed...");
//	}
//	@AfterThrowing(pointcut="execution(* com.tka.controller.*.*(..))",throwing ="ex")
//	public void runAfterError(Exception ex) {
//		System.out.println("API Execution Faild" +ex);
//	}
}
