package org.sample;

import javax.enterprise.context.Dependent;

@Dependent
public class SimpleGreeting implements Greeting {

	@Override
	public String sayHello() {
		// TODO Auto-generated method stub
		return "Hello World";
	}

}
