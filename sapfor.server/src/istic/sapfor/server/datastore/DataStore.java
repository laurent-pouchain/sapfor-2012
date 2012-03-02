package istic.sapfor.server.datastore;

import istic.sapfor.api.dto.*;

public interface DataStore {
	
	public SessionDTO login(String user, String password);
	public AgentDTO getAgent(Long id);
	public UvDTO getUv(Long id); 	
	public StageDTO getStage(Long id); 	
    public TypeUvDTO getTypeUv(Long id);
	
}
