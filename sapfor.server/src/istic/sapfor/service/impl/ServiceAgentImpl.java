package istic.sapfor.service.impl;

import istic.sapfor.api.dto.AgentDTO;
import istic.sapfor.api.service.ServiceAgent;
import istic.sapfor.server.datastore.DataStore;

public class ServiceAgentImpl implements ServiceAgent {

	private DataStore dataStore = null;
	public ServiceAgentImpl(DataStore data){
		dataStore = data;
	}
	
	
	@Override
	public AgentDTO getAgent(long id) {
		// TODO Auto-generated method stub
		if(dataStore.getAgentsMap().containsKey(id)){
			return dataStore.getAgentsMap().get(id);
		}
		return null;
	}

}
