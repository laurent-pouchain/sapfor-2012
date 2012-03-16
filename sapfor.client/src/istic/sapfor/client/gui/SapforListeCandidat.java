package istic.sapfor.client.gui;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JPanel;
import javax.swing.border.BevelBorder;

public class SapforListeCandidat  extends JPanel {
	
	private SapforLabel candidat; 
	
	public SapforListeCandidat (String titre) {
		super();   
		candidat=new SapforLabel(titre);
		this.setLayout(new GridBagLayout());
		this.setBorder(new javax.swing.border.BevelBorder(BevelBorder.RAISED));
		this.add(candidat);
		this.setBackground(Color.BLUE);
	}
	public SapforListeCandidat (String titre, Color c) {
		super();   
		candidat=new SapforLabel(titre);
		this.setLayout(new GridBagLayout());
		this.setBorder(new javax.swing.border.BevelBorder(BevelBorder.RAISED));
		this.add(candidat);
		this.setBackground(c);
	}
}
