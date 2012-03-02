package istic.sapfor.service.impl;

import javax.jws.WebService;

import org.apache.log4j.Logger;

import istic.sapfor.api.dto.TypeUvDTO;
import istic.sapfor.api.service.ServiceTypeUv;
import istic.sapfor.server.datastore.DataStore;

@WebService(endpointInterface = "istic.sapfor.api.service.ServiceTypeUv")
public class ServiceTypeUvImpl implements ServiceTypeUv {
	
	private DataStore dataStore = null;
	Logger logger = Logger.getLogger(this.getClass());
	
	public void setDataStore(DataStore dataStore) {
		this.dataStore = dataStore;
		logger.info("Init DataStore by TypeUV "+dataStore);
	}

	@Override
	public TypeUvDTO getTypeUv(Long id) {

		return dataStore.getTypeUv(id);
	}

}
