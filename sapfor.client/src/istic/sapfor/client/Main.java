package istic.sapfor.client;

import istic.sapfor.client.gui.ContainerGestionStage;


import org.springframework.context.support.ClassPathXmlApplicationContext;




public class Main {
	public static void main(String[] args) throws Exception {
		
		/* Init Spring Default Config */
	  
final ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(new String[] {"sapforclient.xml"});

		
ContainerGestionStage rootUI = (ContainerGestionStage) context.getBean("ui1");
rootUI.showUI(context);

		
	
}

	
}