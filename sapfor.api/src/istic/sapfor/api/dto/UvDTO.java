package istic.sapfor.api.dto;

import java.util.Collection;
import java.util.Date;

public class UvDTO {
	
	private long idUv;
	private String title;
	private long idTypeUv;
	private String locality;
	private Collection<Date> dates;
	private Date dateLimite;
	
	
	public long getIdUv() {
		return idUv;
	}
	public void setIdUv(long idUv) {
		this.idUv = idUv;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public long getIdTypeUv() {
		return idTypeUv;
	}
	public void setIdTypeUv(long idTypeUv) {
		this.idTypeUv = idTypeUv;
	}
	public String getLocality() {
		return locality;
	}
	public void setLocality(String locality) {
		this.locality = locality;
	}
	public Collection<Date> getDates() {
		return dates;
	}
	public void setDates(Collection<Date> dates) {
		this.dates = dates;
	}
	public Date getDateLimite() {
		return dateLimite;
	}
	public void setDateLimite(Date dateLimite) {
		this.dateLimite = dateLimite;
	}


}
