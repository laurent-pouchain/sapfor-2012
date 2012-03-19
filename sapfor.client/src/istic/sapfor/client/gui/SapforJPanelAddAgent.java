package istic.sapfor.client.gui;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JPanel;


public class SapforJPanelAddAgent extends JPanel {


	private SapforButton btsAdd;
	private SapforLabel fname;
	private SapforLabel name;
	private SapforLabel login;
	private Dimension std;
	
	public SapforJPanelAddAgent() {
		super();
		std = new Dimension(100,25);
		
		fname = new SapforLabel("Prénom: ");
		fname.setPreferredSize(std);
		this.add(fname);
		//Ajout des différents composants de la boite de dialogue de connexion.
		name = new SapforLabel("Nom: ");
		name.setPreferredSize(std);
		this.add(name);
		login = new SapforLabel("Login: ");
		login.setPreferredSize(std);
		this.add(login);
		btsAdd= new SapforButton("Ajouter");
		btsAdd.setPreferredSize(std);
		this.add(btsAdd);
		//Positionnement des composants dans la boite de dialogue de connexion.
		/*this.setLayout(new GridBagLayout());
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
		this.add(fname,gbc);
		 
		gbc.gridx = 1;
		gbc.gridwidth = 1;
		gbc.gridheight = 1;
		gbc.gridy = 0;
		this.add(name, gbc);
		 
		gbc.gridx = 0;
		gbc.gridwidth = 1;
		gbc.gridheight = 1;
		gbc.gridy = 2;
		this.add(login, gbc);
		 
		gbc.gridx = 1;
		gbc.gridwidth = 1;
		gbc.gridheight = 1;
		gbc.gridy = 2;
		this.add(fpwd,gbc);
		 
		gbc.gridx = 1;
		gbc.gridwidth = 1;
		gbc.gridheight = 1;
		gbc.gridy = 3;
		this.add(btsAdd,gbc);
		*/
		this.setVisible(true);
	}

	public SapforButton getBtsAdd() {
		return btsAdd;
	}

	public void setBtsAdd(SapforButton btsAdd) {
		this.btsAdd = btsAdd;
	}

	public SapforLabel getFname() {
		return fname;
	}

	public void setFname(SapforLabel fname) {
		this.fname = fname;
	}

	public SapforLabel getNameS() {
		return name;
	}

	public void setName(SapforLabel name) {
		this.name = name;
	}

	public SapforLabel getLogin() {
		return login;
	}

	public void setLogin(SapforLabel login) {
		this.login = login;
	}

	
}
