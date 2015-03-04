package org.sample;

import javax.enterprise.context.Dependent;

@Dependent
@Fancy
public class FancyGreeting implements Greeting {

	@Override
	public String sayHello() {
		// TODO Auto-generated method stub
		return "Hello fancy world";
	}

}
