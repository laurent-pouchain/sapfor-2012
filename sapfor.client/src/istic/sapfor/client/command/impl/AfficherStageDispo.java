package istic.sapfor.client.command.impl;

import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

import istic.sapfor.api.dto.AgentDTO;
import istic.sapfor.api.dto.StageDTO;
import istic.sapfor.api.service.ServiceAgent;
import istic.sapfor.api.service.ServiceStage;
import istic.sapfor.client.command.ICommand;
import istic.sapfor.client.command.ICommandContext;
import istic.sapfor.client.command.ICommandContextKey;
import istic.sapfor.client.gui.IHMGStage;

public class AfficherStageDispo implements ICommand {
	
	private ServiceStage clientS;
	private ServiceAgent client;
	private IHMGStage ihmgstage ;
	
	public ServiceStage getClientS() {
		return clientS;
	}

	public void setClientS(ServiceStage client) {
		this.clientS = client;
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

	@Override
	public Boolean execute(ICommandContext ctx) {
		//creer la liste
		
		//TODO recuperer l'id de l'agent (suite à sa connexion) pour pouvoir obtenir la liste des stages disponibles pour cet agent
		//long idAgent = (long)0;			//à modifier
		String idA=ctx.get(ICommandContextKey.Key_Agent);
		int idAgent;
		idAgent= Integer.parseInt(idA); 
		Collection<Long> stDispo = client.getIdStageDispo((long)idAgent);
		if (client.getIdStageDispo((long)idAgent).isEmpty()==true){ 
			ihmgstage.displayStageDispo(null);
			return true;
									}
		else{
		System.out.println(stDispo);
		HashMap<Long,String> st= new HashMap<Long,String>();
		for (long id : stDispo ){
			System.out.println(id);
			StageDTO s= clientS.getStage(id);
			st.put(id, s.getTitle());
			System.out.println(s.getTitle());
								}
		
		ihmgstage.displayStageDispo(st);
		
		return true;


}}
}
