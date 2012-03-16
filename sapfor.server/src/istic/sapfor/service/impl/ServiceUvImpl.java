package istic.sapfor.service.impl;

import javax.jws.WebService;

import istic.sapfor.api.dto.UvDTO;
import istic.sapfor.api.service.ServiceUv;


@WebService(endpointInterface = "istic.sapfor.api.service.ServiceUv")
public class ServiceUvImpl extends StatefullService implements ServiceUv {
	
	@Override
	public UvDTO getUv(long id) {
		logger.info("getUv Called with param : "+id);
		return dataStore.getUv(id);
	}

	@Override
	public boolean setCandCloses(long id) {
        return dataStore.setCandCloses(id);
	}

	@Override
	public boolean setCandValids(long id) {
		return dataStore.setCandValids(id);
	}

}
