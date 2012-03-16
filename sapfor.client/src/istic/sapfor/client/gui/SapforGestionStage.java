package istic.sapfor.client.gui;

import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.BevelBorder;

public class SapforGestionStage extends JPanel{

//MODIFICATION EN COURS - Antoine R. - Pannel Admin Gestion Stage	
	public SapforGestionStage(String titre) {
		super();
		GridLayout paneGestionStage = new GridLayout(0,2);
		this.setLayout(paneGestionStage);
		JPanel inscrit=new JPanel();
		inscrit.add(new JLabel("TODO afficher candidats inscrits"));
		inscrit.setBorder(new javax.swing.border.BevelBorder(BevelBorder.RAISED));
		this.add(inscrit);
		JPanel classer=new JPanel();
		classer.add(new JLabel("TODO afficher candidats classés"));
		classer.setBorder(new javax.swing.border.BevelBorder(BevelBorder.RAISED));
		this.add(classer);
		
		this.setBorder(new javax.swing.border.BevelBorder(BevelBorder.RAISED));
		// TODO Auto-generated constructor stub
	}

}
