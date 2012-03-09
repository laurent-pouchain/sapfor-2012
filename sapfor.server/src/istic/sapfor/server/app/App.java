package istic.sapfor.server.app;


import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Server launching

		System.out.println("SapFor Server starting ..");
		ApplicationContext context = new ClassPathXmlApplicationContext("application-context.xml");

				
	}

}
