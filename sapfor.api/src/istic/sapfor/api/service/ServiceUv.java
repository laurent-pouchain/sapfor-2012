package istic.sapfor.api.service;
import istic.sapfor.api.dto.UvDTO;


import javax.jws.WebService;


@WebService
public interface ServiceUv {
	
	UvDTO getUv(long id);
        
}
