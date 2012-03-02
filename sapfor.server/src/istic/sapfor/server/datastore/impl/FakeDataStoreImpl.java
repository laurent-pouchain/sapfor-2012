package istic.sapfor.server.datastore.impl;

import istic.sapfor.api.dto.AgentDTO;
import istic.sapfor.api.dto.SessionDTO;
import istic.sapfor.api.dto.UvDTO;
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

	
	public Map<Long, AgentDTO> getAgentsMap() {
		return agentsMap;
	}
	
	public Map<Long, String> getSessionsMap() {
		return sessionsMap;
	}


	public Map<Long, UvDTO> getUvMap() {
		return uvMap;
	}	
	
	
}
