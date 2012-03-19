package istic.sapfor.client.gui;

import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.HeadlessException;

import javax.swing.JPanel;
import javax.swing.border.BevelBorder;

public class SapforJFrameAgent extends SapforJFrame {
	
	private JPanel paneWestInfoAgent;
	private SapforLabel accueilLabel;
	private SapforButton bts;
	private SapforButton buttonAdmin;
	private SapforButton buttonAddAgent;
	private JPanel paneStage; 
	private JPanel paneUV;
	private SapforJPanelUV infoStageUv;
	
	
	

	public SapforJFrameAgent(String titre) throws HeadlessException {
		super(titre);
		this.setVisible(false);
		this.setLayout(new GridBagLayout());
		GridLayout gl = new GridLayout(0,3);
		this.setLayout(gl);
		
		//Panneau de l'utilisateur
		paneWestInfoAgent = new JPanel();
		paneWestInfoAgent.setBorder(new javax.swing.border.BevelBorder(BevelBorder.RAISED));
		paneWestInfoAgent.setLayout(new GridLayout(15,0));
		accueilLabel= new SapforLabel();
		paneWestInfoAgent.add(accueilLabel);
		
		bts= new SapforButton("Stage dispo");
		
		paneWestInfoAgent.add(bts);
		
		//Bouton disponible pour les administrateurs (visible lors du loggage)
		buttonAdmin = new SapforButton("Gérer Stage");
		buttonAddAgent= new SapforButton("Ajouter Agent");
		buttonAdmin.setVisible(false);
		paneWestInfoAgent.add(buttonAdmin);
		paneWestInfoAgent.add(buttonAddAgent);

		
		
		//Panneau affichant les stages disponibles pour l'utilisateur
		paneStage = new JPanel();
		paneStage.setBorder(new javax.swing.border.BevelBorder(BevelBorder.RAISED));
		
		//Panneau affichant les UV disponibles pour l'utilisateur (visible en cliquant sur un stage)
		paneUV = new JPanel();
		paneUV.setBorder(new javax.swing.border.BevelBorder(BevelBorder.RAISED));
	    infoStageUv= new SapforJPanelUV();
		infoStageUv.setVisible(false);
		paneUV.add(infoStageUv);
		
	
		this.add(paneWestInfoAgent);
		this.add(paneStage);
		this.add(paneUV);
	}
	public JPanel getPaneWestInfoAgent() {
		return paneWestInfoAgent;
	}

	public void setPaneWestInfoAgent(JPanel paneWestInfoAgent) {
		this.paneWestInfoAgent = paneWestInfoAgent;
	}

	public SapforLabel getAccueilLabel() {
		return accueilLabel;
	}

	public void setAccueilLabel(SapforLabel accueilLabel) {
		this.accueilLabel = accueilLabel;
	}

	public SapforButton getBts() {
		return bts;
	}

	public void setBts(SapforButton bts) {
		this.bts = bts;
	}

	public SapforButton getButtonAdmin() {
		return buttonAdmin;
	}

	public void setButtonAdmin(SapforButton buttonAdmin) {
		this.buttonAdmin = buttonAdmin;
	}

	public JPanel getPaneStage() {
		return paneStage;
	}

	public void setPaneStage(JPanel paneStage) {
		this.paneStage = paneStage;
	}

	public JPanel getPaneUV() {
		return paneUV;
	}

	public void setPaneUV(JPanel paneUV) {
		this.paneUV = paneUV;
	}

	public SapforJPanelUV getInfoStageUv() {
		return infoStageUv;
	}

	public void setInfoStageUv(SapforJPanelUV infoStageUv) {
		this.infoStageUv = infoStageUv;
	}
	public SapforButton getButtonAddAgent() {
		return buttonAddAgent;
	}
	public void setButtonAddAgent(SapforButton buttonAddAgent) {
		this.buttonAddAgent = buttonAddAgent;
	}

}
