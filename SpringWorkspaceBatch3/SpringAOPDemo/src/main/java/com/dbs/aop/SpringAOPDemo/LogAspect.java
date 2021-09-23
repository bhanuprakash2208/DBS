package com.dbs.aop.SpringAOPDemo;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LogAspect {
	
	public LogAspect() {
		System.out.println("Log aspect Constructor");
	}
	//point Expression
	@Before("execution(public * com.dbs.aop.SpringAOPDemo.EmpService.setCname(..))")
	public void beforeAdvice() {
		System.out.println("Before cname Applied");
	}
	@After("execution(public * apply*(..))")
	public void afterAdvice(JoinPoint jp) {
		System.out.println(jp.getTarget());
		System.out.println("After Advice Applied");
	}

	@AfterReturning(pointcut = "execution(public * applyNow())", returning = "status")
	public void afterReturning(JoinPoint jp, String status) {
		System.out.println();
		System.out.println(jp.getTarget());
		System.out.println("After Returning Advice Applied "+status);
	}
	@AfterThrowing(pointcut = "execution(public * applyThen())", throwing = "ex")
	public void afterThrowing(Exception ex) {
		System.out.println();
		System.out.println("After Returning Advice Applied "+ex.getMessage());
	}
	@Around("execution(public *  balance(..))")
	public Object around(ProceedingJoinPoint pjp)
	{
		System.out.println("around advice before method call");
		double value = 0.0;
		try {
			value = (double)pjp.proceed();
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("around advice after method call");
		value += 1000;
		return value;
	}
	
}
