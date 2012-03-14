package istic.sapfor.client.gui;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.LayoutManager;


import javax.swing.JPanel;
import javax.swing.border.BevelBorder;

public class SapforListeStage extends JPanel {
	private SapforButton btu;
	private SapforLabel stage;
	
	
	public SapforListeStage(String titre) {
		super();   
		 stage=new SapforLabel(titre);
		btu= new SapforButton("liste UV");
		this.setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		    gbc.weightx = 1;
		    gbc.weighty = 1;
		    gbc.ipadx = 2;
		    gbc.ipady = 2;
		    
		    gbc.gridx = 0;
		    gbc.gridwidth = 1;
		    gbc.gridheight = 1;
		    gbc.gridy = 0;
		    this.add(stage,gbc);
		   
		    gbc.gridx = 1;
		    gbc.gridwidth = 1;
		    gbc.gridheight = 1;
		    gbc.gridy = 0;
		    this.add(btu,gbc);
		this.setBorder(new javax.swing.border.BevelBorder(BevelBorder.RAISED));
		this.add(stage);
		this.add(btu);
		// TODO Auto-generated constructor stub
	}
	

	public SapforListeStage(LayoutManager layout) {
		super(layout);
		// TODO Auto-generated constructor stub
	}
	
	public SapforButton getBtu() {
		return btu;
	}

	public void setBtu(SapforButton btu) {
		this.btu = btu;
	}

	public SapforLabel getStage() {
		return stage;
	}

	public void setStage(SapforLabel stage) {
		this.stage = stage;
	}



}
