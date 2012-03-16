package istic.sapfor.service.impl;

import istic.sapfor.server.datastore.DataStore;

import org.apache.log4j.Logger;

public class StatefullService {

	protected DataStore dataStore = null;
	protected Logger logger = Logger.getLogger(this.getClass());
	
	public void setDataStore(DataStore dataStore) {
		this.dataStore = dataStore;
		logger.info("Init DataStore by "+this.getClass().getSimpleName()+" "+dataStore);
	}
	
}
