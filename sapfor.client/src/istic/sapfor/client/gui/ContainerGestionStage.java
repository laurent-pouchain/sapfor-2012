package istic.sapfor.client.gui;

import istic.sapfor.client.command.ICommand;
import istic.sapfor.client.command.ICommandContextKey;
import istic.sapfor.client.command.impl.DefaultCommandContext;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.HashMap;
import java.util.Map.Entry;
import javax.swing.JCheckBox;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ContainerGestionStage implements IHMGStage {

private ClassPathXmlApplicationContext context = null;
private SapforJFrame frame;
private SapforButton bts;
private SapforJPanelUV infoStageUv;


public void showUI(ClassPathXmlApplicationContext ctx) {
	context = ctx;	
	
	frame= new SapforJFrame("page stage dispo");
	bts= new SapforButton("stage dispo");
	frame.add(bts);
    frame.setVisible(true);
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
		
		int x=50,y=50;
		for(Entry<Long, String> entry : uv.entrySet()) {
		    Long cle = entry.getKey();
		    String valeur = entry.getValue();
		    
			SapforLabel nuv= new SapforLabel (valeur);
			String nom=cle.toString();
			JCheckBox rad= new JCheckBox ();
		
			rad.setName(nom);
		    infoStageUv.add(nuv);
		    infoStageUv.add(rad);
		    
		   y=y+120;
	 
	
		// TODO Auto-generated method stub
		
	}
		SapforButton inscr= new SapforButton("s'inscrire");
		infoStageUv.add(inscr);
		infoStageUv.setVisible(true);
	// quand on appuis sur submit on regarde dans toute les set box si state = 	cb.isSelected(); on fait une collection
		//clique sur les UVs à choisir
		inscr.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				for(Entry<Long, String> entry : uv.entrySet()) {
				    Long cle = entry.getKey();
				   
					
				// pas fini
		  
				ICommand cmd = (ICommand) context.getBean("cmdAddInscrition");
				DefaultCommandContext ctx = new DefaultCommandContext();
				
				ctx.put(ICommandContextKey.Key_Stage, cle.toString());
				
				cmd.execute(ctx);
				
			
				System.out.println("OK2");	
			}
			}});
		
	

		
	
	
	}
	
	
}