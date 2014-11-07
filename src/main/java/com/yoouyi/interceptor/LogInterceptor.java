package com.yoouyi.interceptor;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LogInterceptor {
	@Before("execution(* com.zgt..*.*(..))")
	public void before(){
		System.out.println("---aop before!");
	}

}
