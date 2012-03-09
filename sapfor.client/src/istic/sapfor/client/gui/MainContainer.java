package istic.sapfor.client.gui;

import istic.sapfor.api.dto.AgentDTO;
import istic.sapfor.client.command.ICommand;

import java.awt.BorderLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.HeadlessException;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.LinkedList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.UIManager;

import org.springframework.context.support.ClassPathXmlApplicationContext;


public class MainContainer extends JFrame implements IHM{

	private ClassPathXmlApplicationContext context = null;
	private JTextArea txt;
	private JTextField prenom;
	private JTextField nom;


	public void showUI(ClassPathXmlApplicationContext ctx) {
		context = ctx;
		/* Init default close operation */
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
        //pack();
		setSize(800, 400);
		setPreferredSize(getSize());
        setResizable(false);

        
        //bouton
		JLabel label = new JLabel("Ajouter un agent");
		
		JLabel labelp = new JLabel("prénom");
		prenom = new JTextField();
	
		JLabel labeln = new JLabel("nom");
		nom = new JTextField();
	
		txt= new JTextArea("Liste d'Agents");
		txt.setEditable(true);
		
		
		JButton btAdd = new JButton("Pull");
		JButton btAgent = new JButton("Affiche");
	    
		
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

		    this.add(pane,BorderLayout.CENTER);  
		    



			
		
		
		btAgent.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
					
						ICommand cmd = (ICommand) context.getBean("cmdDisplayAgents");
						cmd.execute();
						
			       
						System.out.println("OK");
						
				
						
					}
				});
			    
		    btAdd.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					ICommand cmd = (ICommand) context.getBean("cmdAddAgents");
					cmd.execute();					
					System.out.println("Ok");
				
				}
				
			
		});
		    setVisible(true);
	}
	
	@Override
	public void displayAgent(List<AgentDTO> agentlist) {
		String temp ="";
		for (AgentDTO a : agentlist ){
			if (a !=null){
			System.out.println(a.getName());
			
			
			temp+=a.getName();
			temp+=" ";
			temp+=a.getFirstName();
			temp+="\n";
			
			txt.setText(temp);									
			System.out.println("Essai sans serveur ni BD");
			}
			else {System.out.println("Agent null");}
			
		}
	}
	@Override
	public List<String> addAgent() {
		List<String> l = new LinkedList<String>();
		l.add(prenom.getText());
		l.add(nom.getText());
		return l;
	}

}
