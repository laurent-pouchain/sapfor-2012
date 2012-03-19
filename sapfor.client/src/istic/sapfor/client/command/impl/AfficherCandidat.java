package istic.sapfor.client.command.impl;

import java.util.Collection;
import java.util.HashMap;


import istic.sapfor.api.dto.AgentDTO;
import istic.sapfor.api.dto.EtatCandidatureDTO;
import istic.sapfor.api.service.ServiceAgent;
import istic.sapfor.api.service.ServiceUv;
import istic.sapfor.client.command.ICommand;
import istic.sapfor.client.command.ICommandContext;
import istic.sapfor.client.command.ICommandContextKey;
import istic.sapfor.client.gui.IHMAdmin;


public class AfficherCandidat implements ICommand {

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
		String idTemp=ctx.get(ICommandContextKey.Key_Cand);
		int idUv=Integer.parseInt(idTemp);
		
		Collection<Long> idCand =client.getIdCandidat((long)idUv, EtatCandidatureDTO.inscrit);
		Collection<Long> idRet =client.getIdCandidat((long)idUv, EtatCandidatureDTO.retenu);
		Collection<Long> idNonRet =client.getIdCandidat((long)idUv, EtatCandidatureDTO.nonRetenu);
		Collection<Long> idAtt =client.getIdCandidat((long)idUv, EtatCandidatureDTO.listeAttente);

		//test avec une liste non vide pour l'IHM
		//on ne peu pas tester si les onglets son pise en compte ou si il faut un listener
	
		
		System.out.println("idCand"+idCand);
		System.out.println("idRet"+idRet);
		System.out.println("idNonRet"+idNonRet);
		System.out.println("idAtt"+idAtt);
		//j'ai divisé le bloc en 4 méthodes pour la lisibilité
		
		if (idCand==null){ 

			ihmAdmin.DisplayCandidat(idTemp,null);
			retenu(idTemp, idRet,idNonRet,idAtt);}
			else { 			

				System.out.println(idCand);
				HashMap<Long,String> cand = new HashMap<Long,String>();
				for (long id : idCand ){
					System.out.println(id);
					AgentDTO a= client.getAgent(id);
					String nom=a.getFirstName()+" "+a.getName();
					cand.put(id, nom);
					System.out.println(nom);}
				ihmAdmin.DisplayCandidat(idTemp, cand);
				retenu(idTemp, idRet,idNonRet,idAtt);}
		
			
	return true;
	}
	
	
	
	void retenu(String idTemp, Collection<Long> idRet,Collection<Long> idNonRet,Collection<Long> idAtt){
		if (idRet==null){ 
			ihmAdmin.DisplayRetenu(idTemp,null);
			nonRetenu(idTemp, idNonRet,idAtt);}
			else {
				System.out.println(idRet);
				HashMap<Long,String> ret = new HashMap<Long,String>();
				for (long id : idRet ){
					System.out.println(id);
					AgentDTO a= client.getAgent(id);
					String nom=a.getFirstName()+" "+a.getName();
					ret.put(id, nom);
					System.out.println(nom);}
				ihmAdmin.DisplayRetenu(idTemp,ret);
			
				nonRetenu(idTemp, idNonRet,idAtt);	}
			}
		
	void nonRetenu(String idTemp, Collection<Long> idNonRet, Collection<Long> idAtt){	
		if (idNonRet==null){ 
			ihmAdmin.DisplayNonRetenu(idTemp, null);
			ListeDa(idTemp, idAtt);	}
			else {
				System.out.println(idNonRet);
				HashMap<Long,String> nonRet = new HashMap<Long,String>();
				for (long id : idNonRet ){
					System.out.println(id);
					AgentDTO a= client.getAgent(id);
					String nom=a.getFirstName()+" "+a.getName();
					nonRet.put(id, nom);
					System.out.println(nom);}
				ihmAdmin.DisplayNonRetenu(idTemp, nonRet);
				ListeDa(idTemp, idAtt);}
														}
		
	void ListeDa(String idTemp, Collection<Long> idAtt){
		if (idAtt==null){ 
			ihmAdmin.DisplayListA(idTemp, null);}
			else {
				System.out.println(idAtt);
				HashMap<Long,String> att = new HashMap<Long,String>();
				for (long id : idAtt ){
					System.out.println(id);
					AgentDTO a= client.getAgent(id);
					String nom=a.getFirstName()+" "+a.getName();
					att.put(id, nom);
					System.out.println(nom);}
				ihmAdmin.DisplayListA(idTemp,att);}
												}
		
	


}

