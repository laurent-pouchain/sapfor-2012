package istic.sapfor.server.datastore;

import istic.sapfor.api.dto.AgentDTO;
import istic.sapfor.api.dto.UvDTO;

import java.util.Map;

public interface DataStore {
	
	public Map<Long, AgentDTO> getAgentsMap();
	
	public Map<Long, UvDTO> getUvMap();
	
}
