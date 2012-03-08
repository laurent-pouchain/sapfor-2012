package istic.sapfor.client.command.impl;
import istic.sapfor.api.dto.AgentDTO;


import java.util.LinkedList;
import java.util.List;

import istic.sapfor.api.service.ServiceAgent;
import istic.sapfor.client.command.ICommand;
import istic.sapfor.client.gui.IHM;

public class AfficherAgent implements ICommand {

	private ServiceAgent client;
	
	private IHM ihm ;
	
	@Override
	public Boolean execute() {
		//creer la liste
		
		
		
		List<AgentDTO> l = new LinkedList<AgentDTO>();
		for (int i=0;i<3;i++){
	    System.out.println("dans la boucle avant le getAgent");
	    long idAgent = (long)i;
		AgentDTO agt = client.getAgent((Long)idAgent);
		System.out.println("dans la boucle après le getAgent");
	     l.add(agt);
		}
		System.out.println("Liste remplie");
	 
	   //AgentDTO ag= new AgentDTO();
	   //ag.setName("pierre");
	   
	      //TODO
		//afficher (implémentée dans mainComtaineur)
		ihm.displayAgent(l);
		
		return true;
	}

	
	public ServiceAgent getClient() {
		return client;
	}

	public void setClient(ServiceAgent client) {
		this.client = client;
	}

	public IHM getIhm() {
		return ihm;
	}

	public void setIhm(IHM ihm) {
		this.ihm = ihm;
	}
	
	
	


}
