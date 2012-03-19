package istic.sapfor.api.service;
import istic.sapfor.api.dto.UvDTO;


import javax.jws.WebService;


@WebService
public interface ServiceUv {
	
	/**
	 * Renvois l'Uv correspondante à l'identificateur passé en paramètre.
	 * @param idUv
	 * @return objet de type UvDTO avec les attributs de l'UV.
	 */
	UvDTO getUv(long idUv);
	
	/**
	 * Ferme les candidatures empechant ainsi l'inscription d'agents supplémentaires
	 * et permet le tri par le directeur du stage.
	 * @pre l'agent doit être directeur du stage contenant cette Uv et le nombre minimum
	 * de participants doit être atteinds.
	 * @param idUv  
	 * @return boolean qui permet de statuer sur la réussite de la fermeture des candidatures.
	 */
	boolean setCandCloses(long idUv);
	
	/**
	 * Valide les candidatures dans leur état actuel
	 * @pre l'agent doit être directeur du stage contenant cette Uv et le nombre minimum de participants
	 * doit être atteind dans la liste "Retenus"
	 * @param idUv
	 * @return boolean qui permet de statuer sur la réussite de la validation des candidatures.
	 */
	boolean setCandValids(long idUv);
        
}
