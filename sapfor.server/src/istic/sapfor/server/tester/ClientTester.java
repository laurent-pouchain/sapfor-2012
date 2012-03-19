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
			System.out.println(s.getTitle() + " (� " + s.getLocality() + ")");
			System.out.println("Compos� des Uvs suivantes : ");
			for (Long idUv : s.getListIdUv()) {
				System.out.println(dataStore.getUv(idUv).getTitle());
			}
			System.out.println("");
		}

		for (int i = 0; i < dataStore.nbUvs(); i++) {
			UvDTO u = dataStore.getUv((long) i);
			System.out.print("Nom de l'UV : ");
			System.out.println(u.getTitle() + " (� " + u.getLocality() + ")");
			System.out.println("");
		}

		System.out.println("-------Ajout d'une UV------------");

		UvDTO uv = new UvDTO();

		uv.setIdTypeUv(1);
		uv.setTitle("Basics-Essai-Entr�e");
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
			  System.out.println(u.getTitle()+" (� "+u.getLocality()+")");
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
				System.out.println(s.getTitle()+" (� "+s.getLocality()+")");
				System.out.println("Compos� des Uvs suivantes : ");
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
				System.out.println(s.getTitle()+" (� "+s.getLocality()+")");
				System.out.println("Compos� des Uvs suivantes : ");
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
				System.out.println(s.getTitle()+" (� "+s.getLocality()+")");
				System.out.println("Compos� des Uvs suivantes : ");
					for (Long idUv :  dataStore.getIdUvStageDispo((long)2,s.getIdStage())) {
						System.out.println(dataStore.getUv(idUv).getTitle());
					}
				System.out.println("");
				}
			}
		
		System.out.println("-------Liste des Stages dirig�s par John Doe------------");

		for (Long is : dataStore.getIdStageDir((long)0)) {
			StageDTO s = dataStore.getStage((long)is);	
			System.out.print("Nom du Stage : ");
			System.out.println(s.getTitle()+" (� "+s.getLocality()+")");
			System.out.println("Compos� des Uvs suivantes : ");
			for (Long idUv :  dataStore.getIdUvStageDir(s.getIdStage())) {
				System.out.println(dataStore.getUv(idUv).getTitle());
			}
		System.out.println("");
		}
		
		System.out.println("-------Essai d'inscription et Validation------------");
		
		Collection<Long> idsUv0 = new Vector<Long>();
		Collection<Long> idsUv1 = new Vector<Long>();
		Collection<Long> idsUv2 = new Vector<Long>();
		
		idsUv0.add((long)6);
		idsUv1.add((long)6);
		idsUv2.add((long)6);

		
		dataStore.addInscrip((long)0, idsUv0);
		dataStore.addInscrip((long)1, idsUv1);
		dataStore.addInscrip((long)2, idsUv2);
		
		System.out.println("Liste des candidats inscrit � l'Uv 6");
		for (Long ic : dataStore.getIdCandidat((long)6,EtatCandidatureDTO.inscrit)){
			System.out.println(dataStore.getAgent(ic).getFirstName()+" "+dataStore.getAgent(ic).getName());
		}
			
		
		System.out.println("-------Tri des candidats------------");

		
		dataStore.setStatut((long)6, (long)0 , EtatCandidatureDTO.retenu, EtatCandidatureDTO.inscrit);
		dataStore.setStatut((long)6, (long)1 , EtatCandidatureDTO.nonRetenu, EtatCandidatureDTO.inscrit);
		dataStore.setStatut((long)6, (long)2 , EtatCandidatureDTO.listeAttente, EtatCandidatureDTO.inscrit);
		

		System.out.println("Liste des candidats selon leur statut");
		System.out.print("Inscrits :");
		for (Long ic : dataStore.getIdCandidat((long)6,EtatCandidatureDTO.inscrit)){
			System.out.print(" - ");
			System.out.print(dataStore.getAgent(ic).getFirstName()+" "+dataStore.getAgent(ic).getName());
		}
		System.out.println();
		System.out.print("Retenus :");
		for (Long ic : dataStore.getIdCandidat((long)6,EtatCandidatureDTO.retenu)){
			System.out.print(" - ");
			System.out.print(dataStore.getAgent(ic).getFirstName()+" "+dataStore.getAgent(ic).getName());
		}
		System.out.println();

		System.out.print("Liste d'attente :");
		for (Long ic : dataStore.getIdCandidat((long)6,EtatCandidatureDTO.listeAttente)){
			System.out.print(" - ");
			System.out.print(dataStore.getAgent(ic).getFirstName()+" "+dataStore.getAgent(ic).getName());
		}
		System.out.println();

		System.out.print("Non retenus :");
		for (Long ic : dataStore.getIdCandidat((long)6,EtatCandidatureDTO.nonRetenu)){
			System.out.print(" - ");
			System.out.print(dataStore.getAgent(ic).getFirstName()+" "+dataStore.getAgent(ic).getName());
		}
		System.out.println();
		
		
		dataStore.setStatut((long)6, (long)2 , EtatCandidatureDTO.retenu, EtatCandidatureDTO.listeAttente);
		
		System.out.println("Liste des candidats selon leur statut");
		System.out.print("Inscrits :");
		for (Long ic : dataStore.getIdCandidat((long)6,EtatCandidatureDTO.inscrit)){
			System.out.print(" - ");
			System.out.print(dataStore.getAgent(ic).getFirstName()+" "+dataStore.getAgent(ic).getName());
		}
		System.out.println();
		System.out.print("Retenus :");
		for (Long ic : dataStore.getIdCandidat((long)6,EtatCandidatureDTO.retenu)){
			System.out.print(" - ");
			System.out.print(dataStore.getAgent(ic).getFirstName()+" "+dataStore.getAgent(ic).getName());
		}
		
		System.out.println();
		System.out.print("Liste d'attente :");
		for (Long ic : dataStore.getIdCandidat((long)6,EtatCandidatureDTO.listeAttente)){
			System.out.print(" - ");
			System.out.print(dataStore.getAgent(ic).getFirstName()+" "+dataStore.getAgent(ic).getName());
		}
		
		System.out.println();
		System.out.print("Non retenus :");
		for (Long ic : dataStore.getIdCandidat((long)6,EtatCandidatureDTO.nonRetenu)){
			System.out.print(" - ");
			System.out.print(dataStore.getAgent(ic).getFirstName()+" "+dataStore.getAgent(ic).getName());
		}
		System.out.println();
		System.out.println();
		System.out.println();
		
		/**
		 * Rajout de tests par JCG 12/03/2012
		 */
				
		System.out.println("--------------------Tests rajout�s par JCG le 12/03/2012--------------------");
		System.out.println();
		System.out.println("-----------Liste des stages auxquels sont inscrits les candidats------------");

		for (int i = 0; i < 10; ++i) {
			dataStore.setStatut((long) i, (long) 0, EtatCandidatureDTO.retenu, EtatCandidatureDTO.inscrit);
			dataStore.setStatut((long) i, (long) 1, EtatCandidatureDTO.retenu, EtatCandidatureDTO.inscrit);
			dataStore.setStatut((long) i, (long) 2, EtatCandidatureDTO.listeAttente, EtatCandidatureDTO.inscrit);
		}

		for (int i = 0; i < 100; i++) {
			if (dataStore.getAgent((long) i) != null) {
				AgentDTO a = dataStore.getAgent((long) i);
				System.out.print("L'agent ");
				System.out.print(a.getFirstName() + " " + a.getName());
				System.out.print(" est inscrit aux stages suivants : \n");
				for (Long idStage : dataStore.getIdStageInscrit(a.getIdAgent())) {
					System.out.println("\t - " + dataStore.getStage(idStage).getTitle());
				}
				System.out.println("");
			}
		}

		System.out.println("-----------Liste des UVs auxquelles sont inscrits les candidats------------");

		for (int i = 0; i < 100; i++) {
			if (dataStore.getAgent((long) i) != null) {
				AgentDTO a = dataStore.getAgent((long) i);
				System.out.print("L'agent ");
				System.out.print(a.getFirstName() + " " + a.getName());
				System.out.print(" est inscrit aux UVs suivantes : \n");
				for (int h = 0; h < dataStore.nbStages(); ++h) {
					for (Long idUv : dataStore.getIdUvStageInscrit(a.getIdAgent(), (long) h)) {
						System.out.println("\t - " + dataStore.getUv(idUv).getTitle());
					}
				}
				System.out.println("");
			}
		}

		
		

		System.out.println("-----------Liste des stages auxquels sont inscrits les candidats------------");
		System.out.println("--------------------------apr�s quelques annulations------------------------");

		dataStore.setStatut((long) 5, (long) 0, EtatCandidatureDTO.annule, EtatCandidatureDTO.retenu);
		dataStore.setStatut((long) 9, (long) 2, EtatCandidatureDTO.annule, EtatCandidatureDTO.listeAttente);		
		
		for (int i = 0; i < 100; i++) {
			if (dataStore.getAgent((long) i) != null) {
				AgentDTO a = dataStore.getAgent((long) i);
				System.out.print("L'agent ");
				System.out.print(a.getFirstName() + " " + a.getName());
				System.out.print(" est inscrit aux stages suivants : \n");
				for (Long idStage : dataStore.getIdStageInscrit(a.getIdAgent())) {
					System.out.println("\t - " + dataStore.getStage(idStage).getTitle());
				}
				System.out.println("");
			}
		}

		System.out.println("-------------Liste des UVs auxquelles sont inscrits les candidats------------");
		System.out.println("--------------------------apr�s quelques annulations-------------------------");

		for (int i = 0; i < 100; i++) {
			if (dataStore.getAgent((long) i) != null) {
				AgentDTO a = dataStore.getAgent((long) i);
				System.out.print("L'agent ");
				System.out.print(a.getFirstName() + " " + a.getName());
				System.out.print(" est inscrit aux UVs suivantes : \n");
				for (int h = 0; h < dataStore.nbStages(); ++h) {
					for (Long idUv : dataStore.getIdUvStageInscrit(a.getIdAgent(),(long) h)) {
						System.out.println("\t - " + dataStore.getUv(idUv).getTitle());
					}
				}
				System.out.println("");
			}
		}

		System.out.println("----------------Fin des Tests rajout�s par JCG le 12/03/2012-----------------");
		System.out.println();

		System.out.println("----------------Tests rajout�s par Laurent le 12/03/2012-----------------");
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
				System.out.println(" est connect�");
			}
			else {System.out.println("L'agent n'existe pas");}
		}
		else {System.out.println("Mauvais login ou mot de passe");}
	}
	
	
}
