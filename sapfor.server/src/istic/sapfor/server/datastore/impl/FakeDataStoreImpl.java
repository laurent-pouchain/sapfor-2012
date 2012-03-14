package istic.sapfor.server.datastore.impl;

import istic.sapfor.api.dto.*;
import istic.sapfor.server.datastore.DataStore;

import java.io.*;

import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Vector;

import org.apache.log4j.Logger;

public class FakeDataStoreImpl implements DataStore {

	Logger logger = Logger.getLogger(this.getClass());
	
	public FakeDataStoreImpl(){

		System.out.println("Build data store ...");
		remplir();
		System.out.println("Data store fully build");
		remplir_fichier("fakedata.txt");
	
	}
	
	private Map<Long,String> sessionsMap = new HashMap<Long,String>();
	private Map<Long,AgentDTO> agentsMap = new HashMap<Long,AgentDTO>();
	private Map<Long,UvDTO> uvMap = new HashMap<Long,UvDTO>();
	private Map<Long,StageDTO> stageMap = new HashMap<Long,StageDTO>();
	private Map<Long,TypeUvDTO> typeUvMap = new HashMap<Long,TypeUvDTO>();
	
	
	// modif JCG 09/03/2012
	/* 
	 * Map qui relie un Agent directeur avec les stages dont il a la gestion
	 */
	private Map<Long,Collection<Long>> stagesDirMap = new HashMap<Long,Collection<Long>>();	

	private Map<Long,Collection<Long>> inscritMap = new HashMap<Long,Collection<Long>>();
	private Map<Long,Collection<Long>> retenuMap = new HashMap<Long,Collection<Long>>();
	private Map<Long,Collection<Long>> listeAttenteMap = new HashMap<Long,Collection<Long>>();
	private Map<Long,Collection<Long>> nonRetenuMap = new HashMap<Long,Collection<Long>>();
	private Map<Long,Collection<Long>> annuleMap = new HashMap<Long,Collection<Long>>();

	
	private long keyUv = 0;
	private long keyAgent = 0;
	private long keyTypeUv = 0;
	private long keyStage = 0;

	
	public AgentDTO getAgent(Long id) {
		if(this.agentsMap.containsKey(id)){
			return this.agentsMap.get(id);
		}
		return null;
	}
	
	public SessionDTO login(String user, String password) {
		if(this.sessionsMap.containsKey((long)user.hashCode())){
			if (this.sessionsMap.get((long)user.hashCode()).equals(password)){
				SessionDTO mySession = new SessionDTO();
				for (AgentDTO a : agentsMap.values() ){
				   if (a.getLogin().equals(user)){
					  mySession.setIdAgent(a.getIdAgent());
					  return mySession;
				   }
				}
			}
		}
		return null;
	}


	
	public UvDTO getUv(Long id) {
		if(this.uvMap.containsKey(id)){
			return this.uvMap.get(id);
		}
		return null;
	}
	
	//ou içi
	public StageDTO getStage(Long id) {
		if(this.stageMap.containsKey(id)){
			return this.stageMap.get(id);
		}
		return null;
	}

	@Override
	public TypeUvDTO getTypeUv(Long id) {
		if(this.typeUvMap.containsKey(id)){
			return this.typeUvMap.get(id);
		}
		return null;
	}

	@SuppressWarnings("deprecation")
	private void remplir() {
	
		
		Collection<Long> uvStage0 = new Vector<Long>();
		Collection<Long> uvStage1 = new Vector<Long>();
		Collection<Long> uvStage2 = new Vector<Long>();
		Collection<Long> uvStage3 = new Vector<Long>();
		Collection<Long> uvStage4 = new Vector<Long>();
		Collection<Long> uvStage5 = new Vector<Long>();
		Collection<Long> uvStage6 = new Vector<Long>();
		Collection<Long> uvStage7 = new Vector<Long>();
		Collection<Long> uvStage8 = new Vector<Long>();
		Collection<Long> uvStage9 = new Vector<Long>();
		
		uvStage0.add((long)0);
		uvStage1.add((long)1);
		uvStage2.add((long)2);
		uvStage3.add((long)3);
		uvStage3.add((long)4);
		uvStage4.add((long)5);
		uvStage5.add((long)6);
		uvStage6.add((long)7);
		uvStage6.add((long)8);
		uvStage7.add((long)9);
		uvStage8.add((long)10);
		uvStage9.add((long)11);
		
		addStage(uvStage0,"Stage de Base 1","Monfort");
		addStage(uvStage1,"Feux de Forêt 1","Fougères");
		addStage(uvStage2,"Feux de Forêt 1 + accidents","Fougères");
		addStage(uvStage3,"Base et Feux de Forêt 1","Rennes");
		addStage(uvStage4,"Stage de Base 2","Monfort");		
		addStage(uvStage5,"Premiers Secours 1","Rennes");
		addStage(uvStage6,"Base et Premiers Secours 1","Fougères");
		addStage(uvStage7,"Feux de Forêt 2","Rennes");
		addStage(uvStage8,"Feux de Forêt 2 + accidents","Monfort");
		addStage(uvStage9,"Premiers Secours 2","Monfort");
		
		Collection<Long> typesUvPre0 = new Vector<Long>();
		Collection<Long> typesUvPre1 = new Vector<Long>();
		Collection<Long> typesUvPre2 = new Vector<Long>();
		Collection<Long> typesUvPre3 = new Vector<Long>();
		Collection<Long> typesUvPre4 = new Vector<Long>();
		
		typesUvPre1.add((long)0);
		typesUvPre2.add((long)0);
		typesUvPre2.add((long)1);
		typesUvPre3.add((long)0);
		typesUvPre4.add((long)0);
		typesUvPre4.add((long)3);
		
		addTypeUv("Stage de Base", typesUvPre0);
		addTypeUv("Sap-FF1", typesUvPre1);
		addTypeUv("Sap-FF2", typesUvPre2);
		addTypeUv("Sap-PS1", typesUvPre3);
		addTypeUv("Sap-PS2", typesUvPre4);		
		
		addDirector((long)0,(long)0);
		addDirector((long)0,(long)1);
		addDirector((long)0,(long)2);
		addDirector((long)0,(long)3);
		addDirector((long)0,(long)4);
		addDirector((long)0,(long)5);
		addDirector((long)0,(long)6);
		addDirector((long)0,(long)7);
		addDirector((long)0,(long)8);
		addDirector((long)0,(long)9);
		
	}
	
	public void addDirector(long idAgent, long idStage) {
		if(!this.stagesDirMap.containsKey(idAgent)){
			stagesDirMap.put(idAgent, new Vector<Long>());
		}
		stagesDirMap.get(idAgent).add(idStage);
	}

	private void addAgent(String login,int idType, Collection<Long> idOwned, String name, String firstname) {
		AgentDTO agent = new AgentDTO();
		
		agent.setLogin(login);
		agent.setIdAgent(keyAgent);
		agent.setIdTypeAgent(idType);
		agent.setListIdUvOwned(idOwned);
		agent.setName(name);
		agent.setFirstName(firstname);
		sessionsMap.put((long)agent.getLogin().hashCode(),"motdepasse");
		
		agentsMap.put(agent.getIdAgent(),agent);
		
		keyAgent++;
		
	}
	
	private void addUv(int idType, String title, String locality, Collection<Date> dates, Date dateLim ) {
		UvDTO uv = new UvDTO();
		
		uv.setIdUv(keyUv);
		uv.setIdTypeUv(idType);
		uv.setTitle(title);
		uv.setLocality(locality);
		uv.setDates(dates);
		uv.setDateLimite(dateLim);
		
		inscritMap.put(keyUv, new Vector<Long>());
		retenuMap.put(keyUv, new Vector<Long>());
		nonRetenuMap.put(keyUv, new Vector<Long>());
		listeAttenteMap.put(keyUv, new Vector<Long>());
		annuleMap.put(keyUv, new Vector<Long>());
		
		uvMap.put(uv.getIdUv(), uv);
		
		keyUv++;
    }
	
	private void addStage(Collection<Long> idUv, String title, String locality) {
		StageDTO stage = new StageDTO();
		
		stage.setIdStage(keyStage);
		stage.setTitle(title);
		stage.setLocality(locality);
		stage.setListIdUv(idUv);
		
		stageMap.put(stage.getIdStage(), stage);
		
		keyStage++;
	}
	
	private void addTypeUv(String title, Collection<Long> typesUvPre) {
		TypeUvDTO typeUv = new TypeUvDTO();
		
		typeUv.setIdTypeUv(keyTypeUv);
		typeUv.setTitle(title);
		typeUv.setListIdUvPrereq(typesUvPre);
		typeUv.setEffectifMax(20);
		typeUv.setEffectifMin(0);
		
		typeUvMap.put(typeUv.getIdTypeUv(), typeUv);
		
		keyTypeUv++;
	}
	
	public boolean addUv(UvDTO uv){
		uv.setIdUv(keyUv);
		uvMap.put(keyUv,uv);
		inscritMap.put(keyUv, new Vector<Long>());
		retenuMap.put(keyUv, new Vector<Long>());
		nonRetenuMap.put(keyUv, new Vector<Long>());
		listeAttenteMap.put(keyUv, new Vector<Long>());
		annuleMap.put(keyUv, new Vector<Long>());
		keyUv++;
		return true;
	}

	@Override
	public boolean addAgent(AgentDTO agent) {
		agent.setIdAgent(keyAgent);
		agentsMap.put(keyAgent,agent);
		sessionsMap.put((long)agent.getLogin().hashCode(),"motdepasse");
		keyAgent++;
		return true;
	}

	@Override
	public boolean addTypeUv(TypeUvDTO typeUv) {
		typeUv.setIdTypeUv(keyTypeUv);
		typeUvMap.put(keyTypeUv,typeUv);
		keyTypeUv++;
		return true;
	}

	@Override
	public boolean addStage(StageDTO stage) {
		stage.setIdStage(keyStage);
		stageMap.put(keyStage,stage);
		keyStage++;
		return true;
	}

	@Override
	public int nbUvs() {
		return uvMap.size();
	}

	@Override
	public int nbAgents() {
		return agentsMap.size();
	}

	@Override
	public int nbTypeUvs() {
		return typeUvMap.size();
	}

	@Override
	public int nbStages() {
		return stageMap.size();
	}

	@Override
	public boolean delUv(long id) {
		uvMap.remove(id);
		return true;
	}

	@Override
	public boolean delAgent(long id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delTypeUv(long id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delStage(long id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Collection<Long> getIdCandidat(Long idUv, EtatCandidatureDTO etat) {
		Collection<Long> listIdCandidat = null;
		switch (etat) {
	    case inscrit : listIdCandidat=inscritMap.get(idUv); break;
	    case retenu : listIdCandidat=retenuMap.get(idUv); break;
	    case nonRetenu : listIdCandidat=nonRetenuMap.get(idUv); break;
	    case listeAttente : listIdCandidat=listeAttenteMap.get(idUv); break;
	    default : break;
	}
		return listIdCandidat;
	}

	@Override
	public boolean setStatut(Long idUv, Long idCandidat,
			EtatCandidatureDTO nouvelEtat, EtatCandidatureDTO ancienEtat) {
		
		
		switch (ancienEtat) {
		    case inscrit : inscritMap.get(idUv).remove(idCandidat); break;
		    case retenu : retenuMap.get(idUv).remove(idCandidat); break;
		    case nonRetenu : nonRetenuMap.get(idUv).remove(idCandidat); break;
		    case listeAttente : listeAttenteMap.get(idUv).remove(idCandidat); break;
		    default : return false;
		}
		switch (nouvelEtat) {
	        case inscrit : inscritMap.get(idUv).add(idCandidat); break;
	        case retenu : retenuMap.get(idUv).add(idCandidat); break;
	        case nonRetenu : nonRetenuMap.get(idUv).add(idCandidat); break;
	        case listeAttente : listeAttenteMap.get(idUv).add(idCandidat); break;
	        default : return false;
		}
		return true;
	}

	@Override
	public boolean addInscrip(Long idAgent, Collection<Long> idsUv) {
		for (Long idUv : idsUv){
		inscritMap.get(idUv).add(idAgent);
		}
		return true;
	}
	
	
	// modif JCG 09/03/2012
	/* 
	 * Methode qui renvoie la liste des stages diriges par un Agent directeur
	 */
	public Collection<Long> getIdStageDir(Long idAgent){
		if(this.stagesDirMap.containsKey(idAgent)){
			return stagesDirMap.get(idAgent);
		}
		return null;
	}
	/* 
	 * Methode qui renvoie la liste des UVs contenues dans un Stage
	 */
	public Collection<Long> getIdUvStageDir(Long idStage){
		if(this.stageMap.containsKey(idStage)){
			return this.stageMap.get(idStage).getListIdUv();
		}
		return null;		
	}
	/* 
	 * Methode qui renvoie la liste des UVs possibles pour un agent et pour un stage donne
	 */	
	public Collection<Long> getIdUvStageDispo(Long idAgent, Long idStage) {
		Collection<Long> listeUvPossible = new Vector<Long>();
		Collection<Long> listeUvDispo; // UVs du stage
		Collection<Long> listeUvOwned; // UVs de l'Agent
		Collection<Long> listeTypeUvOwned = new Vector<Long>(); // types des UVs owned
		Collection<Long> listeTypeUvPrereq; // types des UVs prerequises
		listeUvDispo = this.stageMap.get(idStage).getListIdUv(); 
		listeUvOwned = this.agentsMap.get(idAgent).getListIdUvOwned();
		for (Long idUvOwned : listeUvOwned) {
			listeTypeUvOwned.add(this.getUv(idUvOwned).getIdTypeUv());
		}
		for (Long idUv : listeUvDispo) {
			listeTypeUvPrereq = this.typeUvMap.get(uvMap.get(idUv).getIdTypeUv()).getListIdUvPrereq();
			if (listeTypeUvOwned.containsAll(listeTypeUvPrereq) & !listeTypeUvOwned.contains(uvMap.get(idUv).getIdTypeUv())) {
				listeUvPossible.add(idUv);
			}
		}
		return listeUvPossible;
	}

	// modif KD 12/03/2012
	/* 



	 * Methode qui renvoie la liste des stages possibles pour un agent donne
	 */
	public Collection<Long> getIdStageDispo(Long idAgent){
		Collection<Long> listIdStageDispo = new Vector<Long>(); // stages possibles
		// TODO tester si keySet supporte la Collection, sinon passer en Set<Long>
		Collection<Long> listIdStages; // stages crees
		listIdStages = this.stageMap.keySet();
		for (Long idStage : listIdStages){
			if (!this.getIdUvStageDispo(idAgent, idStage).isEmpty()){ // si ce stage a au moins 1 UV possible pour cet agent
				listIdStageDispo.add(idStage); // ajouter ce stage a la liste des stages possibles
			}
			
		}
		return listIdStageDispo;
	}

	
	/** 
	 * Methode qui renvoie la liste des stages auxquelles est inscrit un agent 
	 */	
	public Collection<Long> getIdStageInscrit(Long idAgent) {
		Collection<Long> listeStageInscrit = new Vector<Long>();

		for (StageDTO stage : this.stageMap.values()) {
			if (!this.getIdUvStageInscrit(idAgent, stage.getIdStage()).isEmpty()) {
				if (!listeStageInscrit.contains(stage.getIdStage())) {
					listeStageInscrit.add(stage.getIdStage());
				}
			}	
		}
		return listeStageInscrit;
	}
	
	/** 
	 * Methode qui renvoie la liste des UVs auxquelles est inscrit un agent et pour un stage donne
	 * L'etat de la candidature peut etre : inscrit, retenu, non retenu ou liste d'attente
	 */	
	public Collection<Long> getIdUvStageInscrit(Long idAgent, Long idStage) {
		Collection<Long> listeUvInscrit = new Vector<Long>();
		Collection<Long> listeUvPossible;
		listeUvPossible = getIdUvStageDispo(idAgent, idStage);

		for (Long idUv : listeUvPossible) {
			if (this.inscritMap.containsKey(idUv)) {
				if (this.inscritMap.get(idUv).contains(idAgent)){
					listeUvInscrit.add(idUv);
				}
			}
		}
		
		for (Long idUv : listeUvPossible) {
			if (this.retenuMap.containsKey(idUv)) {
				if (this.retenuMap.get(idUv).contains(idAgent)){
					listeUvInscrit.add(idUv);
				}
			}
		}
		
		for (Long idUv : listeUvPossible) {
			if (this.listeAttenteMap.containsKey(idUv)) {
				if (this.listeAttenteMap.get(idUv).contains(idAgent)){
					listeUvInscrit.add(idUv);
				}
			}
		}
		
		return listeUvInscrit;
	}
	
	@SuppressWarnings("deprecation")
	private void remplir_fichier(String f) {
		try {
			InputStream ips = new FileInputStream(f);			
			InputStreamReader ipsr=new InputStreamReader(ips);
			BufferedReader br=new BufferedReader(ipsr);
			String ligne;
			while ((ligne=br.readLine())!=null){
				String nb_ch = "";
				int pt = 0;
				switch (ligne.charAt(0)){
				case 'A' : 
					pt = 2;
					String login ="";
					String name ="";
					String firstName ="";
					Collection<Long> idsUv = new Vector<Long>();
					Integer idTypeAgent;
					Long idUv_l;
					
					while (ligne.charAt(pt)!= ' '){
						login = login+ligne.charAt(pt);
						pt++;
					}
					pt++;
					
					while (ligne.charAt(pt)!= ' '){
						name = name+ligne.charAt(pt);
						pt++;
					}
					pt++;
					while (ligne.charAt(pt)!= ' '){
						firstName = firstName+ligne.charAt(pt);
						pt++;
					}
					pt++;
					while (ligne.charAt(pt)!= ' '){
					   nb_ch = nb_ch + ligne.charAt(pt);
					   pt++;
					}
					idTypeAgent = Integer.parseInt(nb_ch);
					pt++;
					nb_ch = "";
					while (ligne.charAt(pt)!= '$'){
						while (ligne.charAt(pt)!= ','){
						   nb_ch = nb_ch + ligne.charAt(pt);
						   pt++;
						}
						idUv_l = Long.parseLong(nb_ch);
						nb_ch = "";
						idsUv.add(idUv_l);
						pt++;
					}
					System.out.println("Ajout de l'agent "+firstName+" "+name+" de type "+idTypeAgent);
					System.out.print("Possédant les Uv N° : ");
					for (Long idUv : idsUv){
						System.out.print(" "+idUv);
					}
					System.out.println();
					addAgent(login,idTypeAgent, idsUv, name, firstName);
					break;
					
				case 'U' : 
					pt = 2;
					int idType=0;
					String title="";
					String locality="";
					int jour;
					int mois;
					int annee;
					Collection<Date> dates = null;
					Date dateLim = null;
					Date date = null;
					
					while (ligne.charAt(pt)!= ' '){
					   nb_ch = nb_ch + ligne.charAt(pt);
					   pt++;
					}
					idType = Integer.parseInt(nb_ch);
					pt++;
					
					while (ligne.charAt(pt)!= ' '){
						title = title+ligne.charAt(pt);
						pt++;
					}
					pt++;
					
					while (ligne.charAt(pt)!= ' '){
						locality = locality+ligne.charAt(pt);
						pt++;
					}
					pt++;
					
					while (ligne.charAt(pt)!= '/'){
					   nb_ch = nb_ch + ligne.charAt(pt);
					   pt++;
					}
					jour = Integer.parseInt(nb_ch);
					nb_ch="";
					pt++;
					while (ligne.charAt(pt)!= '/'){
					   nb_ch = nb_ch + ligne.charAt(pt);
					   pt++;
					}
					mois = Integer.parseInt(nb_ch);
					nb_ch="";
					pt++;
					while (ligne.charAt(pt)!= ' '){
						nb_ch = nb_ch + ligne.charAt(pt);
						pt++;
					}
					annee = Integer.parseInt(nb_ch);
					nb_ch="";
					if (annee > 100) {annee = annee -1900;}
					else {annee = annee + 100;}
					pt++;
					dateLim = new Date(annee,mois,jour);

					dates = new Vector<Date>();
					while (ligne.charAt(pt)!='$'){
						while (ligne.charAt(pt)!= '/'){
						   nb_ch = nb_ch + ligne.charAt(pt);
						   pt++;
						}
						jour = Integer.parseInt(nb_ch);
						nb_ch="";
						pt++;
						while (ligne.charAt(pt)!= '/'){
						   nb_ch = nb_ch + ligne.charAt(pt);
						   pt++;
						}
						mois = Integer.parseInt(nb_ch);
						nb_ch="";
						pt++;
						while (ligne.charAt(pt)!= ','){
							nb_ch = nb_ch + ligne.charAt(pt);
							pt++;
						}
						annee = Integer.parseInt(nb_ch);
						nb_ch="";
						if (annee > 100) {annee = annee -1900;}
						else {annee = annee + 100;}
						pt++;
						date = new Date(annee,mois,jour);
						dates.add(date);
					}
										
					addUv(idType,title,locality,dates,dateLim);
					break;
				case 'S' : 
					
					break;
				case 'T' : break;
				default : break;
				}
				
			}
			br.close();
		}
		catch (FileNotFoundException e) {e.printStackTrace();}
		catch (IOException e) {e.printStackTrace();}
	}


}
