package kr.co.sist.aop;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class ItemAOP {

	@Before("execution( * searchItem(String))")
	public void before() {
		System.out.println("before advice");
	}//before
	
}//class
