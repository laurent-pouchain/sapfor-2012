package istic.sapfor.client.gui;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ContainerGestionAdmin implements IHMAdmin {

	
private ClassPathXmlApplicationContext context = null;
private SapforJFrame frameAdmin;
	

	public void showUI(ClassPathXmlApplicationContext ctx) {
		
		context = ctx;
		//System.out.print("passage dans le container?");
		frameAdmin= new SapforJFrame("page admin"); //Création de la fenetre d'accueil des admin )
		frameAdmin.setVisible(true);

		
		
	
	}
	
}
