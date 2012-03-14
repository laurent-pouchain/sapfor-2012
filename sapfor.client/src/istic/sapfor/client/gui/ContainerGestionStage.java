package istic.sapfor.client.gui;

import istic.sapfor.api.dto.AgentDTO;
import istic.sapfor.client.command.ICommand;
import istic.sapfor.client.command.ICommandContextKey;
import istic.sapfor.client.command.impl.DefaultCommandContext;

import java.awt.Dimension;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import javax.swing.JCheckBox;
import javax.swing.JPanel;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ContainerGestionStage implements IHMGStage {

private ClassPathXmlApplicationContext context = null;
private SapforJFrame frame,frameLogin;
private SapforButton bts;
private SapforJPanelUV infoStageUv;
private SapforLabel accueilLabel;

public void showUI(ClassPathXmlApplicationContext ctx) {
	context = ctx;	
	frameLogin=new SapforJFrame("Login");
	SapforButton log= new SapforButton("Connexion");
	log.setPreferredSize(new Dimension(125,25));
	SapforLabel name = new SapforLabel("nom:");
	SapforLabel pwd = new SapforLabel("password:");
	final SapforJTextArea fname = new SapforJTextArea("	");
	final SapforJTextArea fpwd = new SapforJTextArea("	");
	JPanel pane = new JPanel();
	
	pane.add(name);
	pane.add(fname);
	pane.add(pwd);
	pane.add(fpwd);
	pane.add(log);
	frameLogin.add(pane);
	frameLogin.setVisible(true);
	
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
	
	frame= new SapforJFrame("page stage dispo");
	bts= new SapforButton("stage dispo");
	accueilLabel= new SapforLabel();
	frame.add(bts);
    frame.setVisible(false);
    frame.add(accueilLabel);
    //cadre pour afficher les uv
    infoStageUv= new SapforJPanelUV();
	infoStageUv.setVisible(false);
	frame.add(infoStageUv);
    
    
	bts.addMouseListener(new MouseAdapter() {
		@Override
		public void mouseClicked(MouseEvent e) {
		
			ICommand cmd = (ICommand) context.getBean("cmdDisplayStageDispo");
			cmd.execute(new DefaultCommandContext());
			
			System.out.println("OK");
			
	
			
		}
	});
	

	//passer par un context pour envoyer l'id du stage
	
}
	
	public void displayStageDispo(HashMap<Long,String> st) {
		// TODO Auto-generated method stub
		
		int x=50,y=50;
		
		if (st==null){
			    SapforListeStage s=new SapforListeStage ("Pas de stage disponible");
			    s.setBounds(x,y,200,50);
			    s.getBtu().setVisible(false);
			    
			   y=y+120;
			    frame.add(s);		
		}
												
			else {
		for(Entry<Long, String> entry : st.entrySet()) {

		    	final Long cle = entry.getKey();
		    	String valeur = entry.getValue();
		    	SapforListeStage s=new SapforListeStage (valeur);
		 
		    	s.setBounds(x,y,200,50);
		    	y=y+120;
		    	frame.add(s);
		    	//clique sur le bouton pour afficher les stages disponibles
		    	s.getBtu().addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
			
					ICommand cmd = (ICommand) context.getBean("cmdDisplayUvDispo");
					DefaultCommandContext ctx = new DefaultCommandContext();
					
					ctx.put(ICommandContextKey.Key_Stage, cle.toString());
					
					cmd.execute(ctx);
					
				
					System.out.println("OK2");	
				}
			});
	    	
		}
		}
	
			bts.setVisible(false);

			System.out.println("Essai sans serveur ni BD");
			
}
			
		

	@Override
	public void displayUvDispo(final HashMap<Long, String> uv) {
		
		final Map<Integer,JCheckBox> lstbox= new HashMap<Integer,JCheckBox>();
		int x=50,y=50; Integer i=0;
		for(Entry<Long, String> entry : uv.entrySet()) {
		    Long cle = entry.getKey();
		    String valeur = entry.getValue();
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
				for (int i=0;i<lstbox.size();i++){
					if (lstbox.get(i).isSelected()==true){
						idUv.add(lstbox.get(i).getName());
														 }
				ICommand cmd = (ICommand) context.getBean("cmdAddInscrition");
				DefaultCommandContext ctx = new DefaultCommandContext();
				ctx.put(ICommandContextKey.Key_Insct, idUv);
				cmd.execute(ctx);
				System.out.println("OK2");	
												}
													}
													});
	}


	@Override
	public void displayAccueilAgent(String nameA, String fNameA, long idA) {
		// TODO Auto-generated method stub
		frame.setVisible(true);
		frameLogin.setVisible(false);
		accueilLabel.setText("Bonjour "+ nameA+" "+ fNameA);
	}

	
	
}