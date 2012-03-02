package istic.sapfor.service.impl;

import javax.jws.WebService;

import org.apache.log4j.Logger;

import istic.sapfor.api.dto.AgentDTO;
import istic.sapfor.api.service.ServiceAgent;
import istic.sapfor.server.datastore.DataStore;

@WebService(endpointInterface = "istic.sapfor.api.service.ServiceAgent")
public class ServiceAgentImpl implements ServiceAgent {

	private DataStore dataStore = null;
	Logger logger = Logger.getLogger(this.getClass());
	
	public void setDataStore(DataStore dataStore) {
		this.dataStore = dataStore;
		logger.info("Init DataStore by Agent "+dataStore);
	}

	@Override
	public AgentDTO getAgent(long id) {
			return dataStore.getAgent(id);
	}

}
