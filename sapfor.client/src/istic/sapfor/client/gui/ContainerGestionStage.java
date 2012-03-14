package istic.sapfor.client.gui;

import istic.sapfor.api.dto.AgentDTO;
import istic.sapfor.api.dto.StageDTO;
import istic.sapfor.client.command.ICommand;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
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
    infoStageUv= new SapforJPanelUV();
	infoStageUv.setVisible(false);
	frame.add(infoStageUv);
    
    
	bts.addMouseListener(new MouseAdapter() {
		@Override
		public void mouseClicked(MouseEvent e) {
		
			ICommand cmd = (ICommand) context.getBean("cmdDisplayStageDispo");
			cmd.execute();
			
			System.out.println("OK");
			
	
			
		}
	});
	

	//passer par un context pour envoyer l'id du stage
	
}
	
	public void displayStageDispo(HashMap<Long,String> st) {
		// TODO Auto-generated method stub
		
		int x=50,y=50;
		for(Entry<Long, String> entry : st.entrySet()) {
		    Long cle = entry.getKey();
		    String valeur = entry.getValue();
		    SapforListeStage s=new SapforListeStage (valeur);
		    s.setBounds(x,y,200,50);
		    
		   y=y+120;
		    frame.add(s);
		    s.getBtu().addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					
					ICommand cmd = (ICommand) context.getBean("cmdDisplayUvDispo");
					cmd.execute();
					//problème pour récuperer l'id du stage!!!
					System.out.println("OK2");
					
			
					
				}
			});
		    // traitements
		}
	
			bts.setVisible(false);

			System.out.println("Essai sans serveur ni BD");
			}
			
			
		

	@Override
	public void displayUvDispo(HashMap<Long, String> uv) {
		
		int x=50,y=50;
		for(Entry<Long, String> entry : uv.entrySet()) {
		    Long cle = entry.getKey();
		    String valeur = entry.getValue();
		    
			SapforLabel nuv= new SapforLabel (valeur);
			String nom="rad"+cle;
			JCheckBox rad= new JCheckBox ();
			rad.setName(nom);
		    infoStageUv.add(nuv);
		    infoStageUv.add(rad);
		    
		    
		   y=y+120;
	 
		
		// TODO Auto-generated method stub
		
	}
		infoStageUv.setVisible(true);
	}

	}
