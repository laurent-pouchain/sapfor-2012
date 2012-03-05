package istic.sapfor.server.app;

import istic.sapfor.api.dto.*;
import istic.sapfor.server.datastore.DataStore;

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

		// Essais  d'accès à la fausse base de données
		
		DataStore fDS;
		StageDTO s;
		
		fDS = (DataStore) context.getBean("sharedDataStore");
		
		
		for (int i = 0; i < 10; i++ ) {
			    s = fDS.getStage((long)i);
			    System.out.print("Nom du Stage : ");
				System.out.println(s.getTitle()+" (à "+s.getLocality()+")");
				System.out.println("Composé des Uvs suivantes : ");
				for (Long idUv : s.getListIdUv()) {
					System.out.println(fDS.getUv(idUv).getTitle());
				}
				System.out.println("");
		}
		
				
	}

}
