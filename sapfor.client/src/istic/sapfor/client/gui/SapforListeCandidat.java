package istic.sapfor.client.gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JPanel;
import javax.swing.JTextPane;
import javax.swing.border.BevelBorder;

public class SapforListeCandidat  extends JTextPane {
	
	
	
	
	public SapforListeCandidat (String titre) {
		super();
		this.setText(titre);
		this.setEditable(false);
		this.setBorder(new javax.swing.border.BevelBorder(BevelBorder.RAISED));
		
	}
	public SapforListeCandidat (String titre, Color c) {
		super();
		this.setText(titre);
		this.setEditable(false);
		this.setBorder(new javax.swing.border.BevelBorder(BevelBorder.RAISED));
		this.setBackground(c);
	}
}
