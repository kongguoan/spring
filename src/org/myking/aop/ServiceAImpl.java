package org.myking.aop;

import org.springframework.stereotype.Service;

@Service("ServiceA")
public class ServiceAImpl implements ServiceIF{

	@Override
	public void hello() {
		System.out.println("hello A");
		throw new NullPointerException("ServiceA");
	}

	@Override
	public void bye() {
		System.out.println("bye A");
		
	}

}
