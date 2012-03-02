package istic.sapfor.server.datastore.impl;

import istic.sapfor.api.dto.*;
import istic.sapfor.server.datastore.DataStore;

import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Logger;

public class FakeDataStoreImpl implements DataStore {

	Logger logger = Logger.getLogger(this.getClass());
	
	public FakeDataStoreImpl(){
		System.out.println("Build data store ...");
		logger.info("Hello");
		
	}
	
	private Map<Long,AgentDTO> agentsMap = new HashMap<Long,AgentDTO>();
	private Map<Long,String> sessionsMap = new HashMap<Long,String>();
	private Map<Long,UvDTO> uvMap = new HashMap<Long,UvDTO>();
	private Map<Long,StageDTO> stageMap = new HashMap<Long,StageDTO>();

	
	public AgentDTO getAgent(Long id) {
		if(this.agentsMap.containsKey(id)){
			return this.agentsMap.get(id);
		}
		return null;
	}
	
	public SessionDTO login(String user, String password) {
		// TODO Auto-generated method stub
		if(this.sessionsMap.containsKey(Long.parseLong(user))){
			if (this.sessionsMap.get(Long.parseLong(user)).equals(password)){
				SessionDTO mySession = new SessionDTO();
				mySession.setIdAgent(Long.parseLong(user));
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

	
	
}
