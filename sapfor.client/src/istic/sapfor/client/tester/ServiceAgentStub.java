package istic.sapfor.client.tester;

import java.util.LinkedList;
import java.util.List;

import istic.sapfor.api.dto.AgentDTO;

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
public AgentDTO getAgent(long id) {
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

}