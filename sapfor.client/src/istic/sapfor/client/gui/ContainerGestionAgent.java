package istic.sapfor.client.gui;

import istic.sapfor.client.command.ICommand;
import istic.sapfor.client.command.ICommandContextKey;
import istic.sapfor.client.command.impl.DefaultCommandContext;
import istic.sapfor.client.gui.sapforcomponent.SapforButton;
import istic.sapfor.client.gui.sapforcomponent.SapforJFrame;
import istic.sapfor.client.gui.sapforcomponent.SapforJFrameAgent;
import istic.sapfor.client.gui.sapforcomponent.SapforJTextArea;
import istic.sapfor.client.gui.sapforcomponent.SapforLabel;
import istic.sapfor.client.gui.sapforcomponent.SapforListeCandidat;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.swing.Box;
import javax.swing.JCheckBox;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.border.BevelBorder;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ContainerGestionAgent implements IHMAgent {
	private ClassPathXmlApplicationContext context = null;
	private SapforJFrame frameGestionStage;
	private SapforJTextArea nom;
	private SapforJTextArea prenom;
	private SapforJTextArea login;
	private JCheckBox typeA;
	private SapforJFrameAgent frame;
	private SapforJFrame frameAgent;
	private SapforButton accueil;
	private SapforButton addAgent;

	public void showUI(ClassPathXmlApplicationContext context2, final SapforJFrameAgent frame) {
		context = context2;
		this.frame = frame;
		frame.setVisible(false);
		// addcandidat.setBorder(new
		// javax.swing.border.BevelBorder(BevelBorder.RAISED));
		ICommand cmd = (ICommand) context.getBean("cmdDisplayAgent");
		DefaultCommandContext ctx = new DefaultCommandContext();
		cmd.execute(ctx);
	}
	
	
	//Rafraichir la page (� am�liorer, actuellement r�execute la commande DisplayAgent
	public void Rafraichir1() {
		frameAgent.setVisible(false);
		ICommand cmd = (ICommand) context.getBean("cmdDisplayAgent");
		DefaultCommandContext ctx = new DefaultCommandContext();
		cmd.execute(ctx);
	}

	public JCheckBox getTypeA() {
		return typeA;
	}

	public void setTypeA(JCheckBox typeA) {
		this.typeA = typeA;
	}
	public void displayAgent(Map<Long, String> nomAgent) {
		frameAgent = new SapforJFrame("Gestion Agent");
		JPanel main = new JPanel();
		GridLayout mainLayout = new GridLayout(0, 2);
		main.setLayout(mainLayout);
		JPanel candidat = new JPanel();
		JPanel addcandidat = new JPanel();
		addcandidat.setLayout(mainLayout);
		candidat.setBorder(new javax.swing.border.BevelBorder(
				BevelBorder.RAISED));
		
		int nbAgent =  nomAgent.size();
		System.out.println("nbagent " + nbAgent);
		GridLayout laycandidats = new GridLayout(nbAgent, 0);
		candidat.setLayout(laycandidats);
		System.out.println( nomAgent.keySet().toString());

		for (final Entry<Long, String> entry :  nomAgent.entrySet()) {
			String idAgent = (String) entry.getValue();
			System.out.println("id " + entry);
			SapforListeCandidat cand = new SapforListeCandidat(idAgent);
			cand.getInscrit().setVisible(false);
			cand.getRetenu().setVisible(false);
			cand.getLstDa().setVisible(false);
			cand.getRefuse().setText("Supprimer");
			candidat.add(cand);

			//Listener bouton suppression d'un agent
			cand.getRefuse().addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {

					String idAgent = (entry.getKey().toString());
					DefaultCommandContext ctx = new DefaultCommandContext();
					ctx.put(ICommandContextKey.Key_Supp, idAgent);
					ICommand cmd = (ICommand) context.getBean("cmdSupAgent");
					boolean delAgent = cmd.execute(ctx);

					if (delAgent) {
						JOptionPane.showMessageDialog(null, "Agent supprim�",
								"Confirmation", JOptionPane.PLAIN_MESSAGE);
						Rafraichir1();
					} else {
						JOptionPane.showMessageDialog(null,
								"Erreur lors de la suppression de l'agent",
								"Error", JOptionPane.ERROR_MESSAGE);
					}

				}
			});
		}
		//Cr�ation des composants du panel admin "Gestion Agent"
		
		//ScrollBar
		JScrollPane retScroll = new JScrollPane(candidat,
		ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS,
		ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		
		//Label nom/prenom/login (pour la cr�ation d'agent)
		SapforLabel labelnom = new SapforLabel("Nom:");
		SapforLabel labelprenom = new SapforLabel("Prénom:");
		SapforLabel labelogin = new SapforLabel("Login:");
	
		//JTextArea nom/prenom/login
		nom = new SapforJTextArea();
		prenom = new SapforJTextArea();
		login = new SapforJTextArea();
		//Checkbox (sp�cification du type de l'agent cr�er (directeur ou non)).
		typeA = new JCheckBox("Directeur");
		
		//Bouton pour la cr�ation de l'agent
		addAgent = new SapforButton("Créer Agent");
		
		Box addCandidat = Box.createVerticalBox();
		//Espace vertical supérieur (mise en page)
		addCandidat.add(Box.createVerticalStrut(100));
		addCandidat.add(labelnom);
		addCandidat.add(nom);
		addCandidat.add(labelprenom);
		addCandidat.add(prenom);
		addCandidat.add(labelogin);
		addCandidat.add(login);
		addCandidat.add(typeA);
		addCandidat.add(addAgent);
		//Espace vertical inférieur (mise en page)
		addCandidat.add(Box.createVerticalStrut(350));
		addcandidat.add(addCandidat);
		addcandidat.add(new JPanel());
		main.add(addcandidat);
		main.add(retScroll);

		BorderLayout agentLayout = new BorderLayout();
		frameAgent.setLayout(agentLayout);
		frameAgent.add(main, BorderLayout.CENTER);
		
		//Panel du bas de page (contenant le bouton retour accueil)
		JPanel validPanel = new JPanel();
		validPanel.setBorder(new javax.swing.border.BevelBorder(
				BevelBorder.RAISED));

		accueil = new SapforButton("accueil");
		validPanel.add(accueil);
		frameAgent.add(validPanel, BorderLayout.PAGE_END);
		frameAgent.setVisible(true);
		
		//Listener du bouton ajouter agent (création d'un agent)
		addAgent.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				String nomSend = nom.getText();
				String prenomSend = prenom.getText();
				String loginSend = login.getText();
				
				//Vérification que les 3 champs nom/prenom/login ne sont pas vide
				
				if (nomSend.length() == 0) {
					System.out.println("nom null");
					JOptionPane.showMessageDialog(null,
							"Veuillez entrer un nom", "Error",
							JOptionPane.ERROR_MESSAGE);
				} else if (prenomSend.length() == 0) {
					System.out.println("prenom null");
					JOptionPane.showMessageDialog(null,
							"Veuillez entrer un prénom", "Error",
							JOptionPane.ERROR_MESSAGE);
				} else if (loginSend.length() == 0) {
					System.out.println("login null");
					JOptionPane.showMessageDialog(null,
							"Veuillez entrer un login", "Error",
							JOptionPane.ERROR_MESSAGE);
				}
				// Si les 3 champs remplis requis sont remplis on execute la
				// commande addAgent et on renvois un message de confirmation
				// de la création de l'agent (ou un message d'erreur)
				else {
					ICommand cmd = (ICommand) context.getBean("cmdAddAgent");
					DefaultCommandContext ctx = new DefaultCommandContext();
					List<String> infoAgent = new LinkedList<String>();
					infoAgent.add(nom.getText());
					infoAgent.add(prenom.getText());
					infoAgent.add(login.getText());
					if (getTypeA().isSelected() == true) {
						infoAgent.add("0");
					} else {
						infoAgent.add("1");
					}
					ctx.put(ICommandContextKey.Key_Add, infoAgent);
					// *************************************************************************************************
					// /!\ check est toujours true meme si l'agent existe déj�
					// il est recreer � voir coté serveur
					// *************************************************************************************************
					boolean check = cmd.execute(ctx);
					System.out.println(check);
					if (check) {
						JOptionPane.showMessageDialog(null, "Agent inscrit",
								"Confirmation", JOptionPane.PLAIN_MESSAGE);
						Rafraichir1();

					} else {
						JOptionPane.showMessageDialog(null,
								"Erreur lors de l'inscription (déjà inscrit?)",
								"Error", JOptionPane.ERROR_MESSAGE);
					}
				}
			}
		});
		//Listener bouton retour accueil
		accueil.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				//On r�affiche la page d'accueil en la r�initiallisant et on d�sactive la page actuelle
				frameAgent.setVisible(false);
				frame.getPaneStage().removeAll();
				frame.getPaneStage().revalidate();
				frame.setVisible(true);
				frame.getBts().setVisible(true);

			}
		});
	



}}