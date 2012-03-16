package istic.sapfor.client.gui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.BevelBorder;

public class SapforGestionStage extends JPanel{

//MODIFICATION EN COURS - Antoine R. - Pannel Admin Gestion Stage	
	public SapforGestionStage(String titre) {
		super();
	
		
	
		JPanel main = new JPanel();
		GridLayout paneGestionStage = new GridLayout(0,2);
		main.setLayout(paneGestionStage);
		JPanel inscrit=new JPanel();
		inscrit.add(new JLabel("TODO afficher candidats inscrits"));
		inscrit.setBorder(new javax.swing.border.BevelBorder(BevelBorder.RAISED));
		main.add(inscrit);
		JPanel classer=new JPanel();
		//classer.add(new JLabel("TODO afficher candidats classés"));
		classer.setBorder(new javax.swing.border.BevelBorder(BevelBorder.RAISED));
		
		GridLayout classerLayout=new GridLayout(3,0);
		JPanel retenu = new JPanel();
		JPanel listeDA = new JPanel();
		JPanel refuse = new JPanel();

		retenu.setBorder(new javax.swing.border.BevelBorder(BevelBorder.RAISED));
		listeDA.setBorder(new javax.swing.border.BevelBorder(BevelBorder.RAISED));
		refuse.setBorder(new javax.swing.border.BevelBorder(BevelBorder.RAISED));
		classer.setLayout(classerLayout);
		classer.add(retenu);
		classer.add(listeDA);
		classer.add(refuse);
		main.add(classer);
		
	
		BorderLayout ongletLayout= new BorderLayout();
		this.setLayout(ongletLayout);
		//main.setPreferredSize(new Dimension(100, 50));
		this.add(main, BorderLayout.CENTER);

	
		JPanel validPanel= new JPanel();
		validPanel.setBorder(new javax.swing.border.BevelBorder(BevelBorder.RAISED));
		JButton valid = new JButton("Valider");
		JButton clore = new JButton("Clore");
		validPanel.add(valid);
		validPanel.add(clore);
		//validPanel.setPreferredSize(new Dimension(60, 50));
		this.add(validPanel, BorderLayout.PAGE_END);
		
		
	
		
	
		// TODO Auto-generated constructor stub
	}

}
