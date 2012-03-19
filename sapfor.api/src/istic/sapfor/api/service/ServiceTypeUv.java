package istic.sapfor.api.service;

import istic.sapfor.api.dto.*;

import javax.jws.WebService;

@WebService
public interface ServiceTypeUv {

	/**
	 * Renvois le type d'Uv correspondant à l'identificateur passé en paramètre.
	 * @param idTypeUv
	 * @return objet de type TypeUvDTO avec les attributs du type d'UV.
	 */
	TypeUvDTO getTypeUv(Long idTypeUv);
	
}
