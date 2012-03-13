package istic.sapfor.service.impl;
import javax.jws.WebService;

import org.apache.log4j.Logger;

import istic.sapfor.api.dto.StageDTO;
import istic.sapfor.api.service.ServiceStage;
import istic.sapfor.server.datastore.DataStore;

@WebService(endpointInterface = "istic.sapfor.api.service.ServiceStage")
public class ServiceStageImpl implements ServiceStage {

	private DataStore dataStore = null;
	Logger logger = Logger.getLogger(this.getClass());
	
	public void setDataStore(DataStore dataStore) {
		this.dataStore = dataStore;
		logger.info("Init DataStore by Stage "+dataStore);
	}	
	
	@Override
	public StageDTO getStage(long id) {
		//probleme!!!!
		return dataStore.getStage(id);
	}

}
