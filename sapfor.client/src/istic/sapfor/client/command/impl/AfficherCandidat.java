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


public class AfficherCandidat implements ICommand {

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
		//Collection<Long> idCand client.getIdCandidat((long)idUv, EtatCandidatureDTO.inscrit);
		//Collection<Long> idRet =client.getIdCandidat((long)idUv, EtatCandidatureDTO.retenu);
		//test avec une liste non vide pour l'IHM
		//on ne peu pas tester si les onglets son pise en compte ou si il faut un listener
		Collection<Long> idCand=new LinkedList();
		idCand.add((long)1);
		idCand.add((long)3);
		idCand.add((long)5);
		idCand.add((long)6);
		System.out.println(idCand);
		Collection<Long> idRet=new LinkedList();
		idRet.add((long)1);
		idRet.add((long)2);
		idRet.add((long)4);
		idRet.add((long)7);
		System.out.println(idRet);
		Collection<Long> idNonRet=new LinkedList();
		idNonRet.add((long)0);
		idNonRet.add((long)3);
		idNonRet.add((long)8);
		idNonRet.add((long)6);
		System.out.println(idNonRet);
		Collection<Long> idAtt=new LinkedList();
		idAtt.add((long)1);
		idAtt.add((long)3);
		idAtt.add((long)5);
		idAtt.add((long)6);
		System.out.println(idAtt);
		
		
		
		if (idCand.isEmpty()==true){ 
			ihmAdmin.DisplayCandidat(null);}
		else {
			System.out.println(idCand);
			HashMap<Long,String> cand = new HashMap<Long,String>();
			for (long id : idCand ){
				System.out.println(id);
				AgentDTO a= client.getAgent(id);
				String nom=a.getFirstName()+" "+a.getName();
				cand.put(id, nom);
				System.out.println(nom);}
			ihmAdmin.DisplayCandidat(cand);}
		
						
		if (idRet.isEmpty()==true){ 
			ihmAdmin.DisplayRetenu(null);}
		else {
			System.out.println(idRet);
			HashMap<Long,String> ret = new HashMap<Long,String>();
			for (long id : idRet ){
				System.out.println(id);
				AgentDTO a= client.getAgent(id);
				String nom=a.getFirstName()+" "+a.getName();
				ret.put(id, nom);
				System.out.println(nom);}
			ihmAdmin.DisplayRetenu(ret);}
		
		if (idNonRet.isEmpty()==true){ 
			ihmAdmin.DisplayNonRetenu(null);}
		else {
			System.out.println(idNonRet);
			HashMap<Long,String> nonRet = new HashMap<Long,String>();
			for (long id : idNonRet ){
				System.out.println(id);
				AgentDTO a= client.getAgent(id);
				String nom=a.getFirstName()+" "+a.getName();
				nonRet.put(id, nom);
				System.out.println(nom);}
			ihmAdmin.DisplayNonRetenu(nonRet);}
	
		if (idAtt.isEmpty()==true){ 
			ihmAdmin.DisplayListA(null);}
		else {
			System.out.println(idAtt);
			HashMap<Long,String> att = new HashMap<Long,String>();
			for (long id : idAtt ){
				System.out.println(id);
				AgentDTO a= client.getAgent(id);
				String nom=a.getFirstName()+" "+a.getName();
				att.put(id, nom);
				System.out.println(nom);}
			ihmAdmin.DisplayListA(att);}
	
	return true;
	
	}
}
