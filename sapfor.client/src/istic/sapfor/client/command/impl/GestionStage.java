package istic.sapfor.client.command.impl;

import java.util.Collection;
import java.util.HashMap;

import istic.sapfor.api.dto.StageDTO;
import istic.sapfor.api.service.ServiceAgent;
import istic.sapfor.api.service.ServiceStage;
import istic.sapfor.client.command.ICommand;
import istic.sapfor.client.command.ICommandContext;
import istic.sapfor.client.command.ICommandContextKey;
import istic.sapfor.client.gui.IHMGStage;

public class GestionStage implements ICommand{
	private ServiceAgent client;
	private ServiceStage clientS;
	private IHMGStage ihmgstage;
	
	public IHMGStage getIhmgstage() {
		return ihmgstage;
	}
	public void setIhmgstage(IHMGStage ihmgstage) {
		this.ihmgstage = ihmgstage;
	}
	public ServiceAgent getClient() {
		return client;
	}
	public void setClient(ServiceAgent client) {
		this.client = client;
	}
	public ServiceStage getClientS() {
		return clientS;
	}
	public void setClientS(ServiceStage clientS) {
		this.clientS = clientS;
	}
	
	
	@Override
	public Boolean execute(ICommandContext ctx) {
		// TODO Auto-generated method stub
		String idA=ctx.get(ICommandContextKey.Key_Agent);
		int idAgent= Integer.parseInt(idA);
		Collection<Long> stDir = client.getIdStageDir((long)idAgent);
		if (client.getIdStageDispo((long)idAgent).isEmpty()==true){ 

			ihmgstage.GererStageDir(null);
			return true;
									}
		else{
		System.out.println(stDir);
		HashMap<Long,String> st= new HashMap<Long,String>();
		for (long id : stDir ){
			System.out.println(id);
			StageDTO s= clientS.getStage(id);
			st.put(id, s.getTitle());
			System.out.println(s.getTitle());
								}
		
		ihmgstage.GererStageDir(st);
		
		return true;


}}
		
	
}
