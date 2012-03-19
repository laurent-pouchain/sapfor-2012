package istic.sapfor.api.service;

import istic.sapfor.api.dto.*;

import javax.jws.WebService;


@WebService
public interface ServiceStage {
	
	/**
	 * Renvois le StageDTO correspondant à l'identificateur passé en paramètre.
	 * @param idStage
	 * @return objet de type StageDTO avec les attributs du stage.
	 */
	StageDTO getStage(long idStage);
	
}
