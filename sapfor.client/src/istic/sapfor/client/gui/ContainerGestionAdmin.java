package istic.sapfor.client.gui;

import java.awt.Color;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map.Entry;

import javax.swing.JTabbedPane;

import istic.sapfor.api.dto.EtatCandidatureDTO;
import istic.sapfor.client.command.ICommand;
import istic.sapfor.client.command.ICommandContextKey;
import istic.sapfor.client.command.impl.DefaultCommandContext;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ContainerGestionAdmin implements IHMAdmin {

	
private ClassPathXmlApplicationContext context = null;
private SapforJFrame frameGestionStage;
private JTabbedPane Onglets = null;
private SapforGestionStage GererUv;

public ClassPathXmlApplicationContext getContext() {
	return context;
}


public void setContext(ClassPathXmlApplicationContext context) {
	this.context = context;
}

	

	public JTabbedPane getOnglets() {
	return Onglets;
}


public void setOnglets(JTabbedPane onglets) {
	Onglets = onglets;
}


	public void showUI(ClassPathXmlApplicationContext ctx, DefaultCommandContext cont ) {
		
		context = ctx;
		
		ICommand cmd = (ICommand) context.getBean("cmdDisplayGestionStage");
		cmd.execute(cont);
			
		
	
	}


	public void GererInscriptionUvDir(HashMap<Long, String> uv) {
	
			// TODO Auto-generated method stub		
			getOnglets(uv);
		
			frameGestionStage = new SapforJFrame("Gestion Stage");
			frameGestionStage.add(Onglets);
		    Onglets.setVisible(true);
		    frameGestionStage.setVisible(true);
		}
	
	
	private JTabbedPane getOnglets(HashMap<Long,String> uvDir)

	{
		    if(Onglets== null)
		    {
		        try
		        {if (uvDir==null){
				    SapforListeStage s=new SapforListeStage ("Vous n'avez pas de stage à gerer");
				    s.getBtu().setVisible(false);
				    //paneStage.add(s);		
		        	}
													
				else {
					Onglets = new JTabbedPane();
					Onglets.setSize(800,600);
					int i = 1;
					for(Entry<Long, String> entry : uvDir.entrySet()) {
						String idOnglet="Onglet "+i;
						System.out.println(idOnglet);
						GererUv=new SapforGestionStage(entry.getValue());
			            Onglets.addTab(entry.getValue(), null, GererUv, null); 
			            i++;
			        	DefaultCommandContext ctx = new DefaultCommandContext();
			        	String idUv=entry.getKey().toString();
			        	System.out.println("avant l'affichage");
			        	
			        	ctx.put(ICommandContextKey.Key_Cand, idUv);
			            ICommand cmd = (ICommand) context.getBean("cmdDisplayCandidat");
			    		cmd.execute(ctx);
			    		System.out.println("apres l'affichage");
					}
					}

		        } catch (java.lang.Throwable e)
		        {
		            // TODO: Something
		        }
		    }	    
		    return Onglets;
		}


	@Override
	public void DisplayCandidat(HashMap<Long,String> cand) {
			int x=50,y=50;
		if (cand==null){
			    SapforListeCandidat vide=new SapforListeCandidat ("Pas de candidat");
			    y=y+120;
			    GererUv.getInscrit().add(vide);
						}							
			else {
		for(Entry<Long, String> entry : cand.entrySet()) {
		    	final Long cle = entry.getKey();
		    	String nom = entry.getValue();
		    	SapforListeCandidat lst=new SapforListeCandidat(nom, Color.green);
		    	//System.out.println(valeur);
		    	//s.setBounds(x,y,200,50); 
		    	y=y+120;
		    	GererUv.getInscrit().add(lst);
		    											}
					}
																	}


	@Override
	public void DisplayRetenu(HashMap<Long, String> cand) {
	int x=50,y=50;
		if (cand==null){
			    SapforListeCandidat vide=new SapforListeCandidat ("Pas de candidat");
			    y=y+120;
			    GererUv.getRetenu().add(vide);
						}							
			else {
		for(Entry<Long, String> entry : cand.entrySet()) {

		    	final Long cle = entry.getKey();
		    	String nom = entry.getValue();
		    	SapforListeCandidat lst=new SapforListeCandidat(nom, Color.green);
		    	y=y+120;
		    	GererUv.getRetenu().add(lst);
		    											}
					}
																	}
		
	


	@Override
	public void DisplayNonRetenu(HashMap<Long, String> cand) {
		int x=50,y=50;
		if (cand==null){
			    SapforListeCandidat vide=new SapforListeCandidat ("Pas de candidat");
			    y=y+120;
			    GererUv.getRefuse().add(vide);
						}							
			else {
		for(Entry<Long, String> entry : cand.entrySet()) {

		    	final Long cle = entry.getKey();
		    	String nom = entry.getValue();
		    	SapforListeCandidat lst=new SapforListeCandidat(nom, Color.red);
		    	y=y+120;
		    	GererUv.getRefuse().add(lst);
		    											}
					}
																	}
		
	


	@Override
	public void DisplayListA(HashMap<Long, String> cand) {
		int x=50,y=50;
		if (cand==null){
			    SapforListeCandidat vide=new SapforListeCandidat ("Pas de candidat");
			    y=y+120;
			    GererUv.getListeDA().add(vide);
						}							
			else {
		for(Entry<Long, String> entry : cand.entrySet()) {

		    	final Long cle = entry.getKey();
		    	String nom = entry.getValue();
		    	SapforListeCandidat lst=new SapforListeCandidat(nom, Color.orange);
		    	y=y+120;
		    	GererUv.getListeDA().add(lst);
		    											}
					}
																	}
		public void Rafraichir(Integer idUv){
			DefaultCommandContext ctx = new DefaultCommandContext();
        	
        	System.out.println("avant l'affichage");
        	
        	ctx.put(ICommandContextKey.Key_Cand, idUv.toString());
            ICommand cmd = (ICommand) context.getBean("cmdDisplayCandidat");
    		cmd.execute(ctx);
    		System.out.println("apres l'affichage");
			}
	





		
		
	
		
}
	

