package istic.sapfor.client.command.impl;

import java.util.Collection;

import istic.sapfor.api.service.ServiceAgent;
import istic.sapfor.client.command.ICommand;
import istic.sapfor.client.gui.IHMGStage;

public class AfficherUvStage implements ICommand{
	
	private ServiceAgent client;
	private IHMGStage ihmgstage ;
	
	public Boolean execute(long idStage) {
		// TODO Auto-generated method stub
		long idAgent = (long)0;
		
		Collection<Long> uvDispo = client.getIdUvStageDispo(idAgent, idStage);
		
		//A décommenter une fois que displayUvDisp sera implémenté dans l'IHM
		//ihm.displayUvDisp(uvDispo);
		
		
		return true;
	}
	@Override
	public Boolean execute() {
		// TODO Auto-generated method stub
		return null;
	}

}
