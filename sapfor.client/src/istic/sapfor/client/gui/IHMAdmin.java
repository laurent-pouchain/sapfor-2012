package istic.sapfor.client.gui;

import istic.sapfor.api.dto.EtatCandidatureDTO;

import java.util.Collection;
import java.util.HashMap;

public interface IHMAdmin {
	
	Collection<Long> getIdStageDir(Long idAgent);
	public Collection<Long> getIdUvStageDir(Long idStage);
	public Collection<Long> getIdUvStageDispo(Long idAgent, Long idStage);
	public Collection<Long> getIdCandidat(Long idUv, EtatCandidatureDTO etat);
	public boolean setStatut(Long idUv, Long idCandidat, EtatCandidatureDTO nouvelEtat, EtatCandidatureDTO ancienEtat);
	void GererInscriptionUvDir(HashMap<Long, String> st);
}
