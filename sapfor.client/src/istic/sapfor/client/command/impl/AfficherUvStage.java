package istic.sapfor.client.command.impl;

import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;


import istic.sapfor.api.dto.UvDTO;
import istic.sapfor.api.service.ServiceAgent;
import istic.sapfor.api.service.ServiceUv;
import istic.sapfor.client.command.ICommand;
import istic.sapfor.client.command.ICommandContext;
import istic.sapfor.client.command.ICommandContextKey;
import istic.sapfor.client.gui.IHMGStage;


public class AfficherUvStage implements ICommand{
	
	private ServiceUv clientU;
	private ServiceAgent client;
	private IHMGStage ihmgstage ;
	private ICommandContext context;
	
	public ICommandContext getContext() {
		return context;
	}
	public void setContext(ICommandContext context) {
		this.context = context;
	}
	public Boolean execute(ICommandContext ctx) {
		// TODO Auto-generated method stub

	//récuperation des id
		List<String> idTemp=new LinkedList<String>();
		idTemp=ctx.getList(ICommandContextKey.Key_Stage);
	
			String idSt=idTemp.get(0);
			//System.out.print(idSt+ "ID STAGE ");
			//String idAg=idTemp.get(1);
			//System.out.println(idAg+" ID AGENT");
		long idAgent=context.getIdAgent();
		int idStage= Integer.parseInt(idSt); 
		
		Collection<Long> uvDispo = client.getIdUvStageDispo(idAgent,(long)idStage);
		if (client.getIdUvStageDispo(idAgent,(long)idStage).isEmpty()==true)
		{	ihmgstage.displayUvDispo(null);
			return true;
		
		}
		
		else{
			System.out.println(uvDispo);
			HashMap<Long,String> uv= new HashMap<Long,String>();
			for (long id : uvDispo ){
				System.out.println(id);
				UvDTO suv= clientU.getUv(id);
				uv.put(id, suv.getTitle());
				System.out.println(suv.getTitle());
								}
		
		ihmgstage.displayUvDispo(uv);
		return true;
			}
		
	}
	public ServiceUv getClientU() {
		return clientU;
	}
	public void setClientU(ServiceUv clientU) {
		this.clientU = clientU;
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


}
