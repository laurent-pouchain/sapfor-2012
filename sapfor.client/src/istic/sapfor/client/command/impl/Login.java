package istic.sapfor.client.command.impl;

import java.util.Collection;
import java.util.HashMap;


import istic.sapfor.api.dto.AgentDTO;
import istic.sapfor.api.dto.SessionDTO;
import istic.sapfor.api.dto.UvDTO;
import istic.sapfor.api.service.ServiceAgent;
import istic.sapfor.api.service.ServiceSession;
import istic.sapfor.client.command.ICommand;
import istic.sapfor.client.command.ICommandContext;
import istic.sapfor.client.command.ICommandContextKey;
import istic.sapfor.client.gui.IHMGStage;

public class Login implements ICommand {
	private ServiceSession clientS;
	private IHMGStage ihmgstage ;
	private ServiceAgent client;
	
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
	public ServiceSession getClientS() {
		return clientS;
	}
	public void setClientS(ServiceSession clientS) {
		this.clientS = clientS;
	}
	@Override
	public Boolean execute(ICommandContext ctx) {
		long idAgent = (long)0;
		
		String idLog=ctx.get(ICommandContextKey.Key_login);
		
		String[] result = idLog.split("*");
		String log=result[0];
		String pwd=result[1];
		
		SessionDTO session = clientS.login(log, pwd);
		System.out.println(session);
		long idA = session.getIdAgent();
		AgentDTO ag = client.getAgent(idA);
		String nameA=ag.getName();
		String fNameA=ag.getFirstName();
		ihmgstage.displayAccueilAgent(nameA,fNameA,idA);
		return true;
	}

}
