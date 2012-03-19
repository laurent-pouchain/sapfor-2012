package istic.sapfor.api.service;
import java.util.Collection;

import istic.sapfor.api.dto.*;

import javax.jws.WebService;


@WebService
public interface ServiceAgent {

    /**
    * Renvois l'AgentDTO correspondant à l'identificateur passé en paramètre.
    * @param idAgent  identificateur de l'agent demandé.
    * @return objet de type AgentDTO avec les attributs de l'agent
    **/
	AgentDTO getAgent(Long idAgent);
	
    /**
    * Renvois la liste des stages disponibles pour un agent.
    * @param idAgent  identificateur de l'agent demandant les stages.
    * @return la collection d'idStage correspondant aux UVs accessibles pour l'agent.
    **/
	Collection<Long> getIdStageDispo(Long idAgent);
	
    /**
    * Renvois la liste des UVs accessibles pour un agent dans un stage donné.
    * @param idAgent  identificateur de l'Agent demandant les UVs.
    * @param idStage  identificateur du stage.
    * @return la collection d'idUV accessibles en fonction de leurs prérequis
    * et des types d'UVs des UVs détenues par l'agent
    **/
	Collection<Long> getIdUvStageDispo(Long idAgent, Long idStage);
	
    /**
    * Inscription de l'agent aux UVs dont les idUv sont envoyées dans la collection
    * @pre les candidatures ne sont pas closes
    * @pre l'agent n'est pas déjà inscrit
    * @param idAgent identificateur de l'agent demandant l'inscription.
    * @param idsUv   liste des identificateurs d'Uv auquels veux s'inscrire l'agent.
    * @return un booléen indiquant si l'inscription aux UVs s'est bien passée ou non     
    **/	
	boolean addInscrip(Long idAgent, Collection<Long> idsUv);
	
	/**
	* Renvois la liste des stages dont l'agent est directeur.
	* @pre l'agent est un directeur.
	* @param idAgent  identificateur de l'agent demandant les stages.
	* @return la collection d'idStage dont l'agent est directeur.
	**/
	Collection<Long> getIdStageDir(Long idAgent);
	
    /**
    * Renvois la liste des UVs d'un stage dont l'agent est directeur.
    * @pre l'agent est directeur du stage.
    * @param  idAgent identificateur de l'agent faisant la demande.
    * @param  idStage identificateur du stage faisant l'objet de la demande.
    * @return la collection d'identificateur d'UVs du stage.
    **/
	Collection<Long> getIdUvStageDir(Long idStage);
	
    /**
    * Renvois la liste des candidats d'une UV en fonction de l'état de leur candidature.
    * @pre la methode est appelée par le directeur du stage contenant l'UV.
    * @param idUv  identificateur de l'UV
    * @param etat  
    * @return une collection d'identificateurs d'agent qui sont inscrits à l'UV correspondante
    *  avec l'état passé en paramètres
    **/
	Collection<Long> getIdCandidat(Long idUv, EtatCandidatureDTO etat);
	
    /**
    * Met à jour l'état d'une candidature en fonction du classement choisi par le
    * directeur ou permet à un agent d'annuler sa candidature à une UV.
    * @pre l'agent est directeur pour le cas d'usage "classer candidature"
    * ou met à jour l'état d'une candidature d'un agent qui peut annuler sa candidature
    * @pre l'agent est inscrit à une UV
    * @pre les candidatures ne sont pas closes ou elles sont validées
    * @param idUv
    * @param idCandidat
    * @param nouvelEtat
    * @param ancienEtat
    * @return un booléen indiquant si la mise à jour s'est bien déroulée ou non
    **/
	boolean setStatut(Long idUv, Long idCandidat, EtatCandidatureDTO nouvelEtat, EtatCandidatureDTO ancienEtat);

	/**
	 * 
	 * @param idAgent
	 * @return
	 */
	Collection<Long> getIdStageInscrit(Long idAgent);
	
	Collection<Long> getIdUvStageInscrit(Long idAgent, Long idStage);
	
	Collection<Long> getAllIdsAgent(Long idDirecteur);
	
	boolean addAgent(AgentDTO agent);
	
	boolean delAgent(Long idAgent);
	
}
