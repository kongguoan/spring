package org.myking.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Service;

@Aspect
@Service("aspt")
public class AspectTest {
	@Around  (value="execution(* org.myking.*.Service*.*(..))")
    public Object doAround(ProceedingJoinPoint pjp) throws Throwable {  
	  System.out.println("Around Before !! ");
    	 long time = System.currentTimeMillis();  
         Object retVal = pjp.proceed();  
         time = System.currentTimeMillis() - time;  
         System.out.println("process time: " + time + " ms"+"==value=["+retVal+"]");  
         System.out.println("Around After !! ");
         return retVal;
    } 
	@Before  (value="execution(* org.myking.*.Service*.*(..))")
    public void doBefore(JoinPoint jp) {  
        System.out.println("do before");
    }  
	@After (value="execution(* org.myking.*.Service*.*(..))")
	public void doAfter(JoinPoint jp) {  
		   System.out.println("do after");  
    }
	@AfterReturning  (value="execution(* org.myking.*.Service*.*(..))")
	public void afterReturn(JoinPoint jp){
		 System.out.println("do afterReturn");  
	}
	@AfterThrowing (value="execution(* org.myking.*.Service*.*(..))" ,throwing="ex")
	public void afterThrow(Exception ex){
		System.out.println("After Throwing : "+ex.getMessage());
		
	}
	@Pointcut (value="within(* org.myking.*.Service*.*(..))")
    public void pointCut(JoinPoint jp) {  
		System.out.println("pointCut");
    }  
  
 
}
