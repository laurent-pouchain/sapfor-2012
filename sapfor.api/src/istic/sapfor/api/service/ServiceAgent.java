package istic.sapfor.api.service;
import istic.sapfor.api.dto.*;

import javax.jws.WebService;


@WebService
public interface ServiceAgent {

	AgentDTO getAgent(Long id);
	//TO DO add, remove
}
