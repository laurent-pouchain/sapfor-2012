package istic.sapfor.client.command.impl;
import istic.sapfor.api.dto.AgentDTO;


import java.util.LinkedList;
import java.util.List;

import istic.sapfor.api.service.ServiceAgent;
import istic.sapfor.client.command.ICommand;
import istic.sapfor.client.gui.IHM;

public class AjouterAgent implements ICommand {

	private ServiceAgent client;
	
	private IHM ihm ;
	
	@Override
	public Boolean execute() {
		
		List<String> l= ihm.addAgent();
//        client.ajout(l);
	  //créer un agent
		/*AgentDTO agt= new AgentDTO ();
		agt.setFirstName(l.get(0));
		agt.setName(l.get(1));
		System.out.println(agt.getFirstName());
		System.out.println(" ");
		System.out.println(agt.getName());*/
		
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

