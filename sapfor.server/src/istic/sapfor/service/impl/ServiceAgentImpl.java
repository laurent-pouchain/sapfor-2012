package istic.sapfor.service.impl;

import java.util.Collection;

import javax.jws.WebService;

import istic.sapfor.api.dto.AgentDTO;
import istic.sapfor.api.dto.EtatCandidatureDTO;
import istic.sapfor.api.service.ServiceAgent;


@WebService(endpointInterface = "istic.sapfor.api.service.ServiceAgent")
public class ServiceAgentImpl extends StatefullService implements ServiceAgent {


	@Override
	public AgentDTO getAgent(Long id) {
		logger.info("getAgent Called with param : "+id);
		return dataStore.getAgent(id);
	}

	@Override
	public Collection<Long> getIdStageDispo(Long idAgent) {
		logger.info("getIdStageDispo Called with param : "+idAgent);
		return dataStore.getIdStageDispo(idAgent);
	}

	@Override
	public Collection<Long> getIdUvStageDispo(Long idAgent, Long idStage) {
		logger.info("getIdUvStageDispo Called with param : "+idAgent+" "+idStage);
		return dataStore.getIdUvStageDispo(idAgent, idStage);
	}

	@Override
	public boolean addInscrip(Long idAgent, Collection<Long> idsUv) {
		logger.info("addInscrip Called with param : "+idAgent+" "+idsUv);
		for (Long idS : dataStore.getIdStageInscrit(idAgent)) {
			for (Long idUv : dataStore.getIdUvStageInscrit(idAgent, idS)) {
				if ((dataStore.getUv(idUv).isCandCloses()) || idsUv.contains(idUv)) {return false;}
			}
				
		}
		return dataStore.addInscrip(idAgent,idsUv);
	}

	@Override
	public Collection<Long> getIdStageDir(Long idAgent) {
		logger.info("getIdStageDir Called with param : "+idAgent);
		return dataStore.getIdStageDir(idAgent);
	}

	@Override
	public Collection<Long> getIdUvStageDir(Long idStage) {
		logger.info("getIdUvStageDir Called with param : "+idStage);
		return dataStore.getIdUvStageDir(idStage);
	}

	@Override
	public Collection<Long> getIdCandidat(Long idUv, EtatCandidatureDTO etat) {
		logger.info("getIdCandidat Called with param : "+idUv+" "+etat);
        return dataStore.getIdCandidat(idUv, etat);
	}

	@Override
	public boolean setStatut(Long idUv, Long idCandidat,
		EtatCandidatureDTO nouvelEtat, EtatCandidatureDTO ancienEtat) {
		logger.info("setStatut Called with param : "+idUv+" "+idCandidat+" "+nouvelEtat+" "+ancienEtat);
		if (nouvelEtat == EtatCandidatureDTO.annule && 
				(!dataStore.getUv(idUv).isCandCloses()|dataStore.getUv(idUv).isCandValids())){
			if (dataStore.getIdCandidat(idUv, ancienEtat).contains(idCandidat)) {
				return dataStore.setStatut(idUv,idCandidat,nouvelEtat,ancienEtat);
			}
			else {return false;}
		}
		else {
			if (nouvelEtat != EtatCandidatureDTO.annule && dataStore.getIdCandidat(idUv, ancienEtat).contains(idCandidat)) {
				return dataStore.setStatut(idUv,idCandidat,nouvelEtat,ancienEtat);
			}
			else {return false;}
		}
    }
	
	@Override
	public Collection<Long> getIdStageInscrit(Long idAgent) {
		logger.info("getIdStageInscrit Called with param : "+idAgent);
		return dataStore.getIdStageInscrit(idAgent);
	}

	@Override
	public Collection<Long> getIdUvStageInscrit(Long idAgent, Long idStage) {
		logger.info("getIdUvStageInscrit Called with param : "+idAgent+" "+idStage);
		return dataStore.getIdUvStageInscrit(idAgent, idStage);
	}



}
