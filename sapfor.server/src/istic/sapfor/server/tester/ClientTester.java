package istic.sapfor.server.tester;

import java.util.Collection;
import java.util.Date;
import java.util.Vector;

import org.springframework.beans.factory.InitializingBean;

import istic.sapfor.api.dto.*;
import istic.sapfor.server.datastore.DataStore;

public class ClientTester implements InitializingBean {

	private DataStore dataStore = null;

	public DataStore getDataStore() {
		return dataStore;
	}

	public void setDataStore(DataStore dataStore) {
		this.dataStore = dataStore;
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		//TODO TESTS
		System.out.println("DataStore Injected = "+dataStore);
		
		DataStore fDS = dataStore;
		
		for (int i = 0; i < fDS.nbStages(); i++ ) {
		    StageDTO s = fDS.getStage((long)i);
		    System.out.print("Nom du Stage : ");
			System.out.println(s.getTitle()+" (à "+s.getLocality()+")");
			System.out.println("Composé des Uvs suivantes : ");
			for (Long idUv : s.getListIdUv()) {
				System.out.println(fDS.getUv(idUv).getTitle());
			}
			System.out.println("");
	    }
		
		for (int i = 0; i < fDS.nbUvs(); i++ ) {
			UvDTO u = fDS.getUv((long)i);
		    System.out.print("Nom de l'UV : ");
			System.out.println(u.getTitle()+" (à "+u.getLocality()+")");
			System.out.println("");
	    }
		
		System.out.println("-------Ajout d'une UV------------");
		
		UvDTO uv = new UvDTO();
		
		uv.setIdTypeUv(1);
		uv.setTitle("Basics-Essai-Entrée");
		uv.setLocality("Paris");
		Collection<Date> dates = new Vector<Date>();
		uv.setDates(dates);
		uv.setDateLimite(new Date());
		
		fDS.addUv(uv);
		
        System.out.println("Id de l'uv : "+uv.getIdUv()+" ");
        System.out.println("taille de la map : "+fDS.nbUvs()+" ");


		for (int i = 0; i < 100; i++ ) {
			if (fDS.getUv((long)i)!=null){
			  UvDTO u = fDS.getUv((long)i);
		      System.out.print("Nom de l'UV (id : "+i+") : ");
			  System.out.println(u.getTitle()+" (à "+u.getLocality()+")");
			  System.out.println("");
			}
		}
		
		System.out.println("-------Suppresion d'une UV------------");

		fDS.delUv(5);
		
		for (int i = 0; i < 100; i++ ) {
			if (fDS.getUv((long)i)!=null){
			  UvDTO u = fDS.getUv((long)i);
		      System.out.print("Nom de l'UV (id : "+i+") : ");
			  System.out.println(u.getTitle()+" (à "+u.getLocality()+")");
			  System.out.println("");
			}
		}
		
		
		
	}
	
	
	
	
}
