package istic.sapfor.server.datastore;

import istic.sapfor.api.dto.AgentDTO;
import istic.sapfor.api.dto.SessionDTO;
import istic.sapfor.api.dto.UvDTO;

import java.util.Map;

public interface DataStore {
	
	//TO DO Improve the interface : do not return a Map 
	
	public Map<Long, AgentDTO> getAgentsMap();
	public Map<Long, String> getSessionsMap();
	public Map<Long, UvDTO> getUvMap(); 	

}
