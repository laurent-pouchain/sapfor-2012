package istic.sapfor.client.gui;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JDialog;
import javax.swing.JPasswordField;

public class SapforJDialogConnection extends JDialog {

	private SapforButton log;
	private SapforJTextArea fname;
	private JPasswordField fpwd;
	private Dimension std;

	public SapforJDialogConnection() {
		super();
		this.setTitle("Connexion");
		this.setSize(300,150);
		this.setResizable(false);
		std = new Dimension(100,25);
		SapforLabel name = new SapforLabel("nom:");
		name.setPreferredSize(std);
		
		//Ajout des différents composants de la boite de dialogue de connexion.
		SapforLabel pwd = new SapforLabel("password:");
		pwd.setPreferredSize(std);
		fname = new SapforJTextArea("admin");//Enlever "admin" pour la prod
		fname.setPreferredSize(std);
		
		fpwd = new JPasswordField("motdepasse");//Enlever "motdepasse" pour la prod
		fpwd.setPreferredSize(std);
		
		log= new SapforButton("Connexion");
		log.setPreferredSize(std);
		
		//Positionnement des composants dans la boite de dialogue de connexion.
		this.setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		 
		gbc.weightx = 1;
		gbc.weighty = 1;
		gbc.ipadx= 1;
		gbc.ipady= 1;
		
		gbc.gridx = 0;
		gbc.gridwidth = 1;
		gbc.gridheight = 1;
		gbc.gridy = 0;
		gbc.fill = GridBagConstraints.NONE;
		this.add(name,gbc);
		 
		gbc.gridx = 1;
		gbc.gridwidth = 1;
		gbc.gridheight = 1;
		gbc.gridy = 0;
		this.add(fname, gbc);
		 
		gbc.gridx = 0;
		gbc.gridwidth = 1;
		gbc.gridheight = 1;
		gbc.gridy = 2;
		this.add(pwd, gbc);
		 
		gbc.gridx = 1;
		gbc.gridwidth = 1;
		gbc.gridheight = 1;
		gbc.gridy = 2;
		this.add(fpwd,gbc);
		 
		gbc.gridx = 1;
		gbc.gridwidth = 1;
		gbc.gridheight = 1;
		gbc.gridy = 3;
		this.add(log,gbc);
		
		this.setVisible(true);
	}
	public SapforJTextArea getFname() {
		return fname;
	}


	public Dimension getStd() {
		return std;
	}
	public void setStd(Dimension std) {
		this.std = std;
	}
	public void setFname(SapforJTextArea fname) {
		this.fname = fname;
	}


	public JPasswordField getFpwd() {
		return fpwd;
	}


	public void setFpwd(JPasswordField fpwd) {
		this.fpwd = fpwd;
	}



	
	public SapforButton getLog() {
		return log;
	}


	public void setLog(SapforButton log) {
		this.log = log;
	}

	
	
}
