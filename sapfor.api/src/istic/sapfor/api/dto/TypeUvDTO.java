package istic.sapfor.api.dto;

import java.util.Collection;

public class TypeUvDTO {

	private long idTypeUv;
	private String title;
	private Collection<Long> listIdUvPrereq;
	private int effectifMax;
	private int effectifMin;
	

	public long getIdTypeUv() {
		return idTypeUv;
	}
	public void setIdTypeUv(long idTypeUv) {
		this.idTypeUv = idTypeUv;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public Collection<Long> getListIdUvPrereq() {
		return listIdUvPrereq;
	}
	public void setListIdUvPrereq(Collection<Long> listIdUvPrereq) {
		this.listIdUvPrereq = listIdUvPrereq;
	}
	public int getEffectifMax() {
		return effectifMax;
	}
	public void setEffectifMax(int effectifMax) {
		this.effectifMax = effectifMax;
	}
	public int getEffectifMin() {
		return effectifMin;
	}
	public void setEffectifMin(int effectifMin) {
		this.effectifMin = effectifMin;
	}

	
}
