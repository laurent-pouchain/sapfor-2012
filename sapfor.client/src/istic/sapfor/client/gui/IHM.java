package istic.sapfor.client.gui;
import java.util.List;
import istic.sapfor.api.dto.AgentDTO;

public interface IHM {
	
	
public void displayAgent(List<AgentDTO> agentlist);
public List<String> addAgent();
}
