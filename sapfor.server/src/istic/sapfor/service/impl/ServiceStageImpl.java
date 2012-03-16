package istic.sapfor.service.impl;
import javax.jws.WebService;


import istic.sapfor.api.dto.StageDTO;
import istic.sapfor.api.service.ServiceStage;

@WebService(endpointInterface = "istic.sapfor.api.service.ServiceStage")
public class ServiceStageImpl extends StatefullService implements ServiceStage {
	
	@Override
	public StageDTO getStage(long id) {
		//probleme!!!!
		return dataStore.getStage(id);
	}

}
