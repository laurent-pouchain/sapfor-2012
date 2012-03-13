package istic.sapfor.api.service;
import java.util.Collection;

import istic.sapfor.api.dto.*;

import javax.jws.WebService;


@WebService
public interface ServiceAgent {

	AgentDTO getAgent(Long id);
	//TO DO add, remove
	
	Collection<Long> getIdStageDispo(Long idAgent);
	
	Collection<Long> getIdUvStageDispo(Long idAgent, Long idStage);
	
	boolean addInscrip(Long idAgent, Collection<Long> idsUv);
	
	Collection<Long> getIdStageDir(Long idAgent);
	
	Collection<Long> getIdUvStageDir(Long idStage);
	
	Collection<Long> getIdCandidat(Long idUv, EtatCandidatureDTO etat);
	
	boolean setStatut(Long idUv, Long idCandidat, EtatCandidatureDTO nouvelEtat, EtatCandidatureDTO ancienEtat);

	/**
	 *  12/03/2012 JCG
	 * Methodes rajoutees pour permettre l'annulation de candidature par un agent
	 * @param idAgent
	 * @return
	 */
	Collection<Long> getIdStageInscrit(Long idAgent);
	
	Collection<Long> getIdUvStageInscrit(Long idAgent, Long idStage);
	
	
	
}
