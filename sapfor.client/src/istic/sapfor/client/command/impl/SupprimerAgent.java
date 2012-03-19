package istic.sapfor.client.command.impl;

import istic.sapfor.api.service.ServiceAgent;
import istic.sapfor.client.command.ICommand;
import istic.sapfor.client.command.ICommandContext;
import istic.sapfor.client.command.ICommandContextKey;


public class SupprimerAgent implements ICommand {

	private ServiceAgent client;
	private ICommandContext context;
	@Override
	public Boolean execute(ICommandContext ctx) {
	//ctx doit contenir un string, celui de l'agent a supprimer
		String idAgent=ctx.get(ICommandContextKey.Key_Supp);
		int idAgentSupp=Integer.parseInt(idAgent);
		if ((long)idAgentSupp==context.getIdAgent()){ return false;}
		else {
			boolean effectue=client.delAgent((long)idAgentSupp);
			return effectue;
		//	je te renvoie juste le boolean de execute donc pas besoin d'injection de dépendance avec ihmagent
		// en fonction du booleen  un petite fenetre de confirmation classique 
				}
											}
	
	
	public ServiceAgent getClient() {
		return client;
	}
	public void setClient(ServiceAgent client) {
		this.client = client;
	}
	public ICommandContext getContext() {
		return context;
	}
	public void setContext(ICommandContext context) {
		this.context = context;
	}

}
