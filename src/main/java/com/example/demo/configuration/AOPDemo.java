package com.example.demo.configuration;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class AOPDemo
{

	//Everytime method with name getBooks() is called, the below Method will be called
	//Avoids duplicacy of code
	
	@Before(value="execution(public java.util.List getBook())")
	public void beforeAdvice(JoinPoint joinPoint) throws Throwable
	{
		System.out.println("Before method:"+joinPoint.getSignature());
	}
	
	
//	Cannot find by directly using get(). needs to start with anything other than get*
	@After(value="execution(public * ssget*(*))")
	public void afterAdvice(JoinPoint joinPoint) throws Throwable
	{
		System.out.println("After method:"+joinPoint.getSignature());
		
	}
	
	
//	To work around the get methods
	@After(value="execution(public * com.example.demo.controller.BookController.get*(*))")
	public void after2Advice(JoinPoint joinPoint) throws Throwable
	{
		System.out.println("After method:"+joinPoint.getSignature());
		
	}
}
