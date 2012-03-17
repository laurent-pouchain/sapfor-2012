package istic.sapfor.client.command.impl;

import java.util.LinkedList;
import java.util.List;

import istic.sapfor.api.service.ServiceAgent;
import istic.sapfor.client.command.ICommand;
import istic.sapfor.client.command.ICommandContext;
import istic.sapfor.client.command.ICommandContextKey;
import istic.sapfor.client.gui.IHMGStage;

public class AddInscription implements ICommand {

	private ServiceAgent client;
	private IHMGStage ihmgstage ;
	private ICommandContext context;
	
	@Override
	public Boolean execute(ICommandContext ctx) {
		//en attandant le loggin
		
		
		List<String> idUvTemp=new LinkedList<String>();
		List<Long> idUv=new LinkedList<Long>();
		String temp; Integer id; 
		
		idUvTemp=ctx.getList(ICommandContextKey.Key_Insct);
		long idAgent=context.getIdAgent();
		
		System.out.println(idAgent+" ID agent qui veut s'inscrire");
		for (int i=0;i<idUvTemp.size();i++){
			temp=idUvTemp.get(i);
			id= Integer.parseInt(temp); 
			System.out.println(temp+" id de UV validée");
			idUv.add((long)id);	
											}
		if (client.addInscrip( idAgent,idUv)==true){System.out.println("inscription ok"); return true; }
		else {System.out.println("echec de l'inscription"); return false;}
		
		
		
		
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
