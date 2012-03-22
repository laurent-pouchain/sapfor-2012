package istic.sapfor.client.command.impl;

import java.util.Collection;
import java.util.HashMap;
import istic.sapfor.api.dto.UvDTO;
import istic.sapfor.api.service.ServiceAgent;
import istic.sapfor.api.service.ServiceUv;
import istic.sapfor.client.command.ICommand;
import istic.sapfor.client.command.ICommandContext;
import istic.sapfor.client.command.ICommandContextKey;
import istic.sapfor.client.gui.IHMAdmin;


public class GestionStage implements ICommand {
	private ServiceAgent client;
	private ServiceUv clientU;
	private IHMAdmin ihmAdmin;

	public IHMAdmin getIhmAdmin() {
		return ihmAdmin;
	}

	public void setIhmAdmin(IHMAdmin ihmAdmin) {
		this.ihmAdmin = ihmAdmin;
	}

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

	@Override
	public Boolean execute(ICommandContext cont) {
		// TODO Auto-generated method stub

		String idStageTemp = cont.get(ICommandContextKey.Key_Stage);
		int idS = Integer.parseInt(idStageTemp);

		Collection<Long> UvDir = client.getIdUvStageDir((long) idS);
		if (client.getIdUvStageDir((long) idS).isEmpty() == true) {

			ihmAdmin.GererInscriptionUvDir(null,null,null);
			return true;
		} else {
			System.out.println(UvDir);
			HashMap<Long, String> uv = new HashMap<Long, String>();
			HashMap<Long, Boolean> uvClore = new HashMap<Long, Boolean>();
			HashMap<Long, Boolean> uvValide = new HashMap<Long, Boolean>();

			for (long id : UvDir) {
				System.out.println(id);
				UvDTO u = clientU.getUv(id);
				uvClore.put(id, u.isCandCloses());
				uvValide.put(id, u.isCandValids());
				uv.put(id, u.getTitle());
				System.out.println(u.getTitle());
			}

			ihmAdmin.GererInscriptionUvDir(uv,uvClore,uvValide);

			return true;

		}
	}

}
