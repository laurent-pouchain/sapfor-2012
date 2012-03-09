package istic.sapfor.service.impl;

import java.util.Collection;

import javax.jws.WebService;

import org.apache.log4j.Logger;

import istic.sapfor.api.dto.AgentDTO;
import istic.sapfor.api.dto.EtatCandidatureDTO;
import istic.sapfor.api.service.ServiceAgent;
import istic.sapfor.server.datastore.DataStore;

@WebService(endpointInterface = "istic.sapfor.api.service.ServiceAgent")
public class ServiceAgentImpl implements ServiceAgent {

	private DataStore dataStore = null;
	Logger logger = Logger.getLogger(this.getClass());
	
	public void setDataStore(DataStore dataStore) {
		this.dataStore = dataStore;
		logger.info("Init DataStore by Agent "+dataStore);
	}

	@Override
	public AgentDTO getAgent(Long id) {
		logger.info("getAgent Called with param : "+id);
		return dataStore.getAgent(id);
	}

	@Override
	public Collection<Long> getIdStageDispo(Long idAgent) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Collection<Long> getIdUvStageDispo(Long idAgent, Long idStage) {
		return dataStore.getIdUvStageDispo(idAgent, idStage);
	}

	@Override
	public boolean addInscrip(Long idAgent, Collection<Long> idsUv) {
		return dataStore.addInscrip(idAgent,idsUv);
	}

	@Override
	public Collection<Long> getIdStageDir(Long idAgent) {
		return dataStore.getIdStageDir(idAgent);
	}

	@Override
	public Collection<Long> getIdUvStageDir(Long idStage) {
		return dataStore.getIdUvStageDir(idStage);
	}

	@Override
	public Collection<Long> getIdCandidat(Long idUv, EtatCandidatureDTO etat) {
        return dataStore.getIdCandidat(idUv, etat);
	}

	@Override
	public boolean setStatut(Long idUv, Long idCandidat,
		EtatCandidatureDTO nouvelEtat, EtatCandidatureDTO ancienEtat) {
		return dataStore.setStatut(idUv,idCandidat,nouvelEtat,ancienEtat);
    }


}
