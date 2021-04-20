package com.bitacademy.aoptest;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect		// 횡단 관심 객체
@Component
public class MyAspect {
	// 명시된 메서드 실행 이전
	@Before("execution(public ProductVo com.bitacademy.aoptest.ProductService.findProduct(..))")
	public void before() {
		System.out.println("call [before advice]");
	}
	
	// 조건을 만족하는 메서드 실행 이후
	@After("execution (* com.bitacademy.aoptest.*.findProduct(String))")
	public void after() {
		System.out.println("call [after advice]");
	}
	
	// 메서드 수행 이후 해당 메서드의 결과 객체 확인할 때(예외 없이 정상으로 수행 종료 시)
	// 메서드 수행 결과 객체 -> returning에 명시한 이름으로 할당
	@AfterReturning(value="execution(* *..ProductService.findProduct(..))", returning="vo")
	public void afterReturning(ProductVo vo) {
		System.out.println("call [afterReturning advice]");
		System.out.println("메서드의 결과 겍체: " + vo);
	}
	
	// 메서드 수행 시 예외 발생했을 때 예외 객체 확인
	// 메서드 수행 시 발생한 예외 -> throwing에 명시한 이름에 할당
	@AfterThrowing(value="execution(* findProduct(String))", throwing="ex")
	public void afterThrowing(Throwable ex) {
		System.err.println("call [afterThrowing advice]");
		System.err.println("발생한 예외 정보 : " + ex.getMessage());
	}
}
