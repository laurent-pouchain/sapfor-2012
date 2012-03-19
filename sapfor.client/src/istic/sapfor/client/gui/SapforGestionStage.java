package istic.sapfor.client.gui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.border.BevelBorder;

public class SapforGestionStage extends JPanel{

private JPanel inscrit;	
private JPanel classer;	
private JPanel retenu;	
private JPanel listeDA;	
private JPanel refuse;	
private SapforButton valid;
private SapforButton clore;
private SapforButton accueil;

public SapforButton getValid() {
	return valid;
}

public void setValid(SapforButton valid) {
	this.valid = valid;
}

public SapforButton getClore() {
	return clore;
}

public void setClore(SapforButton clore) {
	this.clore = clore;
}

public SapforButton getAccueil() {
	return accueil;
}

public void setAccueil(SapforButton accueil) {
	this.accueil = accueil;
}

	public SapforGestionStage(String titre) {
		super();

		JPanel main = new JPanel();
		GridLayout paneGestionStage = new GridLayout(0,2);
		main.setLayout(paneGestionStage);
		inscrit=new JPanel();
		//inscrit.setLayout(new BoxLayout(inscrit, BoxLayout.Y_AXIS ));

		inscrit.setBorder(new javax.swing.border.BevelBorder(BevelBorder.RAISED));
		//JScrollPane jsp = new JScrollPane(inscrit,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		
		main.add(inscrit);
		//main.add(jsp);
		
		
		classer=new JPanel();
		//classer.add(new JLabel("TODO afficher candidats classés"));
		classer.setBorder(new javax.swing.border.BevelBorder(BevelBorder.RAISED));
		
		GridLayout classerLayout=new GridLayout(3,0);
		retenu = new JPanel();
		listeDA = new JPanel();
		refuse = new JPanel();
	

	

		retenu.setBorder(new javax.swing.border.BevelBorder(BevelBorder.RAISED));
		listeDA.setBorder(new javax.swing.border.BevelBorder(BevelBorder.RAISED));
		refuse.setBorder(new javax.swing.border.BevelBorder(BevelBorder.RAISED));
		
		classer.setLayout(classerLayout);
		
		classer.add(retenu);
		classer.add(listeDA);
		classer.add(refuse);
		
		/*JScrollBar ret=new JScrollPane(retenu).createVerticalScrollBar();
		classer.add(ret);
		classer.add(new JScrollPane(listeDA).createVerticalScrollBar());
		classer.add(new JScrollPane(refuse).createVerticalScrollBar());*/
		main.add(classer);
			
		BorderLayout ongletLayout= new BorderLayout();
		this.setLayout(ongletLayout);
		this.add(main, BorderLayout.CENTER);

		JPanel validPanel= new JPanel();
		validPanel.setBorder(new javax.swing.border.BevelBorder(BevelBorder.RAISED));
		valid = new SapforButton("Valider");
		clore = new SapforButton("Clore");
		accueil = new SapforButton("Accueil");

		validPanel.add(valid);
		validPanel.add(clore);
		validPanel.add(accueil);
		this.add(validPanel, BorderLayout.PAGE_END);

	}
	
	public JPanel getInscrit() {
		return inscrit;
	}
	public void setInscrit(JPanel inscrit) {
		this.inscrit = inscrit;
	}
	public JPanel getClasser() {
		return classer;
	}
	public void setClasser(JPanel classer) {
		this.classer = classer;
	}
	public JPanel getRetenu() {
		return retenu;
	}
	public void setRetenu(JPanel retenu) {
		this.retenu = retenu;
	}
	public JPanel getListeDA() {
		return listeDA;
	}
	public void setListeDA(JPanel listeDA) {
		this.listeDA = listeDA;
	}
	public JPanel getRefuse() {
		return refuse;
	}
	public void setRefuse(JPanel refuse) {
		this.refuse = refuse;
	}

}
