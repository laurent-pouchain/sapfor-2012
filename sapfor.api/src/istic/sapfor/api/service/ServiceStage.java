package istic.sapfor.api.service;

//import java.util.Collection;

import istic.sapfor.api.dto.*;

import javax.jws.WebService;


@WebService
public interface ServiceStage {
	
	StageDTO getStage(long id);
	
	//Collection<Long> getListStages(long idAgent);

}
