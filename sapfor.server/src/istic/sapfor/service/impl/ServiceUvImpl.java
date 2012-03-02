package istic.sapfor.service.impl;

import istic.sapfor.api.dto.UvDTO;
import istic.sapfor.api.service.ServiceUv;
import istic.sapfor.server.datastore.DataStore;

public class ServiceUvImpl implements ServiceUv {

	private DataStore dataStore = null;
	
	public ServiceUvImpl(DataStore data){
		dataStore = data;
	}
	
	@Override
	public UvDTO getUv(long id) {
		// TODO Auto-generated method stub
		if(dataStore.getUvMap().containsKey(id)){
			return dataStore.getUvMap().get(id);
		}
		return null;
	}

}
