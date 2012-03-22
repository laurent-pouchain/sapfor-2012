package istic.sapfor.client.gui;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public abstract class ContainerAbstract {
	protected ClassPathXmlApplicationContext context = null;

	public void setContext(ClassPathXmlApplicationContext context) {
		this.context = context;
	}
	
}
