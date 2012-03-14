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
		// TODO TESTS
		System.out.println("DataStore Injected = " + dataStore);

		DataStore fDS = dataStore;

		for (int i = 0; i < fDS.nbStages(); i++) {
			StageDTO s = fDS.getStage((long) i);
			System.out.print("Nom du Stage : ");
			System.out.println(s.getTitle() + " (à " + s.getLocality() + ")");
			System.out.println("Composé des Uvs suivantes : ");
			for (Long idUv : s.getListIdUv()) {
				System.out.println(fDS.getUv(idUv).getTitle());
			}
			System.out.println("");
		}

		for (int i = 0; i < fDS.nbUvs(); i++) {
			UvDTO u = fDS.getUv((long) i);
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

		fDS.addUv(uv);

		System.out.println("Id de l'uv : " + uv.getIdUv() + " ");
		System.out.println("taille de la map : " + fDS.nbUvs() + " ");


		for (int i = 0; i < 100; i++ ) {
			if (fDS.getUv((long)i)!=null){
			  UvDTO u = fDS.getUv((long)i);
		      System.out.print("Nom de l'UV (id : "+i+") : ");
			  System.out.println(u.getTitle()+" (à "+u.getLocality()+")");
			  System.out.println("");
			}
		}
		
		System.out.println("-------Verification dans chaque Stage des UVs dispo pour chaque Agent------------");
		System.out.println();
		System.out.println();
		System.out.println("Agent 0 : "+ fDS.getAgent((long)0).getFirstName() + " " + fDS.getAgent((long)0).getName() );
		for (int i = 0; i < 100; i++ ) {
			if (fDS.getStage((long)i)!=null){
				StageDTO s = fDS.getStage((long)i);	
				System.out.print("Nom du Stage : ");
				System.out.println(s.getTitle()+" (à "+s.getLocality()+")");
				System.out.println("Composé des Uvs suivantes : ");
					for (Long idUv :  fDS.getIdUvStageDispo((long)0,s.getIdStage())) {
						System.out.println(fDS.getUv(idUv).getTitle());
					}
				System.out.println("");
				}
			}
		
		System.out.println();
		System.out.println();
		System.out.println("Agent 1 : "+ fDS.getAgent((long)1).getFirstName() + " " + fDS.getAgent((long)1).getName() );

		for (int i = 0; i < 100; i++ ) {
			if (fDS.getStage((long)i)!=null){
				StageDTO s = fDS.getStage((long)i);	
				System.out.print("Nom du Stage : ");
				System.out.println(s.getTitle()+" (à "+s.getLocality()+")");
				System.out.println("Composé des Uvs suivantes : ");
					for (Long idUv :  fDS.getIdUvStageDispo((long)1,s.getIdStage())) {
						System.out.println(fDS.getUv(idUv).getTitle());
					}
				System.out.println("");
				}
			}
		
		System.out.println();
		System.out.println();
		System.out.println("Agent 2 : "+ fDS.getAgent((long)2).getFirstName() + " " + fDS.getAgent((long)2).getName() );
		
		for (int i = 0; i < 100; i++ ) {
			if (fDS.getStage((long)i)!=null){
				StageDTO s = fDS.getStage((long)i);	
				System.out.print("Nom du Stage : ");
				System.out.println(s.getTitle()+" (à "+s.getLocality()+")");
				System.out.println("Composé des Uvs suivantes : ");
					for (Long idUv :  fDS.getIdUvStageDispo((long)2,s.getIdStage())) {
						System.out.println(fDS.getUv(idUv).getTitle());
					}
				System.out.println("");
				}
			}
		
		System.out.println("-------Liste des Stages dirigés par John Doe------------");

		for (Long is : fDS.getIdStageDir((long)0)) {
			StageDTO s = fDS.getStage((long)is);	
			System.out.print("Nom du Stage : ");
			System.out.println(s.getTitle()+" (à "+s.getLocality()+")");
			System.out.println("Composé des Uvs suivantes : ");
			for (Long idUv :  fDS.getIdUvStageDir(s.getIdStage())) {
				System.out.println(fDS.getUv(idUv).getTitle());
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

		
		fDS.addInscrip((long)0, idsUv0);
		fDS.addInscrip((long)1, idsUv1);
		fDS.addInscrip((long)2, idsUv2);
		
		System.out.println("Liste des candidats inscrit à l'Uv 6");
		for (Long ic : fDS.getIdCandidat((long)6,EtatCandidatureDTO.inscrit)){
			System.out.println(fDS.getAgent(ic).getFirstName()+" "+fDS.getAgent(ic).getName());
		}
			
		
		System.out.println("-------Tri des candidats------------");

		
		fDS.setStatut((long)6, (long)0 , EtatCandidatureDTO.retenu, EtatCandidatureDTO.inscrit);
		fDS.setStatut((long)6, (long)1 , EtatCandidatureDTO.nonRetenu, EtatCandidatureDTO.inscrit);
		fDS.setStatut((long)6, (long)2 , EtatCandidatureDTO.listeAttente, EtatCandidatureDTO.inscrit);
		

		System.out.println("Liste des candidats selon leur statut");
		System.out.print("Inscrits :");
		for (Long ic : fDS.getIdCandidat((long)6,EtatCandidatureDTO.inscrit)){
			System.out.print(" - ");
			System.out.print(fDS.getAgent(ic).getFirstName()+" "+fDS.getAgent(ic).getName());
		}
		System.out.println();
		System.out.print("Retenus :");
		for (Long ic : fDS.getIdCandidat((long)6,EtatCandidatureDTO.retenu)){
			System.out.print(" - ");
			System.out.print(fDS.getAgent(ic).getFirstName()+" "+fDS.getAgent(ic).getName());
		}
		System.out.println();

		System.out.print("Liste d'attente :");
		for (Long ic : fDS.getIdCandidat((long)6,EtatCandidatureDTO.listeAttente)){
			System.out.print(" - ");
			System.out.print(fDS.getAgent(ic).getFirstName()+" "+fDS.getAgent(ic).getName());
		}
		System.out.println();

		System.out.print("Non retenus :");
		for (Long ic : fDS.getIdCandidat((long)6,EtatCandidatureDTO.nonRetenu)){
			System.out.print(" - ");
			System.out.print(fDS.getAgent(ic).getFirstName()+" "+fDS.getAgent(ic).getName());
		}
		System.out.println();
		
		
		fDS.setStatut((long)6, (long)2 , EtatCandidatureDTO.retenu, EtatCandidatureDTO.listeAttente);
		
		System.out.println("Liste des candidats selon leur statut");
		System.out.print("Inscrits :");
		for (Long ic : fDS.getIdCandidat((long)6,EtatCandidatureDTO.inscrit)){
			System.out.print(" - ");
			System.out.print(fDS.getAgent(ic).getFirstName()+" "+fDS.getAgent(ic).getName());
		}
		System.out.println();
		System.out.print("Retenus :");
		for (Long ic : fDS.getIdCandidat((long)6,EtatCandidatureDTO.retenu)){
			System.out.print(" - ");
			System.out.print(fDS.getAgent(ic).getFirstName()+" "+fDS.getAgent(ic).getName());
		}
		
		System.out.println();
		System.out.print("Liste d'attente :");
		for (Long ic : fDS.getIdCandidat((long)6,EtatCandidatureDTO.listeAttente)){
			System.out.print(" - ");
			System.out.print(fDS.getAgent(ic).getFirstName()+" "+fDS.getAgent(ic).getName());
		}
		
		System.out.println();
		System.out.print("Non retenus :");
		for (Long ic : fDS.getIdCandidat((long)6,EtatCandidatureDTO.nonRetenu)){
			System.out.print(" - ");
			System.out.print(fDS.getAgent(ic).getFirstName()+" "+fDS.getAgent(ic).getName());
		}
		System.out.println();
		System.out.println();
		System.out.println();
		
		/**
		 * Rajout de tests par JCG 12/03/2012
		 */
				
		System.out.println("--------------------Tests rajoutés par JCG le 12/03/2012--------------------");
		System.out.println();
		System.out.println("-----------Liste des stages auxquels sont inscrits les candidats------------");

		for (int i = 0; i < 10; ++i) {
			fDS.setStatut((long) i, (long) 0, EtatCandidatureDTO.retenu, EtatCandidatureDTO.inscrit);
			fDS.setStatut((long) i, (long) 1, EtatCandidatureDTO.retenu, EtatCandidatureDTO.inscrit);
			fDS.setStatut((long) i, (long) 2, EtatCandidatureDTO.listeAttente, EtatCandidatureDTO.inscrit);
		}

		for (int i = 0; i < 100; i++) {
			if (fDS.getAgent((long) i) != null) {
				AgentDTO a = fDS.getAgent((long) i);
				System.out.print("L'agent ");
				System.out.print(a.getFirstName() + " " + a.getName());
				System.out.print(" est inscrit aux stages suivants : \n");
				for (Long idStage : fDS.getIdStageInscrit(a.getIdAgent())) {
					System.out.println("\t - " + fDS.getStage(idStage).getTitle());
				}
				System.out.println("");
			}
		}

		System.out.println("-----------Liste des UVs auxquelles sont inscrits les candidats------------");

		for (int i = 0; i < 100; i++) {
			if (fDS.getAgent((long) i) != null) {
				AgentDTO a = fDS.getAgent((long) i);
				System.out.print("L'agent ");
				System.out.print(a.getFirstName() + " " + a.getName());
				System.out.print(" est inscrit aux UVs suivantes : \n");
				for (int h = 0; h < 10; ++h) {
					for (Long idUv : fDS.getIdUvStageInscrit(a.getIdAgent(), (long) h)) {
						System.out.println("\t - " + fDS.getUv(idUv).getTitle());
					}
				}
				System.out.println("");
			}
		}

		
		

		System.out.println("-----------Liste des stages auxquels sont inscrits les candidats------------");
		System.out.println("--------------------------après quelques annulations------------------------");

		fDS.setStatut((long) 5, (long) 0, EtatCandidatureDTO.annulé, EtatCandidatureDTO.retenu);
		fDS.setStatut((long) 9, (long) 2, EtatCandidatureDTO.annulé, EtatCandidatureDTO.listeAttente);		
		
		for (int i = 0; i < 100; i++) {
			if (fDS.getAgent((long) i) != null) {
				AgentDTO a = fDS.getAgent((long) i);
				System.out.print("L'agent ");
				System.out.print(a.getFirstName() + " " + a.getName());
				System.out.print(" est inscrit aux stages suivants : \n");
				for (Long idStage : fDS.getIdStageInscrit(a.getIdAgent())) {
					System.out.println("\t - " + fDS.getStage(idStage).getTitle());
				}
				System.out.println("");
			}
		}

		System.out.println("-------------Liste des UVs auxquelles sont inscrits les candidats------------");
		System.out.println("--------------------------après quelques annulations-------------------------");

		for (int i = 0; i < 100; i++) {
			if (fDS.getAgent((long) i) != null) {
				AgentDTO a = fDS.getAgent((long) i);
				System.out.print("L'agent ");
				System.out.print(a.getFirstName() + " " + a.getName());
				System.out.print(" est inscrit aux UVs suivantes : \n");
				for (int h = 0; h < 10; ++h) {
					for (Long idUv : fDS.getIdUvStageInscrit(a.getIdAgent(),(long) h)) {
						System.out.println("\t - " + fDS.getUv(idUv).getTitle());
					}
				}
				System.out.println("");
			}
		}

		System.out.println("----------------Fin des Tests rajoutés par JCG le 12/03/2012-----------------");
		System.out.println();

		System.out.println("----------------Tests rajoutés par Laurent le 12/03/2012-----------------");
		System.out.println();
		
		for (int i = 0; i < 100; i++) {
			if (fDS.getAgent((long) i) != null) {
				AgentDTO a = fDS.getAgent((long) i);
				System.out.print("L'agent ");
				System.out.print(a.getFirstName() + " " + a.getName());
				System.out.print(" peut postuler aux stages suivants : \n");
				Collection<Long> ls = fDS.getIdStageDispo(a.getIdAgent());
				for (Long idS : ls){
					System.out.println("\t - " + fDS.getStage(idS).getTitle());
				}
				System.out.println("");
			}
		}
		
		System.out.println("----------------Tests de Session-----------------");
		System.out.println();
		
		SessionDTO session = null;
		
		session = fDS.login("agent","motdepasse");
		
		if (session!=null) {
			AgentDTO a1 = fDS.getAgent(session.getIdAgent());
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
