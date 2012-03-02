package istic.sapfor.server.datastore;

import istic.sapfor.api.dto.AgentDTO;
import istic.sapfor.api.dto.UvDTO;

import java.util.HashMap;
import java.util.Map;

public class FakeDataStore implements DataStore {

	private Map<Long,AgentDTO> agentsMap = new HashMap<Long,AgentDTO>();
	private Map<Long,UvDTO> uvMap = new HashMap<Long,UvDTO>();

	public Map<Long, AgentDTO> getAgentsMap() {
		return agentsMap;
	}

	public Map<Long, UvDTO> getUvMap() {
		return uvMap;
	}
	
	
	
	
}
