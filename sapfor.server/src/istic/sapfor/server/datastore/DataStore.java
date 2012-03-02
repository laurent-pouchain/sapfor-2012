package istic.sapfor.server.datastore;

import istic.sapfor.api.dto.*;

public interface DataStore {
	
	//TO DO Improve the interface : do not return a Map 
	
	public AgentDTO getAgent(Long id);
	public SessionDTO login(String user, String password);
	public UvDTO getUv(Long id); 	
	public StageDTO getStage(Long id); 	

}
