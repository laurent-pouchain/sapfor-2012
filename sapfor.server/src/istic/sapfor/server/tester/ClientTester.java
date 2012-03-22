package istic.sapfor.server.tester;

import java.util.Collection;
import java.util.Date;

import java.util.Vector;

import org.springframework.beans.factory.InitializingBean;

import istic.sapfor.api.dto.*;

import istic.sapfor.server.datastore.DataStore;
import istic.sapfor.service.impl.StatefullService;


public class ClientTester extends StatefullService implements InitializingBean {

/*
	public DataStore getDataStore() {
		return dataStore;
	}

	public void setDataStore(DataStore dataStore) {
		this.dataStore = dataStore;
	}
*/
	@Override
	public void afterPropertiesSet() throws Exception {
		// TODO TESTS
		System.out.println("DataStore Injected = " + dataStore);

//		DataStore dataStore = dataStore;

		for (int i = 0; i < dataStore.nbStages(); i++) {
			StageDTO s = dataStore.getStage((long) i);
			System.out.print("Nom du Stage : ");
			System.out.println(s.getTitle() + " (à " + s.getLocality() + ")");
			System.out.println("Composé des Uvs suivantes : ");
			for (Long idUv : s.getListIdUv()) {
				System.out.println(dataStore.getUv(idUv).getTitle());
			}
			System.out.println("");
		}

		for (int i = 0; i < dataStore.nbUvs(); i++) {
			UvDTO u = dataStore.getUv((long) i);
			System.out.print("Nom de l'UV : ");
			System.out.println(u.getTitle() + " (à " + u.getLocality() + ")");
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

		dataStore.addUv(uv);

		System.out.println("Id de l'uv : " + uv.getIdUv() + " ");
		System.out.println("taille de la map : " + dataStore.nbUvs() + " ");


		for (int i = 0; i < 100; i++ ) {
			if (dataStore.getUv((long)i)!=null){
			  UvDTO u = dataStore.getUv((long)i);
		      System.out.print("Nom de l'UV (id : "+i+") : ");
			  System.out.println(u.getTitle()+" (à "+u.getLocality()+")");
			  System.out.println("");
			}
		}
		
		System.out.println("-------Verification dans chaque Stage des UVs dispo pour chaque Agent------------");
		System.out.println();
		System.out.println();
		System.out.println("Agent 0 : "+ dataStore.getAgent((long)0).getFirstName() + " " + dataStore.getAgent((long)0).getName() );
		for (int i = 0; i < 100; i++ ) {
			if (dataStore.getStage((long)i)!=null){
				StageDTO s = dataStore.getStage((long)i);	
				System.out.print("Nom du Stage : ");
				System.out.println(s.getTitle()+" (à "+s.getLocality()+")");
				System.out.println("Composé des Uvs suivantes : ");
					for (Long idUv :  dataStore.getIdUvStageDispo((long)0,s.getIdStage())) {
						System.out.println(dataStore.getUv(idUv).getTitle());
					}
				System.out.println("");
				}
			}
		
		System.out.println();
		System.out.println();
		System.out.println("Agent 1 : "+ dataStore.getAgent((long)1).getFirstName() + " " + dataStore.getAgent((long)1).getName() );

		for (int i = 0; i < 100; i++ ) {
			if (dataStore.getStage((long)i)!=null){
				StageDTO s = dataStore.getStage((long)i);	
				System.out.print("Nom du Stage : ");
				System.out.println(s.getTitle()+" (à "+s.getLocality()+")");
				System.out.println("Composé des Uvs suivantes : ");
					for (Long idUv :  dataStore.getIdUvStageDispo((long)1,s.getIdStage())) {
						System.out.println(dataStore.getUv(idUv).getTitle());
					}
				System.out.println("");
				}
			}
		
		System.out.println();
		System.out.println();
		System.out.println("Agent 2 : "+ dataStore.getAgent((long)2).getFirstName() + " " + dataStore.getAgent((long)2).getName() );
		
		for (int i = 0; i < 100; i++ ) {
			if (dataStore.getStage((long)i)!=null){
				StageDTO s = dataStore.getStage((long)i);	
				System.out.print("Nom du Stage : ");
				System.out.println(s.getTitle()+" (à "+s.getLocality()+")");
				System.out.println("Composé des Uvs suivantes : ");
					for (Long idUv :  dataStore.getIdUvStageDispo((long)2,s.getIdStage())) {
						System.out.println(dataStore.getUv(idUv).getTitle());
					}
				System.out.println("");
				}
			}
		
		System.out.println("-------Liste des Stages dirigés par John Doe------------");

		for (Long is : dataStore.getIdStageDir((long)0)) {
			StageDTO s = dataStore.getStage((long)is);	
			System.out.print("Nom du Stage : ");
			System.out.println(s.getTitle()+" (à "+s.getLocality()+")");
			System.out.println("Composé des Uvs suivantes : ");
			for (Long idUv :  dataStore.getIdUvStageDir(s.getIdStage())) {
				System.out.println(dataStore.getUv(idUv).getTitle());
			}
		System.out.println("");
		}
		
		System.out.println("-------Essai d'inscription et Validation------------");
		
		Collection<Long> idsUv0 = new Vector<Long>();
		Collection<Long> idsUv5 = new Vector<Long>();
		Collection<Long> idsUv6 = new Vector<Long>();
		
		idsUv0.add((long)7);
		idsUv5.add((long)7);
		idsUv6.add((long)7);
		idsUv5.add((long)8);
		idsUv6.add((long)8);

		
		dataStore.addInscrip((long)0, idsUv0);
		dataStore.addInscrip((long)5, idsUv5);
		dataStore.addInscrip((long)6, idsUv6);
		
		System.out.println("Liste des candidats inscrit à l'Uv 7");
		for (Long ic : dataStore.getIdCandidat((long)7,EtatCandidatureDTO.inscrit)){
			System.out.println(dataStore.getAgent(ic).getFirstName()+" "+dataStore.getAgent(ic).getName());
		}
			


		System.out.println("----------------Tests rajoutés par Laurent le 12/03/2012-----------------");
		System.out.println();
		
		for (int i = 0; i < 100; i++) {
			if (dataStore.getAgent((long) i) != null) {
				AgentDTO a = dataStore.getAgent((long) i);
				System.out.print("L'agent ");
				System.out.print(a.getFirstName() + " " + a.getName());
				System.out.print(" peut postuler aux stages suivants : \n");
				Collection<Long> ls = dataStore.getIdStageDispo(a.getIdAgent());
				for (Long idS : ls){
					System.out.println("\t - " + dataStore.getStage(idS).getTitle());
				}
				System.out.println("");
			}
		}
		
		System.out.println("----------------Tests de Session-----------------");
		System.out.println();
		
		SessionDTO session = null;
		
		session = dataStore.login("agent","motdepasse");
		
		if (session!=null) {
			AgentDTO a1 = dataStore.getAgent(session.getIdAgent());
			if (a1!=null) {
				System.out.print("L'agent ");
				System.out.print(a1.getFirstName() + " " + a1.getName());
				System.out.println(" est connecté");
			}
			else {System.out.println("L'agent n'existe pas");}
		}
		else {System.out.println("Mauvais login ou mot de passe");}
	}
	
	
}
