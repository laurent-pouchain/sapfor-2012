package istic.sapfor.client.command.impl;

import istic.sapfor.api.service.ServiceAgent;
import istic.sapfor.client.command.ICommand;
import istic.sapfor.client.command.ICommandContext;
import istic.sapfor.client.command.ICommandContextKey;

public class SupprimerAgent extends ContextAbstract implements ICommand {

	private ServiceAgent client;


	@Override
	public Boolean execute(ICommandContext ctx) {
		String idAgent = ctx.get(ICommandContextKey.Key_Supp);
		int idAgentSupp = Integer.parseInt(idAgent);
		if ((long) idAgentSupp == context.getIdAgent()) {
			return false;
		} else {
			boolean effectue = client.delAgent((long) idAgentSupp);
			System.out.print("Suppression:" + effectue);
			return effectue;
		}
	}

	public ServiceAgent getClient() {
		return client;
	}

	public void setClient(ServiceAgent client) {
		this.client = client;
	}


}
