package istic.sapfor.client.command.impl;

import java.util.LinkedList;
import java.util.List;

import istic.sapfor.api.dto.EtatCandidatureDTO;
import istic.sapfor.api.service.ServiceAgent;
import istic.sapfor.api.service.ServiceUv;
import istic.sapfor.client.command.ICommand;
import istic.sapfor.client.command.ICommandContext;
import istic.sapfor.client.command.ICommandContextKey;
import istic.sapfor.client.gui.IHMAdmin;

public class TraitementCandidat implements ICommand {

	private ServiceAgent client;
	private ServiceUv clientU;
	private IHMAdmin ihmAdmin;
	
	
	
	public ServiceAgent getClient() {
		return client;
	}



	public void setClient(ServiceAgent client) {
		this.client = client;
	}



	public ServiceUv getClientU() {
		return clientU;
	}



	public void setClientU(ServiceUv clientU) {
		this.clientU = clientU;
	}



	public IHMAdmin getIhmAdmin() {
		return ihmAdmin;
	}



	public void setIhmAdmin(IHMAdmin ihmAdmin) {
		this.ihmAdmin = ihmAdmin;
	}



	@Override
	public Boolean execute(ICommandContext ctx) {
		boolean effectif=false;
		List<String> Temp=new LinkedList<String>();
		Temp=ctx.getList(ICommandContextKey.Key_Insct);
		Integer idUv=Integer.parseInt(Temp.get(0));
		Integer idCand=Integer.parseInt(Temp.get(1));
		String nouvelEtat=Temp.get(2);
	    String ancienEtat=Temp.get(3);
	    effectif= client.setStatut((long)idUv,(long)idCand,EtatCandidatureDTO.valueOf(nouvelEtat),EtatCandidatureDTO.valueOf(ancienEtat));
		if (effectif==true) {
        System.out.println("avant l'affichage");
        ihmAdmin.Rafraichir(idUv);
        	return true;}
		else {	return false;}
							
	}
}
