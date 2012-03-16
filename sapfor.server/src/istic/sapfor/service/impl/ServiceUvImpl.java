package istic.sapfor.service.impl;

import javax.jws.WebService;

import istic.sapfor.api.dto.UvDTO;
import istic.sapfor.api.service.ServiceUv;


@WebService(endpointInterface = "istic.sapfor.api.service.ServiceUv")
public class ServiceUvImpl extends StatefullService implements ServiceUv {
	
	@Override
	public UvDTO getUv(long id) {
		return dataStore.getUv(id);
	}

}
