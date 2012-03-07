


package istic.sapfor.api.dto;

import java.io.Serializable;
import java.util.Collection;

public class AgentDTO implements Serializable {

private long idAgent;
private long idTypeAgent;
private Collection<Long> listIdUvOwned;
private String name;
private String firstName;



public long getIdAgent() {
	return idAgent;
}
public void setIdAgent(long idAgent) {
	this.idAgent = idAgent;
}
public long getIdTypeAgent() {
	return idTypeAgent;
}
public void setIdTypeAgent(long idTypeAgent) {
	this.idTypeAgent = idTypeAgent;
}
public Collection<Long> getListIdUvOwned() {
	return listIdUvOwned;
}
public void setListIdUvOwned(Collection<Long> listIdUvOwned) {
	this.listIdUvOwned = listIdUvOwned;
}
public String getFirstName() {
	return firstName;
}
public void setFirstName(String firstName) {
	this.firstName = firstName;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}

}
