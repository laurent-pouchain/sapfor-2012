package istic.sapfor.client.command.impl;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import istic.sapfor.api.dto.AgentDTO;

import istic.sapfor.api.service.ServiceAgent;
import istic.sapfor.client.command.ICommand;
import istic.sapfor.client.command.ICommandContext;
import istic.sapfor.client.gui.IHMAgent;

public class AfficherAgent extends ContextAbstract implements ICommand {

	private ServiceAgent client;
	private IHMAgent ihmagent;

	@Override
	public Boolean execute(ICommandContext ctx) {// rien a envoyer dans le ctx
		Long idDir = context.getIdAgent();
		Collection<Long> idAgent = client.getAllIdsAgent(idDir);
		Map<Long, String> NomAgent = new HashMap<Long, String>();
		System.out.print(idAgent);
		for (long id : idAgent) {
			System.out.println(id);
			AgentDTO a = client.getAgent(id);
			String prenomNom = a.getFirstName() + "  " + a.getName();
			NomAgent.put(id, prenomNom);
		}
		// j'envoie une hash map avec en cl� l'id de l'agent et en valeur une
		// string avec prenom nom
		// la methode displayAgent a mettre dans le cotainerGestion agent et
		// dans l'interface qu'il implemente

		System.out.println(NomAgent);
		ihmagent.displayAgent(NomAgent);

		return null;
	}

	

	public ServiceAgent getClient() {
		return client;
	}

	public void setClient(ServiceAgent client) {
		this.client = client;
	}



	public IHMAgent getIhmagent() {
		return ihmagent;
	}

	public void setIhmagent(IHMAgent ihmagent) {
		this.ihmagent = ihmagent;
	}

}
