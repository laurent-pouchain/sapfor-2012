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

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ContainerGestionStage implements IHMGStage {

private ClassPathXmlApplicationContext context = null;
private SapforJFrame frame;
private SapforButton bts;
	
public void showUI(ClassPathXmlApplicationContext ctx) {
	context = ctx;	
	
	frame= new SapforJFrame("page stage dispo");
	bts= new SapforButton("stage dispo");
	frame.add(bts);
    frame.setVisible(true);
	
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
		
		
		for(Entry<Long, String> entry : st.entrySet()) {
		    Long cle = entry.getKey();
		    String valeur = entry.getValue();
		    SapforListeStage s=new SapforListeStage (valeur);
		    frame.add(s);
		    // traitements
		}
	
			bts.setVisible(false);

			System.out.println("Essai sans serveur ni BD");
			}
			
			
		
	
		
	

	@Override
	public void displayUvDispo(Collection<Long> uvDispo) {
		// TODO Auto-generated method stub
		
	}



}
