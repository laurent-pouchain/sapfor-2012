package istic.sapfor.api.dto;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;

@SuppressWarnings("serial")
public class UvDTO implements Serializable {
	
	private long idUv;
	private String title;
	private long idTypeUv;
	private String locality;
	private Collection<Date> dates;
	private Date dateLimite;
	private boolean candCloses;
	private boolean candValids;
	
	public UvDTO(){
		candCloses = false;
		candValids = false;
	}
	
	
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
	public boolean isCandCloses() {
		return candCloses;
	}
	public void setCandCloses(boolean candCloses) {
		this.candCloses = candCloses;
	}
	public boolean isCandValids() {
		return candValids;
	}
	public void setCandValids(boolean candValids) {
		this.candValids = candValids;
	}


}
