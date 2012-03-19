package istic.sapfor.client.gui;

import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.swing.JOptionPane;
import javax.swing.JTabbedPane;
import istic.sapfor.client.command.ICommand;
import istic.sapfor.client.command.ICommandContextKey;
import istic.sapfor.client.command.impl.DefaultCommandContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ContainerGestionAdmin implements IHMAdmin {

	
private ClassPathXmlApplicationContext context = null;
private SapforJFrame frameGestionStage;
private SapforJFrameAgent frame;
private JTabbedPane Onglets = null;
private Map<Long,SapforGestionStage> GererUvs;

public Map<Long, SapforGestionStage> getGererUvs() {
	return GererUvs;
}




public void setGererUvs(Map<Long, SapforGestionStage> gererUvs) {
	GererUvs = gererUvs;
}



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


	public void showUI(ClassPathXmlApplicationContext ctx, DefaultCommandContext cont, SapforJFrameAgent frame ) {
		
		context = ctx;
		this.frame= frame;
		ICommand cmd = (ICommand) context.getBean("cmdDisplayGestionStage");
		cmd.execute(cont);	
		
	
	}


	public void GererInscriptionUvDir(HashMap<Long, String> uv) {
	
			// TODO Auto-generated method stub
			frameGestionStage = new SapforJFrame("Gestion Stage");

		    getOnglets(uv);
			frameGestionStage.add(Onglets);
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
				  		
		        }
													
				else {
					Onglets = new JTabbedPane();
					Onglets.setSize(800,600);
					int i = 1;
				
					Map<Long,SapforGestionStage> GererUvs=new HashMap<Long,SapforGestionStage>();
	    			for(Entry<Long, String> entry : uvDir.entrySet()) {
						String idOnglet="Onglet "+i;
						System.out.println("repère recherche de l'id perdu");
						System.out.println(idOnglet);
						SapforGestionStage GererUv=new SapforGestionStage(entry.getValue());
						GererUvs.put(entry.getKey(), GererUv);
			            Onglets.addTab(entry.getValue(), null, GererUv, null); 
			            i++;
					}
					setGererUvs(GererUvs);
						for(final Entry<Long, SapforGestionStage> entry : GererUvs.entrySet()) {
							DefaultCommandContext ctx = new DefaultCommandContext();
							System.out.println("avant l'affichage");
							System.out.println("------------------------------------------------");
							System.out.println("l'IDUV C'est... "+entry.getKey());
							ctx.put(ICommandContextKey.Key_Cand, entry.getKey().toString());
							ICommand cmd = (ICommand) context.getBean("cmdDisplayCandidat");
							cmd.execute(ctx);
							System.out.println("------------------------------------------------");
							System.out.println("apres l'affichage");

							entry.getValue().getClore().addMouseListener(new MouseAdapter() {
					    		@Override
					    		public void mouseClicked(MouseEvent e) {
					    	
					    			DefaultCommandContext ctx1 = new DefaultCommandContext();
					    			ctx1.put(ICommandContextKey.Key_Clor, entry.getKey().toString());
									ICommand cmd = (ICommand) context.getBean("cmdClore");
									boolean reussi= cmd.execute(ctx1);
									if (reussi) { JOptionPane.showMessageDialog(null,"Inscription close", "Confirmation",JOptionPane.PLAIN_MESSAGE);}
									else {JOptionPane.showMessageDialog(null, "erreur de la cloture", "Error", JOptionPane.ERROR_MESSAGE);}
					    		}
					    	});
						
							entry.getValue().getValid().addMouseListener(new MouseAdapter() {
					    		@Override
					    		public void mouseClicked(MouseEvent e) {
					    	
					    			DefaultCommandContext ctx1 = new DefaultCommandContext();
					    			ctx1.put(ICommandContextKey.Key_Valid, entry.getKey().toString());
									ICommand cmd = (ICommand) context.getBean("cmdValid");
									boolean reussi= cmd.execute(ctx1);
									if (reussi) { JOptionPane.showMessageDialog(null,"Inscription validé", "Confirmation",JOptionPane.PLAIN_MESSAGE);}
									else {JOptionPane.showMessageDialog(null, "erreur de la ", "Error", JOptionPane.ERROR_MESSAGE);}
					    		}
					    	});

							entry.getValue().getAccueil().addMouseListener(new MouseAdapter() {
					    		@Override
					    		public void mouseClicked(MouseEvent e) {
					    			frameGestionStage.setVisible(false);
					    			
					    			
					    			//bidouille d'affichage
					    			
					    			frame.getPaneStage().removeAll();
					    			frame.getPaneStage().setVisible(false);
					    			
					    			frame.setVisible(true);
					    			frame.getBts().setVisible(true);

					    		}
					    	});			

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
	public void DisplayCandidat(final String idUv, HashMap<Long,String> cand) {
		if (cand==null){
			    SapforListeCandidat vide=new SapforListeCandidat ("Pas de candidat");
			    
			    vide.getInscrit().setVisible(false);
			    vide.getRetenu().setVisible(false);
			    vide.getLstDa().setVisible(false);
			    vide.getRefuse().setVisible(false);
			    int idUvInt=Integer.parseInt(idUv);
			   
			    GererUvs.get((long)idUvInt).getInscrit().add(vide);
			    
		}							
		else {			
			for(final Entry<Long, String> entry : cand.entrySet()) {
		    	String nom = entry.getValue();
		    	SapforListeCandidat lst=new SapforListeCandidat(nom, Color.GRAY);
		    	lst.getInscrit().setVisible(false);
		    		int idUvInt=Integer.parseInt(idUv);
		    		GererUvs.get((long)idUvInt).getInscrit().add(lst);
		    	
		    
		    	lst.getRetenu().addMouseListener(new MouseAdapter() {
		    		@Override
		    		public void mouseClicked(MouseEvent e) {

		    			DefaultCommandContext ctx = new DefaultCommandContext();
		    			List<String> infoTraitmt=new LinkedList<String>();
		    			infoTraitmt.add(idUv);
		    			infoTraitmt.add(entry.getKey().toString());
		    			String nouvelEtat="retenu";
		    			infoTraitmt.add(nouvelEtat);
		    			String ancienEtat="inscrit";
		    			infoTraitmt.add(ancienEtat);
		    			ctx.put(ICommandContextKey.Key_Trait,infoTraitmt );
		    			ICommand cmd = (ICommand) context.getBean("cmdTraitement");
		    			cmd.execute(ctx);
		    			System.out.println("OK traitement candidat ");				
		    		}
		    	});
		    	lst.getLstDa().addMouseListener(new MouseAdapter() {
		    		@Override
		    		public void mouseClicked(MouseEvent e) {

		    			DefaultCommandContext ctx = new DefaultCommandContext();
		    			List<String> infoTraitmt=new LinkedList<String>();
		    			infoTraitmt.add(idUv);
		    			infoTraitmt.add(entry.getKey().toString());
		    			String nouvelEtat="listeAttente";
		    			infoTraitmt.add(nouvelEtat);
		    			String ancienEtat="inscrit";
		    			infoTraitmt.add(ancienEtat);
		    			ctx.put(ICommandContextKey.Key_Trait,infoTraitmt );
		    			ICommand cmd = (ICommand) context.getBean("cmdTraitement");
		    			cmd.execute(ctx);
		    			System.out.println("OK traitement candidat ");				
		    		}
		    	});
		    	lst.getRefuse().addMouseListener(new MouseAdapter() {
		    		@Override
		    		public void mouseClicked(MouseEvent e) {

		    			DefaultCommandContext ctx = new DefaultCommandContext();
		    			List<String> infoTraitmt=new LinkedList<String>();
		    			infoTraitmt.add(idUv);
		    			infoTraitmt.add(entry.getKey().toString());
		    			String nouvelEtat="nonRetenu";
		    			infoTraitmt.add(nouvelEtat);
		    			String ancienEtat="inscrit";
		    			infoTraitmt.add(ancienEtat);
		    			ctx.put(ICommandContextKey.Key_Trait,infoTraitmt );
		    			ICommand cmd = (ICommand) context.getBean("cmdTraitement");
		    			cmd.execute(ctx);
		    			System.out.println("OK traitement candidat ");				
		    		}
		    	});  
		    	System.out.println("Display Candidat - Candidat "+nom);
		    	
		    }
		}
	}


	@Override
	public void DisplayRetenu(final String idUv, HashMap<Long, String> cand) {	
	if (cand==null){
			    SapforListeCandidat vide=new SapforListeCandidat ("Pas de candidat ");
			    vide.getInscrit().setVisible(false);
			    vide.getRetenu().setVisible(false);
			    vide.getLstDa().setVisible(false);
			    vide.getRefuse().setVisible(false);	    
			    int idUvInt=Integer.parseInt(idUv);
			    GererUvs.get((long)idUvInt).getRetenu().add(vide);
			  
		}							
		else {
			for(final Entry<Long, String> entry : cand.entrySet()) {
				
		    	String nom = entry.getValue();
		    	SapforListeCandidat lst=new SapforListeCandidat(nom,  Color.green);
		    	lst.getRetenu().setVisible(false);
		    	 	int idUvInt=Integer.parseInt(idUv);
				    GererUvs.get((long)idUvInt).getRetenu().add(lst);
		     
		    	lst.getInscrit().addMouseListener(new MouseAdapter() {
		    		@Override
		    		public void mouseClicked(MouseEvent e) {

		    			DefaultCommandContext ctx = new DefaultCommandContext();
		    			List<String> infoTraitmt=new LinkedList<String>();
		    			infoTraitmt.add(idUv);
		    			infoTraitmt.add(entry.getKey().toString());
		    			String nouvelEtat="inscrit";
		    			infoTraitmt.add(nouvelEtat);
		    			String ancienEtat="retenu";
		    			infoTraitmt.add(ancienEtat);
		    			ctx.put(ICommandContextKey.Key_Trait,infoTraitmt );
		    			ICommand cmd = (ICommand) context.getBean("cmdTraitement");
		    			cmd.execute(ctx);
		    			System.out.println("OK traitement candidat ");				
		    		}
		    	});
		      	lst.getLstDa().addMouseListener(new MouseAdapter() {
		    		@Override
		    		public void mouseClicked(MouseEvent e) {

		    			DefaultCommandContext ctx = new DefaultCommandContext();
		    			List<String> infoTraitmt=new LinkedList<String>();
		    			infoTraitmt.add(idUv);
		    			infoTraitmt.add(entry.getKey().toString());
		    			String nouvelEtat="listeAttente";
		    			infoTraitmt.add(nouvelEtat);
		    			String ancienEtat="retenu";
		    			infoTraitmt.add(ancienEtat);
		    			ctx.put(ICommandContextKey.Key_Trait,infoTraitmt );
		    			ICommand cmd = (ICommand) context.getBean("cmdTraitement");
		    			cmd.execute(ctx);
		    			System.out.println("OK traitement candidat ");				
		    		}
		    	});
		     	lst.getRefuse().addMouseListener(new MouseAdapter() {
		    		@Override
		    		public void mouseClicked(MouseEvent e) {

		    			DefaultCommandContext ctx = new DefaultCommandContext();
		    			List<String> infoTraitmt=new LinkedList<String>();
		    			infoTraitmt.add(idUv);
		    			infoTraitmt.add(entry.getKey().toString());
		    			String nouvelEtat="nonRetenu";
		    			infoTraitmt.add(nouvelEtat);
		    			String ancienEtat="retenu";
		    			infoTraitmt.add(ancienEtat);
		    			ctx.put(ICommandContextKey.Key_Trait,infoTraitmt );
		    			ICommand cmd = (ICommand) context.getBean("cmdTraitement");
		    			cmd.execute(ctx);
		    			System.out.println("OK traitement candidat ");				
		    		}
		    	});
		
		        System.out.println("Display Candidat - Candidat "+nom);
		   
		    }
		}
	}
		
	


	@Override
	public void DisplayNonRetenu(final String idUv, HashMap<Long, String> cand) {
	if (cand==null){
			    SapforListeCandidat vide=new SapforListeCandidat ("Pas de candidat ");
			    vide.getInscrit().setVisible(false);
			    vide.getRetenu().setVisible(false);
			    vide.getLstDa().setVisible(false);
			    vide.getRefuse().setVisible(false);
			    int idUvInt=Integer.parseInt(idUv);
			    GererUvs.get((long)idUvInt).getRefuse().add(vide);
		}							
		else {
			for(final Entry<Long, String> entry : cand.entrySet()) {
			    	String nom = entry.getValue();
			    	SapforListeCandidat lst=new SapforListeCandidat(nom, Color.red);
			    	lst.getRefuse().setVisible(false);
			    		int idUvInt=Integer.parseInt(idUv);
			    		GererUvs.get((long)idUvInt).getRefuse().add(lst);
			    	
			    	lst.getInscrit().addMouseListener(new MouseAdapter() {
			    		@Override
			    		public void mouseClicked(MouseEvent e) {

			    			DefaultCommandContext ctx = new DefaultCommandContext();
			    			List<String> infoTraitmt=new LinkedList<String>();
			    			infoTraitmt.add(idUv);
			    			infoTraitmt.add(entry.getKey().toString());
			    			String nouvelEtat="inscrit";
			    			infoTraitmt.add(nouvelEtat);
			    			String ancienEtat="nonRetenu";
			    			infoTraitmt.add(ancienEtat);
			    			ctx.put(ICommandContextKey.Key_Trait,infoTraitmt );
			    			ICommand cmd = (ICommand) context.getBean("cmdTraitement");
			    			cmd.execute(ctx);
			    			System.out.println("OK traitement candidat ");				
			    		}
			    	});
			    	lst.getRetenu().addMouseListener(new MouseAdapter() {
			    		@Override
			    		public void mouseClicked(MouseEvent e) {

			    			DefaultCommandContext ctx = new DefaultCommandContext();
			    			List<String> infoTraitmt=new LinkedList<String>();
			    			infoTraitmt.add(idUv);
			    			infoTraitmt.add(entry.getKey().toString());
			    			String nouvelEtat="retenu";
			    			infoTraitmt.add(nouvelEtat);
			    			String ancienEtat="nonRetenu";
			    			infoTraitmt.add(ancienEtat);
			    			ctx.put(ICommandContextKey.Key_Trait,infoTraitmt );
			    			ICommand cmd = (ICommand) context.getBean("cmdTraitement");
			    			cmd.execute(ctx);
			    			System.out.println("OK traitement candidat ");				
			    		}
			    	});
			    	lst.getLstDa().addMouseListener(new MouseAdapter() {
			    		@Override
			    		public void mouseClicked(MouseEvent e) {

			    			DefaultCommandContext ctx = new DefaultCommandContext();
			    			List<String> infoTraitmt=new LinkedList<String>();
			    			infoTraitmt.add(idUv);
			    			infoTraitmt.add(entry.getKey().toString());
			    			String nouvelEtat="listeAttente";
			    			infoTraitmt.add(nouvelEtat);
			    			String ancienEtat="nonRetenu";
			    			infoTraitmt.add(ancienEtat);
			    			ctx.put(ICommandContextKey.Key_Trait,infoTraitmt );
			    			ICommand cmd = (ICommand) context.getBean("cmdTraitement");
			    			cmd.execute(ctx);
			    			System.out.println("OK traitement candidat ");				
			    		}
			    	});
				   
			}
		}
	}
		
	


	@Override
	public void DisplayListA(final String idUv, HashMap<Long, String> cand) {
			System.out.println(cand);
		if (cand==null){
			    SapforListeCandidat vide=new SapforListeCandidat ("Pas de candidat ");
			    vide.getInscrit().setVisible(false);
			    vide.getRetenu().setVisible(false);
			    vide.getLstDa().setVisible(false);
			    vide.getRefuse().setVisible(false);
			    int idUvInt=Integer.parseInt(idUv);
	    		GererUvs.get((long)idUvInt).getListeDA().add(vide);
			  
		}							
		else {
			for(final Entry<Long, String> entry : cand.entrySet()) {
			    	String nom = entry.getValue();
			    	SapforListeCandidat lst=new SapforListeCandidat(nom, Color.orange);
			    	lst.getLstDa().setVisible(false);
			    	System.out.println("Display Liste A - Candidat "+nom);
			    		int idUvInt=Integer.parseInt(idUv);
			    		GererUvs.get((long)idUvInt).getListeDA().add(lst);
			    	
			    	
			      	lst.getInscrit().addMouseListener(new MouseAdapter() {
			    		@Override
			    		public void mouseClicked(MouseEvent e) {

			    			DefaultCommandContext ctx = new DefaultCommandContext();
			    			List<String> infoTraitmt=new LinkedList<String>();
			    			infoTraitmt.add(idUv);
			    			infoTraitmt.add(entry.getKey().toString());
			    			String nouvelEtat="inscrit";
			    			infoTraitmt.add(nouvelEtat);
			    			String ancienEtat="listeAttente";
			    			infoTraitmt.add(ancienEtat);
			    			ctx.put(ICommandContextKey.Key_Trait,infoTraitmt );
			    			ICommand cmd = (ICommand) context.getBean("cmdTraitement");
			    			cmd.execute(ctx);
			    			System.out.println("OK traitement candidat ");				
			    		}
			    	});
			    	lst.getRetenu().addMouseListener(new MouseAdapter() {
			    		@Override
			    		public void mouseClicked(MouseEvent e) {

			    			DefaultCommandContext ctx = new DefaultCommandContext();
			    			List<String> infoTraitmt=new LinkedList<String>();
			    			infoTraitmt.add(idUv);
			    			infoTraitmt.add(entry.getKey().toString());
			    			String nouvelEtat="retenu";
			    			infoTraitmt.add(nouvelEtat);
			    			String ancienEtat="listeAttente";
			    			infoTraitmt.add(ancienEtat);
			    			ctx.put(ICommandContextKey.Key_Trait,infoTraitmt );
			    			ICommand cmd = (ICommand) context.getBean("cmdTraitement");
			    			cmd.execute(ctx);
			    			System.out.println("OK traitement candidat ");				
			    		}
			    	});
			    	lst.getRefuse().addMouseListener(new MouseAdapter() {
			    		@Override
			    		public void mouseClicked(MouseEvent e) {

			    			DefaultCommandContext ctx = new DefaultCommandContext();
			    			List<String> infoTraitmt=new LinkedList<String>();
			    			infoTraitmt.add(idUv);
			    			infoTraitmt.add(entry.getKey().toString());
			    			String nouvelEtat="nonRetenu";
			    			infoTraitmt.add(nouvelEtat);
			    			String ancienEtat="listeAttente";
			    			infoTraitmt.add(ancienEtat);
			    			ctx.put(ICommandContextKey.Key_Trait,infoTraitmt );
			    			ICommand cmd = (ICommand) context.getBean("cmdTraitement");
			    			cmd.execute(ctx);
			    			System.out.println("OK traitement candidat ");				
			    		}
			    	});
			    	
			}
		}
	}
	
	//id envoyé ici n'est pas le bon juste pour l'affichage appart pour le dernier uv
	//avec essai on vois que seul le dernier uv se rafraichie correctement on est auto dans le dernier uv
		public void Rafraichir(){
			for(Entry<Long, SapforGestionStage> entry : GererUvs.entrySet()) {
				entry.getValue().getListeDA().removeAll();
				entry.getValue().getRefuse().removeAll();
				entry.getValue().getRetenu().removeAll();
				entry.getValue().getInscrit().removeAll();
				entry.getValue().setVisible(false);
			}
			
			for(Entry<Long, SapforGestionStage> entry : GererUvs.entrySet()) {
				DefaultCommandContext ctx = new DefaultCommandContext();
				ctx.put(ICommandContextKey.Key_Cand, entry.getKey().toString());
				ICommand cmd = (ICommand) context.getBean("cmdDisplayCandidat");
				cmd.execute(ctx);
				entry.getValue().setVisible(true);
			}
			
			}
		
}
	

