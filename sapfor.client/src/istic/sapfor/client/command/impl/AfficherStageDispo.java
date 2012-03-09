package istic.sapfor.client.command.impl;

import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

import istic.sapfor.api.dto.AgentDTO;
import istic.sapfor.api.dto.StageDTO;
import istic.sapfor.api.service.ServiceAgent;
import istic.sapfor.client.command.ICommand;
import istic.sapfor.client.gui.IHM;

public class AfficherStageDispo implements ICommand {
	
	private ServiceAgent client;
	private IHM ihm ;
	
	@Override
	public Boolean execute() {
		//creer la liste
		
		//TODO recuperer l'id de l'agent (suite à sa connexion) pour pouvoir obtenir la liste des stages disponibles pour cet agent
		long idAgent = (long)0;			//à modifier
		
		Collection<Long> stDispo = client.getIdStageDispo((Long)idAgent);
		
	 
	   
	    
		//afficher (implémentée dans mainContaineur)
		
		//D"commenter la ligne du dessous quand displayStageDispo sera opérationnelle
		//ihm.displayStageDispo(stDispo);
		
		return true;
	}

}
