package istic.sapfor.client.command.impl;

import istic.sapfor.api.service.ServiceUv;
import istic.sapfor.client.command.ICommand;
import istic.sapfor.client.command.ICommandContext;
import istic.sapfor.client.command.ICommandContextKey;


public class CloreUv implements ICommand {


	private ServiceUv clientU;
	

	public ServiceUv getClientU() {
		return clientU;
	}

	public void setClientU(ServiceUv clientU) {
		this.clientU = clientU;
	}


	
	@Override
	public Boolean execute(ICommandContext ctx) {
		boolean effectif=false;
		String Temp=ctx.get(ICommandContextKey.Key_Clor);
		Integer idUv=Integer.parseInt(Temp);
		effectif=clientU.setCandCloses((long)idUv);
		if (effectif){ return true;}
		else {return false;}
		}

}
