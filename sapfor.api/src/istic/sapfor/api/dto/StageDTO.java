package istic.sapfor.api.dto;

import java.util.Collection;

public class StageDTO {
	
	private long idStage;
	private Collection<Long> listIdUv;
	private String title;
	private String locality;
	
	public long getIdStage() {
		return idStage;
	}
	
	public void setIdStage(long idStage) {
		this.idStage = idStage;
	}
	
	public Collection<Long> getListIdUv() {
		return listIdUv;
	}
	
	public void setListIdUv(Collection<Long> listIdUv) {
		this.listIdUv = listIdUv;
	}
	
	public String getTitle() {
		return title;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}
	
	public String getLocality() {
		return locality;
	}
	
	public void setLocality(String locality) {
		this.locality = locality;
	}
	

}
