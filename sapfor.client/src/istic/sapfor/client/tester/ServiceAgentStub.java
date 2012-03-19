package istic.sapfor.client.tester;

import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

import istic.sapfor.api.dto.AgentDTO;
import istic.sapfor.api.dto.EtatCandidatureDTO;
import istic.sapfor.api.dto.StageDTO;

public class ServiceAgentStub implements istic.sapfor.api.service.ServiceAgent {

private List<AgentDTO> l;


public List<AgentDTO> getL() {
	return l;
}

public void setL(List<AgentDTO> l) {
	this.l = l;
}

public ServiceAgentStub(){
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



public void ajout(List<String> l) {
	AgentDTO agt= new AgentDTO ();
	agt.setFirstName(l.get(0));
	agt.setName(l.get(1));
	System.out.println(agt.getFirstName());
	System.out.println(" ");
	System.out.println(agt.getName());
}

@Override
//a implémenter pour les tests
public Collection<Long> getIdStageDispo(Long idAgent) {
	// TODO Auto-generated method stub
	return null;
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


public boolean setStatut(Long idUv, Long idCandidat, EtatCandidatureDTO etat) {
	// TODO Auto-generated method stub
	return false;
}

@Override
public boolean setStatut(Long idUv, Long idCandidat,
		EtatCandidatureDTO nouvelEtat, EtatCandidatureDTO ancienEtat) {
	// TODO Auto-generated method stub
	return false;
}

@Override
public Collection<Long> getIdCandidat(Long idUv, EtatCandidatureDTO etat) {
	// TODO Auto-generated method stub
	return null;
}

@Override
public Collection<Long> getIdStageInscrit(Long idAgent) {
	// TODO Auto-generated method stub
	return null;
}

@Override
public Collection<Long> getIdUvStageInscrit(Long idAgent, Long idStage) {
	// TODO Auto-generated method stub
	return null;
}

@Override
public Collection<Long> getAllIdsAgent(Long idDirecteur) {
	// TODO Auto-generated method stub
	return null;
}

@Override
public boolean addAgent(AgentDTO agent) {
	// TODO Auto-generated method stub
	return false;
}

@Override
public boolean delAgent(Long idAgent) {
	// TODO Auto-generated method stub
	return false;
}



}