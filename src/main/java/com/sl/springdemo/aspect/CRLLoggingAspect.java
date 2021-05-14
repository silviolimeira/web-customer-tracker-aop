package com.sl.springdemo.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.jboss.logging.Logger;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class CRLLoggingAspect {

	// setup logger
	private Logger logger = Logger.getLogger(getClass().getName());
	
	
	// so the same for service and dao
	@Pointcut("execution(* com.sl.springdemo.controller.*.*(..))")
	private void forControllerPackage() { }
	
	// setup pointcut declarations
	@Pointcut("execution(* com.sl.springdemo.service.*.*(..))")
	private void forServicePackage() { }

	// setup pointcut declarations
	@Pointcut("execution(* com.sl.springdemo.dao.*.*(..))")
	private void forDaoPackage() { }

	@Pointcut("forControllerPackage() || forServicePackage() || forDaoPackage()")
	private void forAppFlow() { }
	
	// add @Before advice
	@Before("forAppFlow()")
	public void before(JoinPoint joinPoint) {
		
		// display method we are calling
		String method = joinPoint.getSignature().toShortString();
		System.out.println("=====>> in @Before: calling method: " + method);
		
		// display the arguments to the method
		
		// get the arguments
		Object[] args = joinPoint.getArgs();
		
		// loop thru and display args
		for (Object tempArg : args) {
			System.out.println("=====>> argument: " + tempArg);
		}
		
	}
	
	@AfterReturning(
			pointcut="forAppFlow()",
			returning="result")
	public void afterReturning(JoinPoint joinPoint, Object result) {
		// display method we are returning from
		String method = joinPoint.getSignature().toShortString();
		System.out.println("=====>> in @AfterReturning: from method: " + method);
		
		// display data returned
		System.out.println("=====>> result: " + result);
	}
	
}
