package istic.sapfor.api.service;

import istic.sapfor.api.dto.*;

import javax.jws.WebService;

@WebService
public interface ServiceTypeUv {

	TypeUvDTO getTypeUv(Long id);
	
}
