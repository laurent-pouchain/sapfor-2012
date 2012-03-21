package istic.sapfor.client.gui.sapforcomponent;


import java.awt.Color;
import javax.swing.JPanel;
import javax.swing.border.BevelBorder;


public class SapforListeCandidat  extends JPanel {
	
private SapforButton inscrit;	
private SapforButton retenu;
private SapforButton lstDa;
private SapforButton refuse;
	
	public SapforListeCandidat (String titre) {
		super();
				SapforLabel titr=new SapforLabel(titre);
		this.add(titr);
	
		this.setBorder(new javax.swing.border.BevelBorder(BevelBorder.RAISED));
		inscrit=new SapforButton("inscrit");
		retenu=new SapforButton("retenu");
		lstDa=new SapforButton("liste d'attente");
		refuse=new SapforButton("non retenu");
		this.add(inscrit);
		this.add(retenu);
		this.add(lstDa);
		this.add(refuse);
		
	}

	public SapforListeCandidat (String titre, Color c) {
		super();
		SapforLabel titr=new SapforLabel(titre);
		this.add(titr);
		//this.setEditable(false);
		this.setBorder(new javax.swing.border.BevelBorder(BevelBorder.RAISED));
		this.setBackground(c);
		inscrit=new SapforButton("inscrit");
		retenu=new SapforButton("retenu");
		lstDa=new SapforButton("liste d'attente");
		refuse=new SapforButton("non retenu");
		this.add(inscrit);
		this.add(retenu);
		this.add(lstDa);
		this.add(refuse);
	}
	
	public SapforButton getInscrit() {
		return inscrit;
	}
	public void setInscrit(SapforButton inscrit) {
		this.inscrit = inscrit;
	}
	public SapforButton getRetenu() {
		return retenu;
	}
	public void setRetenu(SapforButton retenu) {
		this.retenu = retenu;
	}
	public SapforButton getLstDa() {
		return lstDa;
	}
	public void setLstDa(SapforButton lstDa) {
		this.lstDa = lstDa;
	}
	public SapforButton getRefuse() {
		return refuse;
	}
	public void setRefuse(SapforButton refuse) {
		this.refuse = refuse;
	}
	
	
}
