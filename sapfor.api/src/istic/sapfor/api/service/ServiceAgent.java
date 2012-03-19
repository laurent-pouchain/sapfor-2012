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
    * ou
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
	 * Retourne la liste des identificateurs des stages auxquels est inscrit l'agent dont
	 * l'identificateur est passé en paramètre
	 * @param idAgent
	 * @return une collection d'identificateurs de stages auxquels est inscrit l'agent.
	 */
	Collection<Long> getIdStageInscrit(Long idAgent);
	
	/**
	 * Retourne la liste des identificateurs des UVs d'un stage donné auxquels
	 * est inscrit l'agent dont l'identificateur est passé en paramètre
	 * @param idAgent
	 * @param idStage
	 * @return une collection d'identificateurs d'UVs auxquelles est inscrit l'agent.
	 */
	Collection<Long> getIdUvStageInscrit(Long idAgent, Long idStage);
	
	/**
	 * Retourne la liste de tous les agents a fin de gestion administrative, ne peut être appelée
	 * que par un Directeur/Admin
	 * @param idDirecteur
	 * @return la collection de tous les identificateurs d'agents présent dans la base de donnée.
	 */
	Collection<Long> getAllIdsAgent(Long idDirecteur);
	
	/**
	 * Ajoute à la base de données l'agent passé en paramètre
	 * @param agent  AgentDTO dont tous les champs sont renseignés à l'exception de l'id qui sera généré 
	 * automatiquement.
	 * @return un boolean statuant sur la réussite de l'ajout.
	 */
	boolean addAgent(AgentDTO agent);
	
	/**
	 * Supprime de la base de données l'agent dont l'identificateur est passé en paramètre
	 * @param idAgent  identificateur de l'agent que l'on veut supprimer de la base de donnée
	 * @return un boolean statuant sur la réussite de la suppression.
	 */
	boolean delAgent(Long idAgent);
	
}
