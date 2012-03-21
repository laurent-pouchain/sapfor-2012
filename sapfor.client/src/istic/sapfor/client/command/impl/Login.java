package istic.sapfor.client.command.impl;

import java.util.List;

import istic.sapfor.api.dto.AgentDTO;
import istic.sapfor.api.dto.SessionDTO;
import istic.sapfor.api.service.ServiceAgent;
import istic.sapfor.api.service.ServiceSession;
import istic.sapfor.client.command.ICommand;
import istic.sapfor.client.command.ICommandContext;
import istic.sapfor.client.command.ICommandContextKey;
import istic.sapfor.client.gui.IHMGStage;

public class Login implements ICommand {
	private ServiceSession clientS;
	private IHMGStage ihmgstage;
	private ServiceAgent client;
	private ICommandContext context;

	public ICommandContext getContext() {
		return context;
	}

	public void setContext(ICommandContext context) {
		this.context = context;
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

	public ServiceSession getClientS() {
		return clientS;
	}

	public void setClientS(ServiceSession clientS) {
		this.clientS = clientS;
	}

	@Override
	public Boolean execute(ICommandContext ctx) {

		List<String> idLog = ctx.getList(ICommandContextKey.Key_login);
		System.out.println(idLog);

		String log = idLog.get(0);
		String pwd = idLog.get(1);
		System.out.println(log + " " + pwd);
		SessionDTO session = clientS.login(log, pwd);
		if (session == null) {
			ihmgstage.errorLogin();
		} else {
			System.out.println("Session: " + session);
			long idA = session.getIdAgent();
			System.out.print(idA + " ");
			AgentDTO ag = client.getAgent(idA);
			long typeAg = ag.getIdTypeAgent();
			String nameA = ag.getName();
			String fNameA = ag.getFirstName();
			System.out.println(nameA + " " + fNameA);
			context.setIdAgent(idA);
			ihmgstage.displayAccueilAgentSuccessfull(nameA, fNameA, typeAg);
		}
		return true;

	}
}
