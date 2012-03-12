package istic.sapfor.server.datastore;

import java.util.Collection;

import istic.sapfor.api.dto.*;

public interface DataStore {
	
	public SessionDTO login(String user, String password);
	public AgentDTO getAgent(Long id);
	public UvDTO getUv(Long id); 	
	public StageDTO getStage(Long id); 	
    public TypeUvDTO getTypeUv(Long id);
    
    public Collection<Long> getIdCandidat(Long idUv,EtatCandidatureDTO etat);
    
    public int nbUvs();
    public int nbAgents();
    public int nbTypeUvs();
    public int nbStages();
    
    public boolean addUv(UvDTO uv);
    public boolean addAgent(AgentDTO agent);
    public boolean addTypeUv(TypeUvDTO typeUv);
    public boolean addStage(StageDTO stage);
    
    public boolean delUv(long id);
    public boolean delAgent(long id);
    public boolean delTypeUv(long id);
    public boolean delStage(long id);

    
    
	// modif JCG 09/03/2012
	/* 
	 * Methode qui renvoie la liste des stages diriges par un Agent directeur
	 */
    public Collection<Long> getIdStageDir(Long idAgent);
	/* 
	 * Methode qui renvoie la liste des UVs contenues dans un Stage
	 */
    public Collection<Long> getIdUvStageDir(Long idStage);
	/* 
	 * Methode qui renvoie la liste des UVs possibles pour un agent et pour un stage donne
	 */
	public Collection<Long> getIdUvStageDispo(Long idAgent, Long idStage);

	// modif JCG 09/03/2012

	public boolean addInscrip(Long idAgent, Collection<Long> idsUv);
	public boolean setStatut(Long idUv, Long idCandidat,
			EtatCandidatureDTO nouvelEtat, EtatCandidatureDTO ancienEtat);

	// modif KD 12/03/2012
	/* 
	 * Methode qui renvoie la liste des stages possibles pour un agent donne
	 */
	public Collection<Long> getIdStageDispo(Long idAgent);
	
}
