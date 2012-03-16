
	package istic.sapfor.client.command.impl;

	import java.util.Collection;
	import java.util.HashMap;
	import java.util.LinkedList;

	import istic.sapfor.api.dto.AgentDTO;
	import istic.sapfor.api.dto.EtatCandidatureDTO;
	import istic.sapfor.api.service.ServiceAgent;
	import istic.sapfor.api.service.ServiceUv;
	import istic.sapfor.client.command.ICommand;
	import istic.sapfor.client.command.ICommandContext;
	import istic.sapfor.client.command.ICommandContextKey;
	import istic.sapfor.client.gui.IHMAdmin;


	public class AfficherRetenu implements ICommand {

		private ServiceAgent client;
		private ServiceUv clientU;
		public ServiceAgent getClient() {
			return client;
		}

		public void setClient(ServiceAgent client) {
			this.client = client;
		}

		private IHMAdmin ihmAdmin;
		
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
			String idTemp=ctx.get(ICommandContextKey.Key_Cand);
			
			int idUv=Integer.parseInt(idTemp);
			
			//probleme getCandidat rend une liste vide
			//Collection<Long> idRet =client.getIdCandidat((long)idUv, EtatCandidatureDTO.retenu);
			
			//test avec une liste non vide pour l'IHM
			//on ne peu pas tester si les onglets son pise en compte ou si il faut un listener
			Collection<Long> idRet=new LinkedList();
			idRet.add((long)1);
			idRet.add((long)3);
			idRet.add((long)5);
			idRet.add((long)6);
			System.out.println(idRet);
			if (idRet.isEmpty()==true){ 
				ihmAdmin.DisplayRetenu(null);
				return true;
										}
			else {
				System.out.println(idRet);
				HashMap<Long,String> ret = new HashMap<Long,String>();
				for (long id : idRet ){
					System.out.println(id);
					AgentDTO a= client.getAgent(id);
					String nom=a.getFirstName()+" "+a.getName();
					ret.put(id, nom);
					System.out.println(nom);
										}
				ihmAdmin.DisplayRetenu(ret);
				
				return true;
													}
														}
	}


