package istic.sapfor.client.gui;


import istic.sapfor.client.command.ICommand;
import istic.sapfor.client.command.ICommandContextKey;
import istic.sapfor.client.command.impl.DefaultCommandContext;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import javax.swing.JCheckBox;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTabbedPane;
import javax.swing.border.BevelBorder;


import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ContainerGestionStage implements IHMGStage {

private ClassPathXmlApplicationContext context = null;
private SapforJFrame frame;
private SapforButton bts;
private SapforJPanelUV infoStageUv;
private SapforLabel accueilLabel;
private JPanel paneWestInfoAgent;
private JPanel paneStage;
private JPanel paneUV;
private JDialog Jlogin;
private SapforButton log;
private Long idAgent;
private SapforButton buttonAdmin;
private JTabbedPane Onglets = null;

public long getIdAgent() {
	return idAgent;
}

public void setIdAgent(long idAgent) {
	this.idAgent = idAgent;
}


public void showUI(ClassPathXmlApplicationContext ctx) {

	context = ctx;
	//Partie à modifier car trop lourde, mettre ça dans une méthode ou autre...
	
	
	//Création de la boite de dialogue de connexion.
	Jlogin = new JDialog(); 
	Jlogin.setTitle("Connexion");
	Jlogin.setSize(300,150);
	Jlogin.setResizable(false);
	
	
	//Ajout des différents composants de la boite de dialogue de connexion.
	Dimension std = new Dimension(100,25);
	SapforLabel name = new SapforLabel("nom:");
	name.setPreferredSize(std);
	
	SapforLabel pwd = new SapforLabel("password:");
	pwd.setPreferredSize(std);
	
	final SapforJTextArea fname = new SapforJTextArea("admin");//Enlever "admin" pour la prod
	fname.setPreferredSize(std);
	
	final JPasswordField fpwd = new JPasswordField("motdepasse");//Enlever "motdepasse" pour la prod
	fpwd.setPreferredSize(std);
	
	log= new SapforButton("Connexion");
	log.setPreferredSize(std);
	
	//Positionnement des composants dans la boite de dialogue de connexion.
	Jlogin.setLayout(new GridBagLayout());
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
	Jlogin.add(name,gbc);
	 
	gbc.gridx = 1;
	gbc.gridwidth = 1;
	gbc.gridheight = 1;
	gbc.gridy = 0;
	Jlogin.add(fname, gbc);
	 
	gbc.gridx = 0;
	gbc.gridwidth = 1;
	gbc.gridheight = 1;
	gbc.gridy = 2;
	Jlogin.add(pwd, gbc);
	 
	gbc.gridx = 1;
	gbc.gridwidth = 1;
	gbc.gridheight = 1;
	gbc.gridy = 2;
	Jlogin.add(fpwd,gbc);
	 
	gbc.gridx = 1;
	gbc.gridwidth = 1;
	gbc.gridheight = 1;
	gbc.gridy = 3;
	Jlogin.add(log,gbc);
	
	Jlogin.setVisible(true);
	
	//Listener du bouton "connexion"
	log.addMouseListener(new MouseAdapter() {
		@Override
		public void mouseClicked(MouseEvent e) {
		
			ICommand cmd = (ICommand) context.getBean("cmdLogin");
			DefaultCommandContext ctx = new DefaultCommandContext();
			List<String> login=new LinkedList<String>();
			System.out.println(fname.getText());
			System.out.println(fpwd.getText());
			String log = fname.getText();
			String pwd= fpwd.getText();
			login.add(log);
			login.add(pwd);
			
			ctx.put(ICommandContextKey.Key_login, login);
			cmd.execute(ctx);
			
			
		}
	});
	
	//Création des composants de la page d'accueil du candidat loggé
	
	//Fenêtre principale
	frame= new SapforJFrame("page stage dispo"); //Création de la fenetre d'accueil des agents (invisible avant connexion)
	frame.setVisible(false);
	frame.setLayout(new GridBagLayout());
	GridLayout gl = new GridLayout(0,3);
	frame.setLayout(gl);
	
	//Panneau de l'utilisateur
	paneWestInfoAgent = new JPanel();
	paneWestInfoAgent.setBorder(new javax.swing.border.BevelBorder(BevelBorder.RAISED));
	accueilLabel= new SapforLabel();
	paneWestInfoAgent.add(accueilLabel);
	
	bts= new SapforButton("Stage dispo");
	bts.setPreferredSize(std);
	paneWestInfoAgent.add(bts);
	
	//Bouton disponible pour les administrateurs (visible lors du loggage)
	buttonAdmin = new SapforButton("Gérer Stage");
	buttonAdmin.setVisible(false);
	paneWestInfoAgent.add(buttonAdmin);
	
	
	//Panneau affichant les stages disponibles pour l'utilisateur
	paneStage = new JPanel();
	paneStage.setBorder(new javax.swing.border.BevelBorder(BevelBorder.RAISED));
	
	//Panneau affichant les UV disponibles pour l'utilisateur (visible en cliquant sur un stage)
	paneUV = new JPanel();
	paneUV.setBorder(new javax.swing.border.BevelBorder(BevelBorder.RAISED));
    infoStageUv= new SapforJPanelUV();
	infoStageUv.setVisible(false);
	paneUV.add(infoStageUv);
	
	
	
	frame.add(paneWestInfoAgent);
	frame.add(paneStage);
	frame.add(paneUV);
	
	//Listener du bouton "stage disponible"
	bts.addMouseListener(new MouseAdapter() {
		@Override
		public void mouseClicked(MouseEvent e) {
		
			ICommand cmd = (ICommand) context.getBean("cmdDisplayStageDispo");
			DefaultCommandContext ctx = new DefaultCommandContext();

			Long idAg=getIdAgent();
		
			ctx.put(ICommandContextKey.Key_Agent, idAg.toString());

			cmd.execute(ctx);
			
			System.out.println("OK");
						
		}
	});
	
	//Listener du bouton "Gérer Stage" (Administrateur only)
	buttonAdmin.addMouseListener(new MouseAdapter() {
		public void mouseClicked(MouseEvent e) {
		
			ICommand cmd = (ICommand) context.getBean("cmdDisplayGestionStage");
			DefaultCommandContext ctx = new DefaultCommandContext();
	
			Long idAg=getIdAgent();
		
			ctx.put(ICommandContextKey.Key_Agent, idAg.toString());
	
			cmd.execute(ctx);
			
			//System.out.println("OK");
					
		}
	});
	}
	





	public void displayStageDispo(HashMap<Long,String> st) {
		// TODO Auto-generated method stub
		
		int x=50,y=50;
		
		if (st==null){
			    SapforListeStage s=new SapforListeStage ("Pas de stage disponible");
			    s.getBtu().setVisible(false);
			    
			    y=y+120;
			    paneStage.add(s);		
		}
												
			else {
				for(Entry<Long, String> entry : st.entrySet()) {
				    final Long cle = entry.getKey();
				    String valeur = entry.getValue();
				    SapforListeStage s=new SapforListeStage (valeur);
				    
				   	y=y+120;
				   	paneStage.add(s);
				   	//clique sur le bouton pour afficher les stages disponibles
				   	s.getBtu().addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
						//String idA = accueilLabel.getText().split(" ")[3];
						ICommand cmd = (ICommand) context.getBean("cmdDisplayUvDispo");
						DefaultCommandContext ctx = new DefaultCommandContext();
						List<String> stageDisp=new LinkedList<String>();
						Long idAg=getIdAgent();
						System.out.println(idAg+" test ");
						stageDisp.add(cle.toString());
						stageDisp.add(idAg.toString());
						ctx.put(ICommandContextKey.Key_Stage, stageDisp);
		
							
						cmd.execute(ctx);
							
						
						System.out.println("OK2");	
						}
				   	});
	    	
				}
			}
	
			bts.setVisible(false);
			System.out.println("Essai sans serveur ni BD");
			
	}//fin displayStageDispo
			
		

	@Override
	public void displayUvDispo(final HashMap<Long, String> uv) {
		
		if (uv==null){
			SapforLabel nonUv= new SapforLabel ("Aucune Uv disponible");
			infoStageUv.add(nonUv);
		}
		
		else{

			final Map<Integer,JCheckBox> lstbox= new HashMap<Integer,JCheckBox>();
			int x=50,y=50; Integer i=0;
			infoStageUv.removeAll();
			infoStageUv.setVisible(false);
			for(Entry<Long, String> entry : uv.entrySet()) {
			    Long cle = entry.getKey();
			    String valeur = entry.getValue();
			    System.out.println(valeur + " titre UV");
				SapforLabel nuv= new SapforLabel (valeur);
				String nom=cle.toString();
				JCheckBox rad= new JCheckBox ();
				rad.setName(nom);
				//keyset
				lstbox.put(i, rad);
				i++;
				
			    infoStageUv.add(nuv);
			    infoStageUv.add(rad);
			    
			    y=y+120;
			}
				
			SapforButton inscr= new SapforButton("s'inscrire");
			infoStageUv.add(inscr);
			infoStageUv.setVisible(true);
			// quand on submit on regarde dans toutes les box si etat=true; on fait une list des IDuv
		
			inscr.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
					
				List<String> idUv=new LinkedList<String>();
				Long idAg=getIdAgent();
				idUv.add(idAg.toString());
		
				for (int i=0;i<lstbox.size();i++){
					if (lstbox.get(i).isSelected()==true){
						idUv.add(lstbox.get(i).getName());
					}
				}
				if(idUv.size()==1){
					JOptionPane.showMessageDialog(null, "Vous n'avez selectionné aucune Uv", "Error", JOptionPane.ERROR_MESSAGE);
				}
				else{
					ICommand cmd = (ICommand) context.getBean("cmdAddInscrition");
					DefaultCommandContext ctx = new DefaultCommandContext();
					ctx.put(ICommandContextKey.Key_Insct, idUv);
					cmd.execute(ctx);
					System.out.println("OK2");
				}	
													
			}
			});
		}
	}//fin displayUvDispo

	
	
	@Override
	public void displayAccueilAgentSuccessfull(String nameA, String fNameA, long idA, long typeAg) {
		// TODO Auto-generated method stub
		String infoAgent=fNameA+" "+nameA;
		accueilLabel.setText("Bonjour "+ infoAgent);//Edition du message personnalisé (Nom+prénom de l'agent loggé)
		setIdAgent(idA);
		
		Jlogin.setVisible(false);					 //Disparition de la boite de dialogue de connexion
		frame.setVisible(true);						 //Apparition de la page d'accueil personnalisée de l'agent loggé
		if(typeAg==0){
			buttonAdmin.setVisible(true);
		}
	}

	@Override
	public void errorLogin() {
		// TODO Auto-generated method stub
		JOptionPane.showMessageDialog(null, "Mauvais Login/Mot de passe", "Error", JOptionPane.ERROR_MESSAGE);
	}

	
	
//---------------------------------------------------------------------------------------------------------------		
//					MODIFICATION EN COURS - Antoine R. - Pannel Admin de Gestion des stages.
//---------------------------------------------------------------------------------------------------------------	
	
	@Override
	public void GererStageDir(HashMap<Long, String> st) {
		// TODO Auto-generated method stub		
		getOnglets(st);
		
		SapforJFrame frameGestionStage = new SapforJFrame("Gestion Stage");
		frameGestionStage.add(Onglets);
	    Onglets.setVisible(true);
	    frame.setVisible(false);
	    frameGestionStage.setVisible(true);
	}
	private JTabbedPane getOnglets(HashMap<Long,String> stDir)
	{
	    if(Onglets== null)
	    {
	        try
	        {if (stDir==null){
			    SapforListeStage s=new SapforListeStage ("Vous n'avez pas de stage à gerer");
			    s.getBtu().setVisible(false);
			    paneStage.add(s);		
	        	}
												
			else {
				Onglets = new JTabbedPane();
				Onglets.setSize(800,600);
				int i = 1;
				for(Entry<Long, String> entry : stDir.entrySet()) {
					String idOnglet="Onglet "+i;
					System.out.println(idOnglet);
					SapforGestionStage GererStage=new SapforGestionStage(entry.getValue());
		            Onglets.addTab(entry.getValue(), null, GererStage, null); //
		            i++;
				}
				}

	        } catch (java.lang.Throwable e)
	        {
	            // TODO: Something
	        }
	    }	    
	    return Onglets;
	}
}