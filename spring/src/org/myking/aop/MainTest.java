package org.myking.aop;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainTest {
	@Test
	public void test(){
ApplicationContext ctx =new ClassPathXmlApplicationContext("org/myking/aop/AspectTest.xml");
ServiceIF service = (ServiceIF)ctx.getBean("ServiceA");
service.bye();
System.out.println("===================");
service.hello();
		
	}
}
