package istic.sapfor.service.impl;

import javax.jws.WebService;

import org.apache.log4j.Logger;

import istic.sapfor.api.dto.UvDTO;
import istic.sapfor.api.service.ServiceUv;
import istic.sapfor.server.datastore.DataStore;

@WebService(endpointInterface = "istic.sapfor.api.service.ServiceUv")
public class ServiceUvImpl implements ServiceUv {

	private DataStore dataStore = null;
	Logger logger = Logger.getLogger(this.getClass());
	
	public void setDataStore(DataStore dataStore) {
		this.dataStore = dataStore;
		logger.info("Init DataStore by UV "+dataStore);
	}
	
	@Override
	public UvDTO getUv(long id) {
		return dataStore.getUv(id);
	}

}
