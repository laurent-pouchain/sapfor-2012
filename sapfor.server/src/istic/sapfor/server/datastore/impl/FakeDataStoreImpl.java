package istic.sapfor.server.datastore.impl;

import istic.sapfor.api.dto.*;
import istic.sapfor.server.datastore.DataStore;

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
	
	}
	
	private Map<Long,String> sessionsMap = new HashMap<Long,String>();
	private Map<Long,AgentDTO> agentsMap = new HashMap<Long,AgentDTO>();
	private Map<Long,UvDTO> uvMap = new HashMap<Long,UvDTO>();
	private Map<Long,StageDTO> stageMap = new HashMap<Long,StageDTO>();
	private Map<Long,TypeUvDTO> typeUvMap = new HashMap<Long,TypeUvDTO>();
	
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
				mySession.setIdAgent((long)user.hashCode());
				return mySession;
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
		
		Collection<Long> idOwnedJD = new Vector<Long>();
		Collection<Long> idOwnedU1 = new Vector<Long>();
		Collection<Long> idOwnedU2 = new Vector<Long>();
		
		idOwnedU1.add((long)0);
		idOwnedU1.add((long)6);
		
		idOwnedU2.add((long)3);
		idOwnedU2.add((long)4);
		idOwnedU2.add((long)6);

		addAgent(92668751,0,idOwnedJD,"Doe","John");
		addAgent(-1419698740,1,idOwnedU1,"Dupont","Jean");
		addAgent(-1419698739,1,idOwnedU2,"Dupond","Jeanne");

		Collection<Date> datesUv0 = new Vector<Date>();
		datesUv0.add(new Date(111,12,9));
		Collection<Date> datesUv1 = new Vector<Date>();
		datesUv1.add(new Date(112,1,1));
		datesUv1.add(new Date(112,1,2));
		Collection<Date> datesUv2 = new Vector<Date>();
		datesUv2.add(new Date(112,1,7));
		datesUv2.add(new Date(112,1,8));
		Collection<Date> datesUv3 = new Vector<Date>();
		datesUv3.add(new Date(112,2,6));
		Collection<Date> datesUv4 = new Vector<Date>();
		datesUv4.add(new Date(112,2,7));
		datesUv4.add(new Date(112,2,8));
		Collection<Date> datesUv5 = new Vector<Date>();
		datesUv5.add(new Date(112,3,7));
		Collection<Date> datesUv6 = new Vector<Date>();
		datesUv6.add(new Date(112,3,15));
		Collection<Date> datesUv7 = new Vector<Date>();
		datesUv7.add(new Date(112,5,6));
		Collection<Date> datesUv8 = new Vector<Date>();
		datesUv8.add(new Date(112,5,7));
		datesUv8.add(new Date(112,5,8));		
		Collection<Date> datesUv9 = new Vector<Date>();
		datesUv9.add(new Date(112,5,7));
		datesUv9.add(new Date(112,5,8));	
		Collection<Date> datesUv10 = new Vector<Date>();
		datesUv10.add(new Date(112,5,14));
		datesUv10.add(new Date(112,5,15));	
		Collection<Date> datesUv11 = new Vector<Date>();
		datesUv11.add(new Date(112,6,1));
		datesUv11.add(new Date(112,6,2));
		
		addUv(0,0,"Basics-M-09.12.11", "Monfort", datesUv0, new Date(111,12,1));
		addUv(1,1,"FF1-F-01.01.12", "Foug�res", datesUv1, new Date(111,12,15));
		addUv(2,1,"FF1-F-07.01.12", "Foug�res", datesUv2, new Date(111,12,15));
		addUv(3,0,"Basics-R-06.02.15", "Rennes", datesUv3, new Date(111,1,15));
		addUv(4,1,"FF1-R-07.02.12", "Rennes", datesUv4, new Date(111,1,15));
		addUv(5,0,"Basics-R-06.02.15", "Bain-de-Bretagne", datesUv5, new Date(111,1,21));
		addUv(6,3,"PS1-R-15.03.12", "Rennes", datesUv6, new Date(111,3,1));
		addUv(7,0,"Basics-F-06.05.12", "Foug�res", datesUv7, new Date(111,5,1));
		addUv(8,3,"PS1-F-07.05.12", "Foug�res", datesUv8, new Date(111,5,1));
		addUv(9,2,"FF2-M-07.05.12", "Monfort", datesUv9, new Date(112,5,1));
		addUv(10,2,"FF2-R-14.05.12", "Rennes", datesUv10, new Date(111,1,15));
		addUv(11,4,"PS2-BB-01.06.12", "Bain-de-Bretagne", datesUv11, new Date(111,5,15));
		
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
		
		addStage(0,uvStage0,"Stage de Base","Monfort");
		addStage(1,uvStage1,"Feux de For�t 1","Foug�res");
		addStage(2,uvStage2,"Feux de For�t 1","Foug�res");
		addStage(3,uvStage3,"Base et Feux de For�t 1","Rennes");
		addStage(4,uvStage4,"Stage de Base","Monfort");		
		addStage(5,uvStage5,"Premiers Secours 1","Rennes");
		addStage(6,uvStage6,"Base et Premiers Secours 1","Foug�res");
		addStage(7,uvStage7,"Feux de For�t 2","Rennes");
		addStage(8,uvStage8,"Feux de For�t 2","Monfort");
		addStage(9,uvStage9,"Premiers Secours 2","Monfort");
		
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
		
		addTypeUv(0, "Stage de Base", typesUvPre0);
		addTypeUv(1, "Sap-FF1", typesUvPre1);
		addTypeUv(2, "Sap-FF2", typesUvPre2);
		addTypeUv(3, "Sap-PS1", typesUvPre3);
		addTypeUv(4, "Sap-PS2", typesUvPre4);		
		
	}
	
	private void addAgent(int id, int idType, Collection<Long> idOwned, String name, String firstname) {
		AgentDTO agent = new AgentDTO();
		
		agent.setIdAgent(id);
		agent.setIdTypeAgent(idType);
		agent.setListIdUvOwned(idOwned);
		agent.setName(name);
		agent.setFirstName(firstname);
		
		agentsMap.put(agent.getIdAgent(),agent);
		
		keyAgent++;
		
	}
	
	private void addUv(int id, int idType, String title, String locality, Collection<Date> dates, Date dateLim ) {
		UvDTO uv = new UvDTO();
		
		uv.setIdUv(id);
		uv.setIdTypeUv(idType);
		uv.setTitle(title);
		uv.setLocality(locality);
		uv.setDates(dates);
		uv.setDateLimite(dateLim);
		
		uvMap.put(uv.getIdUv(), uv);
		
		keyUv++;
    }
	
	private void addStage(int id, Collection<Long> idUv, String title, String locality) {
		StageDTO stage = new StageDTO();
		
		stage.setIdStage(id);
		stage.setTitle(title);
		stage.setLocality(locality);
		stage.setListIdUv(idUv);
		
		stageMap.put(stage.getIdStage(), stage);
		
		keyStage++;
	}
	
	private void addTypeUv(int id, String title, Collection<Long> typesUvPre) {
		TypeUvDTO typeUv = new TypeUvDTO();
		
		typeUv.setIdTypeUv(id);
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
		keyUv++;
		return true;
	}

	@Override
	public boolean addAgent(AgentDTO agent) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean addTypeUv(TypeUvDTO typeUv) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean addStage(StageDTO stage) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int nbUvs() {
		return uvMap.size();
	}

	@Override
	public int nbAgents() {
		// TODO Auto-generated method stub
		return agentsMap.size();
	}

	@Override
	public int nbTypeUvs() {
		// TODO Auto-generated method stub
		return typeUvMap.size();
	}

	@Override
	public int nbStages() {
		// TODO Auto-generated method stub
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

}