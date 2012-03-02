package istic.sapfor.service.impl;

import javax.jws.WebService;

import org.apache.log4j.Logger;

import istic.sapfor.api.dto.SessionDTO;
import istic.sapfor.api.service.ServiceSession;
import istic.sapfor.server.datastore.DataStore;

@WebService(endpointInterface = "istic.sapfor.api.service.ServiceSession")
public class ServiceSessionImpl implements ServiceSession {

	private DataStore dataStore = null;
	Logger logger = Logger.getLogger(this.getClass());
	
	public void setDataStore(DataStore dataStore) {
		this.dataStore = dataStore;
		logger.info("Init DataStore by Session "+dataStore);
	}

	@Override
	public SessionDTO login(String user, String password) {
		return dataStore.login(user, password);
	}

	@Override
	public boolean logout(SessionDTO session) {
		return true;
		// TODO cleanup open connections		
	}
	
}
