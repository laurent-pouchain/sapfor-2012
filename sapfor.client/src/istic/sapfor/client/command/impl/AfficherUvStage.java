package istic.sapfor.client.command.impl;

import java.util.Collection;
import java.util.HashMap;


import istic.sapfor.api.dto.UvDTO;
import istic.sapfor.api.service.ServiceAgent;
import istic.sapfor.api.service.ServiceUv;
import istic.sapfor.client.command.ICommand;
import istic.sapfor.client.command.ICommandContext;
import istic.sapfor.client.command.ICommandContextKey;
import istic.sapfor.client.gui.IHMGStage;


public class AfficherUvStage implements ICommand{
	
	private ServiceUv clientU;
	private ServiceAgent client;
	private IHMGStage ihmgstage ;
	
	public Boolean execute(ICommandContext ctx) {
		// TODO Auto-generated method stub
		long idAgent = (long)0;
		
		String idS=ctx.get(ICommandContextKey.Key_Stage);
		int idStage;
		idStage= Integer.parseInt(idS); 
		Collection<Long> uvDispo = client.getIdUvStageDispo(idAgent, (long)idStage);
		System.out.println(uvDispo);
		HashMap<Long,String> uv= new HashMap<Long,String>();
		for (long id : uvDispo ){
			System.out.println(id);
			UvDTO suv= clientU.getUv(id);
			uv.put(id, suv.getTitle());
			System.out.println(suv.getTitle());
								}
		//A d�commenter une fois que displayUvDisp sera impl�ment� dans l'IHM
		ihmgstage.displayUvDispo(uv);
		
		
		return true;
	}
	public ServiceUv getClientU() {
		return clientU;
	}
	public void setClientU(ServiceUv clientU) {
		this.clientU = clientU;
	}
	public ServiceAgent getClient() {
		return client;
	}
	public void setClient(ServiceAgent client) {
		this.client = client;
	}
	public IHMGStage getIhmgstage() {
		return ihmgstage;
	}
	public void setIhmgstage(IHMGStage ihmgstage) {
		this.ihmgstage = ihmgstage;
	}


}