package istic.sapfor.service.impl;

import javax.jws.WebService;

import istic.sapfor.api.dto.SessionDTO;
import istic.sapfor.api.service.ServiceSession;

@WebService(endpointInterface = "istic.sapfor.api.service.ServiceSession")
public class ServiceSessionImpl extends StatefullService implements ServiceSession {


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
