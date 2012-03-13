package istic.sapfor.client.gui;

import java.awt.LayoutManager;

import javax.swing.JPanel;

public class SapforListeStage extends JPanel {

	public SapforListeStage(String titre) {
		super();
		SapforLabel stage=new SapforLabel(titre);
		SapforButton btu= new SapforButton("liste UV");
		this.add(stage);
		this.add(btu);
		// TODO Auto-generated constructor stub
	}
	
	
	


	public SapforListeStage(LayoutManager layout) {
		super(layout);
		// TODO Auto-generated constructor stub
	}
	
	

}
