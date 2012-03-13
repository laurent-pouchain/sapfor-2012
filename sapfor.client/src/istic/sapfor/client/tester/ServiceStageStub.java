package istic.sapfor.client.tester;

import istic.sapfor.api.dto.AgentDTO;
import istic.sapfor.api.dto.EtatCandidatureDTO;
import istic.sapfor.api.dto.StageDTO;
import istic.sapfor.api.dto.UvDTO;

import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

public class ServiceStageStub implements istic.sapfor.api.service.ServiceAgent, istic.sapfor.api.service.ServiceStage {

	private List<StageDTO> ls;
	private List<AgentDTO> l;

	
	public List<StageDTO> getLs() {
		return ls;
	}

	public void setLs(List<StageDTO> ls) {
		this.ls = ls;
	}


	public List<AgentDTO> getL() {
		return l;
	}

	public void setL(List<AgentDTO> l) {
		this.l = l;
	}

	public ServiceStageStub(){
	l=new LinkedList<AgentDTO>();
	AgentDTO agt = new AgentDTO();
	AgentDTO ag1 = new AgentDTO();
	AgentDTO ag2 = new AgentDTO();
	agt.setName("paul");
	ag1.setName("rico");
	ag2.setName("nono");
	agt.setFirstName("erolti");
	ag1.setFirstName("erolti");
	ag2.setFirstName("erolti");
	agt.setIdAgent(0);
	ag1.setIdAgent(1);
	ag2.setIdAgent(2);
	l.add(agt);
	l.add(ag1);
	l.add(ag2);
	ls=new LinkedList<StageDTO>();
	StageDTO s1 = new StageDTO();
	StageDTO s2 = new StageDTO();
	StageDTO s3 = new StageDTO();
	s1.setTitle("stage1");
	s2.setTitle("stage2");
	s3.setTitle("stage3");
	s1.setIdStage(0);
	s1.setIdStage(1);
	s1.setIdStage(2);
	UvDTO uv1= new UvDTO();
	uv1.setTitle("foret");
	uv1.setIdUv(1);
	Collection<Long> luv=new LinkedList<Long>();
	luv.add(uv1.getIdUv());
	s1.setListIdUv(luv);
    agt.setListIdUvOwned(luv);
		}
	
	
	@Override
	public AgentDTO getAgent(Long id) {
		// TODO Auto-generated method stub
		boolean find=false;
		AgentDTO aux=null;
		for(int i=0;i<l.size();i++){
			
		if(l.get(i).getIdAgent()==id) { find=true;  aux=l.get(i);}						
									}
		return aux;
									}

	@Override
	public StageDTO getStage(long id) {
		// TODO Auto-generated method stub
		boolean find=false;
		StageDTO aux=null;
		for(int i=0;i<ls.size();i++){
			
		if(ls.get(i).getIdStage()==id) { find=true;  aux=ls.get(i);}						
									}
		return aux;
									}
// a implémenter
	@Override
	public Collection<Long> getIdStageDispo(Long idAgent) {
		// TODO Auto-generated method stub
		Collection<Long> lus=new LinkedList<Long>();
		Collection<Long> lis=new LinkedList<Long>();
		
		lus=l.get((0)).getListIdUvOwned();
		lis.add (ls.get(0).getIdStage());
	    return lis;
		
		
	}

	@Override
	public Collection<Long> getIdUvStageDispo(Long idAgent, Long idStage) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean addInscrip(Long idAgent, Collection<Long> idsUv) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Collection<Long> getIdStageDir(Long idAgent) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Collection<Long> getIdUvStageDir(Long idStage) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Collection<Long> getIdCandidat(Long idUv) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean setStatut(Long idUv, Long idCandidat,
			EtatCandidatureDTO nouvelEtat, EtatCandidatureDTO ancienEtat) {
		// TODO Auto-generated method stub
		return false;
	}

}
