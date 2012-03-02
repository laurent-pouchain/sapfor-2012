package istic.sapfor.api.service;

import javax.jws.WebService;

import istic.sapfor.api.dto.SessionDTO;

@WebService
public interface ServiceSession {
	
	SessionDTO login(String user, String password);
	
	boolean logout(SessionDTO session);

}
