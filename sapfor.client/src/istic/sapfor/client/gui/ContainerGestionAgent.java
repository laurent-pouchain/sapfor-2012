package istic.sapfor.client.gui;

import istic.sapfor.api.dto.AgentDTO;
import istic.sapfor.client.command.ICommand;
import istic.sapfor.client.command.ICommandContextKey;
import istic.sapfor.client.command.impl.DefaultCommandContext;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.swing.Box;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.border.BevelBorder;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ContainerGestionAgent implements IHMAdmin{
	private ClassPathXmlApplicationContext context = null;
	private SapforJFrame frameGestionStage;
	private SapforJTextArea nom; 
	private SapforJTextArea prenom; 
	private SapforJTextArea login;
	private SapforJFrameAgent frame;
	private SapforJFrame frameAgent;
	private SapforButton accueil;
	private SapforButton addAgent;

	@Override
	public void GererInscriptionUvDir(HashMap<Long, String> st) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void DisplayCandidat(String idTemp, HashMap<Long, String> cand) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void DisplayRetenu(String idTemp, HashMap<Long, String> cand) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void DisplayNonRetenu(String idTemp, HashMap<Long, String> cand) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void DisplayListA(String idTemp, HashMap<Long, String> cand) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void Rafraichir() {
		// TODO Auto-generated method stub
		
	}

	public void showUI(ClassPathXmlApplicationContext context2,
			DefaultCommandContext ctx, final SapforJFrameAgent frame) {
			context = context2;
			this.frame= frame;
			frame.setVisible(false);
			frameAgent = new SapforJFrame("Gestion Agent");
			JPanel main= new JPanel();
			GridLayout mainLayout = new GridLayout(0,2);
			main.setLayout(mainLayout);
			JPanel candidat=new JPanel();
			JPanel addcandidat =new JPanel();
			addcandidat.setLayout(mainLayout);
			candidat.setBorder(new javax.swing.border.BevelBorder(BevelBorder.RAISED));
			//addcandidat.setBorder(new javax.swing.border.BevelBorder(BevelBorder.RAISED));
			
			Map<Long, String> ag=ctx.getMap(ICommandContextKey.Key_DisplayAgent);
			int nbAgent = ag.size();
			System.out.println("nbagent " + nbAgent);
			GridLayout laycandidats=new GridLayout(nbAgent,0);
			candidat.setLayout(laycandidats);
			System.out.println(ag.keySet().toString());
			
			for(final Entry<Long, String> entry : ag.entrySet()) {
				String idAgent = (String) entry.getValue();
				System.out.println("id "+entry);
				SapforListeCandidat cand = new SapforListeCandidat(idAgent);
				cand.getInscrit().setVisible(false);
				cand.getRetenu().setVisible(false);
				cand.getLstDa().setVisible(false);
				cand.getRefuse().setText("Supprimer");
				candidat.add(cand);
				//Listener pour supprimer un agent 
				
				cand.getRefuse().addMouseListener(new MouseAdapter() {
		    		@Override
		    		public void mouseClicked(MouseEvent e) {
		    			
						String idAgent =(entry.getKey().toString());
						DefaultCommandContext ctx = new DefaultCommandContext();
						ctx.put(ICommandContextKey.Key_Supp, idAgent);
						ICommand cmd = (ICommand) context.getBean("cmdSupAgent");
						boolean delAgent= cmd.execute(ctx);
						
						//Doit y'avoir une erreur quelque part le boolean est toujours à false...
						if (delAgent) {JOptionPane.showMessageDialog(null,"Agent supprimé", "Confirmation",JOptionPane.PLAIN_MESSAGE);}
						else {JOptionPane.showMessageDialog(null, "Erreur lors de la suppression de l'agent", "Error", JOptionPane.ERROR_MESSAGE);}

		    		}
		    	});	
			}
			JScrollPane retScroll= new JScrollPane(candidat,ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS,ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
			
			
			
			SapforLabel labelnom = new SapforLabel("Nom:");
			SapforLabel labelprenom = new SapforLabel("Prénom:");
			SapforLabel labelogin = new SapforLabel("Login:");
			
			addAgent = new SapforButton("Créer Agent");
			nom = new SapforJTextArea();
			prenom = new SapforJTextArea();
			login = new SapforJTextArea();
			
			Box addCandidat = Box.createVerticalBox();
			addCandidat.add(Box.createVerticalStrut(100));
			addCandidat.add(labelnom);
			addCandidat.add(nom);
			addCandidat.add(labelprenom);
			addCandidat.add(prenom);			
			addCandidat.add(labelogin);
			addCandidat.add(login);
			addCandidat.add(addAgent);
			addCandidat.add(Box.createVerticalStrut(350));
			
			addcandidat.add(addCandidat);
			addcandidat.add(new JPanel());
			main.add(addcandidat);
			
			main.add(retScroll);
			
			BorderLayout agentLayout= new BorderLayout();
			frameAgent.setLayout(agentLayout);
			frameAgent.add(main, BorderLayout.CENTER);
			
			JPanel validPanel= new JPanel();
			validPanel.setBorder(new javax.swing.border.BevelBorder(BevelBorder.RAISED));

			accueil = new SapforButton ("accueil");			
			validPanel.add(accueil);
			frameAgent.add(validPanel, BorderLayout.PAGE_END);
			frameAgent.setVisible(true);
			addAgent.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {					
					
					String nomSend=nom.getText();
					String prenomSend=prenom.getText();
					String loginSend=login.getText();
					
					if(nomSend.length()==0){
						System.out.println("nom null");
					JOptionPane.showMessageDialog(null, "Veuillez entrer un nom", "Error", JOptionPane.ERROR_MESSAGE);
					}
					else if(prenomSend.length()==0){
						System.out.println("prenom null");
						JOptionPane.showMessageDialog(null, "Veuillez entrer un prénom", "Error", JOptionPane.ERROR_MESSAGE);
						}
					else if(loginSend.length()==0){
						System.out.println("login null");
						JOptionPane.showMessageDialog(null, "Veuillez entrer un login", "Error", JOptionPane.ERROR_MESSAGE);
						}
					//Si les 3 champs remplis requis sont remplis on execute la commande addAgent et on renvois un message de confirmation
					//de la création de l'agent (ou un message d'erreur)
					else {
						ICommand cmd = (ICommand) context.getBean("cmdAddAgent");
						DefaultCommandContext ctx = new DefaultCommandContext();
						List<String> infoAgent=new LinkedList<String>();
						infoAgent.add(nom.getText());
						infoAgent.add(prenom.getText());
						infoAgent.add(login.getText());
						ctx.put(ICommandContextKey.Key_Add, infoAgent);
						//*************************************************************************************************
						//    /!\ check est toujours true meme si l'agent existe déjà il est recreer à voir coté serveur
						//*************************************************************************************************
						boolean check = cmd.execute(ctx);
						System.out.println(check);
						if (check) {
							JOptionPane.showMessageDialog(null,"Agent inscrit", "Confirmation",JOptionPane.PLAIN_MESSAGE);
							Rafraichir1();
						
						
						
						}
						else {JOptionPane.showMessageDialog(null, "Erreur lors de l'inscription (déjà inscrit?)", "Error", JOptionPane.ERROR_MESSAGE);}
					}			
				}
			});
			accueil.addMouseListener(new MouseAdapter() {
	    		@Override
	    		public void mouseClicked(MouseEvent e) {
	    			frameAgent.setVisible(false);
	    			
	    			
	    			//bidouille d'affichage
	    			
	    			frame.getPaneStage().removeAll();
	    			frame.getPaneStage().setVisible(false);
	    			frame.getPaneStage().setVisible(true);
	    			frame.setVisible(true);
	    			frame.getBts().setVisible(true);

	    		}
	    	});		
	}
	public void Rafraichir1(){
		frameAgent.setVisible(false);
		ICommand cmd = (ICommand) context.getBean("cmdDisplayAgent");
		DefaultCommandContext ctx = new DefaultCommandContext();
		cmd.execute(ctx);
	}
}
