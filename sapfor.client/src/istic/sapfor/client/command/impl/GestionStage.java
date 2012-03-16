package istic.sapfor.client.command.impl;

import java.util.Collection;
import java.util.HashMap;

import istic.sapfor.api.dto.StageDTO;
import istic.sapfor.api.service.ServiceAgent;
import istic.sapfor.api.service.ServiceStage;
import istic.sapfor.client.command.ICommand;
import istic.sapfor.client.command.ICommandContext;
import istic.sapfor.client.command.ICommandContextKey;
import istic.sapfor.client.gui.IHMAdmin;
import istic.sapfor.client.gui.IHMGStage;

public class GestionStage implements ICommand{
	private ServiceAgent client;
	private ServiceStage clientS;
	private IHMAdmin ihmAdmin;
	private ICommandContext context;
	
	public IHMAdmin getIhmAdmin() {
		return ihmAdmin;
	}
	public void setIhmAdmin(IHMAdmin ihmAdmin) {
		this.ihmAdmin = ihmAdmin;
	}

	public ICommandContext getContext() {
		return context;
	}
	public void setContext(ICommandContext context) {
		this.context = context;
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
		ctx.get(ICommandContextKey.Key_Agent);
		long idAgent=context.getIdAgent();
		Collection<Long> stDir = client.getIdStageDir(idAgent);
		if (client.getIdStageDispo(idAgent).isEmpty()==true){ 

			ihmAdmin.GererStageDir(null);
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
		
		ihmAdmin.GererStageDir(st);
		
		return true;


}}
		
	
}
