package istic.sapfor.client.command.impl;

import java.util.Collection;
import java.util.HashMap;

import istic.sapfor.api.dto.StageDTO;
import istic.sapfor.api.service.ServiceAgent;
import istic.sapfor.api.service.ServiceStage;
import istic.sapfor.client.command.ICommand;
import istic.sapfor.client.command.ICommandContext;
import istic.sapfor.client.gui.IHMGStage;

public class AfficherStageDispo implements ICommand {

	private ServiceStage clientS;
	private ServiceAgent client;
	private IHMGStage ihmgstage;
	private ICommandContext context;

	public ServiceStage getClientS() {
		return clientS;
	}

	public ICommandContext getContext() {
		return context;
	}

	public void setContext(ICommandContext context) {
		this.context = context;
	}

	public void setClientS(ServiceStage client) {
		this.clientS = client;
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

	@Override
	public Boolean execute(ICommandContext ctx) {

		long idAgent = context.getIdAgent();

		if (client.getIdStageDispo(idAgent) == null) {

			ihmgstage.displayStageDispo(null);
			return true;
		} else {
			Collection<Long> stDispo = client.getIdStageDispo(idAgent);
			System.out.println(stDispo);
			HashMap<Long, String> st = new HashMap<Long, String>();
			for (long id : stDispo) {
				System.out.println(id);
				StageDTO s = clientS.getStage(id);
				st.put(id, s.getTitle());
				System.out.println(s.getTitle());
			}

			ihmgstage.displayStageDispo(st);

			return true;

		}
	}
}
