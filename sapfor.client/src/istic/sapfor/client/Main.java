package istic.sapfor.client;
import istic.sapfor.api.service.ServiceAgent;
import istic.sapfor.client.command.ICommand;
import istic.sapfor.client.gui.ContainerGestionStage;
import istic.sapfor.client.gui.MainContainer;

import java.awt.BorderLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import org.springframework.context.support.ClassPathXmlApplicationContext;




public class Main {
	public static void main(String[] args) throws Exception {
		
		/* Init Spring Default Config */
	  
final ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(new String[] {"sapforclient.xml"});

		
ContainerGestionStage rootUI = (ContainerGestionStage) context.getBean("ui1");
rootUI.showUI(context);

		
	/*
	   	JLabel label = new JLabel("Ajouter un agent");
		
		JLabel labelp = new JLabel("prénom");
		JTextField prenom = new JTextField();
		
		JLabel labeln = new JLabel("nom");
		JTextField nom = new JTextField();
		
		final JTextArea txt = new JTextArea("Liste d'agents");
		txt.setEditable(false);
		JButton btAdd = new JButton("Pull");
		JButton btAgent = new JButton("Affiche");
	    
	    btAdd.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				// ajouter la context.getBean(X).execute; pour lancer l'action d'affichage
				// récuperer les infos sur l'agent
			
				ICommand cmd = (ICommand) context.getBean("cmdDisplayAgents");
				cmd.execute();
	       
				
				
				//System.out.println(serviceAgentclient.getAgent(3));
				
			}
		});

	    btAgent.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				//Afficher les agents inscrit
				System.out.println("Hello");
			
			}
			
		
	});
	    
	  /*  
	    JPanel pane = new JPanel();
	    pane.setLayout(new GridBagLayout());
	    GridBagConstraints gbc = new GridBagConstraints();
	    gbc.weightx = 1;
	    gbc.weighty = 1;
	    gbc.ipadx = 2;
	    gbc.ipady = 2;
	    
	    gbc.gridx = 0;
	    gbc.gridwidth = 1;
	    gbc.gridheight = 1;
	    gbc.gridy = 0;
	    pane.add(label,gbc);
	    
	    gbc.gridx = 0;
	    gbc.gridwidth = 1;
	    gbc.gridheight = 1;
	    gbc.gridy = 1;
	    pane.add(labelp,gbc);
	    
	    gbc.gridx = 0;
	    gbc.gridwidth = 1;
	    gbc.gridheight = 1;
	    gbc.gridy = 2;
	    pane.add(labeln,gbc);
	    
	    gbc.gridx = 1;
	    gbc.gridwidth = 1;
	    gbc.gridheight = 1;
	    gbc.gridy = 1;
	    gbc.fill = GridBagConstraints.HORIZONTAL;
	    pane.add(prenom, gbc);
	    
	   
	    
	    gbc.gridx = 1;
	    gbc.gridwidth = 1;
	    gbc.gridheight = 1;
	    gbc.gridy = 2;
	    pane.add(nom,gbc);
	    
	    gbc.gridx = 3;
	    gbc.gridwidth = 2;
	    gbc.gridheight = 2;
	    gbc.gridy = 1;
	    gbc.fill = GridBagConstraints.VERTICAL;
	    pane.add(new JScrollPane(txt),gbc);
	    
	    gbc.gridx = 0;
	    gbc.gridwidth = 1;
	    gbc.gridheight = 1;
	    gbc.gridy = 4;
	    gbc.fill = GridBagConstraints.NONE;
	    pane.add(btAdd,gbc);
	    
	    gbc.gridx = 3;
	    gbc.gridwidth = 1;
	    gbc.gridheight = 1;
	    gbc.gridy = 4;
	    gbc.fill = GridBagConstraints.NONE;
	    pane.add(btAgent,gbc);

	    mainContainer.add(pane,BorderLayout.CENTER);
	    
	    
		

	final Random rand = new Random();
	
	
	
	
    // START SNIPPET: client
    /*
    final StageService client = (StageService)context.getBean("StageService");
    JButton btAdd = new JButton("ADD");
    JButton btList = new JButton("List");
    
    final JTextArea txt = new JTextArea();
    panel.add(btAdd);
    panel.add(btList);
    panel.add(txt);
    //JFrame frame = new JFrame("POC");
    //frame.add(panel);
    
 
    btAdd.addMouseListener(new MouseAdapter() {
		@Override
		public void mouseClicked(MouseEvent e) {
			Stage s = new Stage();
			s.setNom(rand.nextInt()+"");
			client.add(s);
		}
	});
    btList.addMouseListener(new MouseAdapter() {
		@Override
		public void mouseClicked(MouseEvent e) {
			
			List<Stage> l = client.get();
			String list = "";
			for(Stage s : l){
				list = list + "NAME="+ s.getNom()+"ID=" +s.getId()+ "\n";
			}
			txt.setText(list);
		}
	});    */
    
		
    
    
	}

}
