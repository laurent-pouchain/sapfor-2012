package istic.sapfor.api.dto;

import java.io.Serializable;

@SuppressWarnings("serial")
public class SessionDTO implements Serializable{


	private long idAgent;

	public long getIdAgent() {
		return idAgent;
	}

	public void setIdAgent(long idAgent) {
		this.idAgent = idAgent;
	}
	
	public boolean equals(Object o) {
		if (o == null){return (this == null);}
		if (o.getClass() == this.getClass()){
			return (this.idAgent == ((SessionDTO)o).idAgent);
		}
		else return false;
	}
}
