package istic.sapfor.service.impl;

import javax.jws.WebService;

import org.apache.log4j.Logger;

import istic.sapfor.api.dto.AgentDTO;
import istic.sapfor.api.service.ServiceAgent;
import istic.sapfor.server.datastore.DataStore;

@WebService
public class ServiceAgentImpl implements ServiceAgent {

	private DataStore dataStore = null;
	Logger logger = Logger.getLogger(this.getClass());
	
	public void setDataStore(DataStore dataStore) {
		this.dataStore = dataStore;
		logger.info("Init DataStore by Agent "+dataStore);
	}

	@Override
	public AgentDTO getAgent(Long id) {
		return dataStore.getAgent(id);
	}

}
