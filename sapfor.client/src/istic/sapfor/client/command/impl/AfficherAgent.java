package istic.sapfor.client.command.impl;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import istic.sapfor.api.dto.AgentDTO;

import istic.sapfor.api.service.ServiceAgent;
import istic.sapfor.client.command.ICommand;
import istic.sapfor.client.command.ICommandContext;
import istic.sapfor.client.gui.IHMGStage;

public class AfficherAgent implements ICommand {

	private ServiceAgent client;
	//j'ai mis IHMGStage mais il faudra remplacer par L'IHMAgent et dans le sapfor.xml aussi (juste le name="ihmgstage")
	private IHMGStage ihmgstage ;
	private ICommandContext context;
	
	
	

	@Override
	public Boolean execute(ICommandContext ctx) {//rien a envoyer dans le ctx
		Long idDir=context.getIdAgent();
		Collection<Long> idAgent=client.getAllIdsAgent(idDir);
		Map<Long,String> NomAgent=new HashMap<Long,String>();
		for (long id : idAgent ){
			System.out.println(id);
			AgentDTO a= client.getAgent(id);
			String prenomNom=a.getFirstName()+"  "+a.getName();
			NomAgent.put(id, prenomNom);
		}
		//j'envoie une hash map avec en clé l'id de l'agent et en valeur une string avec prenom nom				
		//la methode displayAgent a mettre dans le cotainerGestion agent et dans l'interface qu'il implemente
		
		ihmgstage.displayAgent(NomAgent);
		
		return null;
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


	public ICommandContext getContext() {
		return context;
	}


	public void setContext(ICommandContext context) {
		this.context = context;
	}

}
