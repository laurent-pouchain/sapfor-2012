package istic.sapfor.api.service;

import istic.sapfor.api.dto.SessionDTO;

public interface ServiceSession {
	
	SessionDTO login(String user, String password);
	
	boolean logout(SessionDTO session);

}
