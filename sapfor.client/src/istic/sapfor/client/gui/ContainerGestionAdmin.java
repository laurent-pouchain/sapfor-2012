package istic.sapfor.client.gui;

import java.util.HashMap;
import java.util.Map.Entry;

import javax.swing.JTabbedPane;

import istic.sapfor.client.command.ICommand;
import istic.sapfor.client.command.impl.DefaultCommandContext;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ContainerGestionAdmin implements IHMAdmin {

	
private ClassPathXmlApplicationContext context = null;
private SapforJFrame frameAdmin;
private JTabbedPane Onglets = null;
	

	public void showUI(ClassPathXmlApplicationContext ctx) {
		
		context = ctx;
		
		ICommand cmd = (ICommand) context.getBean("cmdDisplayGestionStage");
		DefaultCommandContext cont = new DefaultCommandContext();
		cmd.execute(cont);
			
		
	
	}


	@Override
	public void GererStageDir(HashMap<Long, String> st) {
	
			// TODO Auto-generated method stub		
			getOnglets(st);
			
			SapforJFrame frameGestionStage = new SapforJFrame("Gestion Stage");
			frameGestionStage.add(Onglets);
		    Onglets.setVisible(true);
		    frameGestionStage.setVisible(false);
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
				    //paneStage.add(s);		
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
	

