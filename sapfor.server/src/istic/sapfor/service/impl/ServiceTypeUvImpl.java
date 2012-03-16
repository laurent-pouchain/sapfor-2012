package istic.sapfor.service.impl;

import javax.jws.WebService;

import istic.sapfor.api.dto.TypeUvDTO;
import istic.sapfor.api.service.ServiceTypeUv;


@WebService(endpointInterface = "istic.sapfor.api.service.ServiceTypeUv")
public class ServiceTypeUvImpl extends StatefullService implements ServiceTypeUv {

	@Override
	public TypeUvDTO getTypeUv(Long id) {

		return dataStore.getTypeUv(id);
	}

}
