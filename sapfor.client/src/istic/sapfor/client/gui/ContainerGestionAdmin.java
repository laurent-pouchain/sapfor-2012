package istic.sapfor.client.gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map.Entry;

import javax.swing.JTabbedPane;

import istic.sapfor.api.dto.EtatCandidatureDTO;
import istic.sapfor.client.command.ICommand;
import istic.sapfor.client.command.ICommandContextKey;
import istic.sapfor.client.command.impl.DefaultCommandContext;
import istic.sapfor.client.gui.tool.GhostComponentAdapter;
import istic.sapfor.client.gui.tool.GhostDropListener;
import istic.sapfor.client.gui.tool.GhostDropManagerDemo;
import istic.sapfor.client.gui.tool.GhostGlassPane;
import istic.sapfor.client.gui.tool.GhostMotionAdapter;
import istic.sapfor.client.gui.tool.GhostPictureAdapter;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ContainerGestionAdmin implements IHMAdmin {

	
private ClassPathXmlApplicationContext context = null;
private SapforJFrame frameGestionStage;
private JTabbedPane Onglets = null;
private SapforGestionStage GererUv;

private GhostGlassPane glassPane;
private GhostDropListener listener;
private GhostDropListener listenerJPRetenu;
private GhostDropListener listenerJPListeDA;
private GhostDropListener listenerJPRefuse;
private GhostDropListener listenerJPInscrit;
private GhostComponentAdapter componentAdapter;
private GhostComponentAdapter componentAdaptInscritToRetenu;
private GhostComponentAdapter componentAdaptInscritToListeDA;
private GhostComponentAdapter componentAdaptInscritToRefuse;
private GhostComponentAdapter componentAdapterRetenuToListeDA;
private GhostComponentAdapter componentAdapterRetenuToInscrit;
private GhostComponentAdapter componentAdapterRetenuToRefuse;
private GhostComponentAdapter componentAdapterListeDAToInscrit;
private GhostComponentAdapter componentAdapterListeDAToRefuse;
private GhostComponentAdapter componentAdapterListeDAToRetenu;
private GhostComponentAdapter componentAdapterRefuseToInscrit;
private GhostComponentAdapter componentAdapterRefuseToRetenu;
private GhostComponentAdapter componentAdapterRefuseToListeDA;

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
			frameGestionStage = new SapforJFrame("Gestion Stage");
			glassPane = new GhostGlassPane();
		    frameGestionStage.setGlassPane(glassPane);
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
					for(Entry<Long, String> entry : uvDir.entrySet()) {
						String idOnglet="Onglet "+i;
						System.out.println(idOnglet);
						GererUv=new SapforGestionStage(entry.getValue());
			            Onglets.addTab(entry.getValue(), null, GererUv, null); 
			            i++;
			        	DefaultCommandContext ctx = new DefaultCommandContext();
			        	String idUv=entry.getKey().toString();
			        	System.out.println("avant l'affichage");
			        	System.out.println("------------------------------------------------");
			        	ctx.put(ICommandContextKey.Key_Cand, idUv);
			            ICommand cmd = (ICommand) context.getBean("cmdDisplayCandidat");
			    		cmd.execute(ctx);
			    		System.out.println("------------------------------------------------");
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
		listener = new GhostDropManagerDemo(GererUv);
		listenerJPRefuse = new GhostDropManagerDemo(GererUv.getRefuse());
		listenerJPRetenu = new GhostDropManagerDemo(GererUv.getRetenu());
		listenerJPListeDA = new GhostDropManagerDemo(GererUv.getListeDA());
		if (cand==null){
			    SapforListeCandidat vide=new SapforListeCandidat ("Pas de candidat");
			    /*vide.addMouseListener(componentAdaptInscritToRetenu = new GhostComponentAdapter(glassPane, "Inscrit -> Retenu"));
			    vide.addMouseListener(componentAdaptInscritToListeDA = new GhostComponentAdapter(glassPane, "Inscrit -> ListeDA"));
			    vide.addMouseListener(componentAdaptInscritToRefuse = new GhostComponentAdapter(glassPane, "Inscrit -> Refuse"));
			    
			    componentAdaptInscritToRetenu.addGhostDropListener(listenerJPRetenu);
			    componentAdaptInscritToListeDA.addGhostDropListener(listenerJPListeDA);
			    componentAdaptInscritToRefuse.addGhostDropListener(listenerJPRefuse);*/
			    GererUv.getInscrit().add(vide);
		}							
		else {	
			for(Entry<Long, String> entry : cand.entrySet()) {
		    	String nom = entry.getValue();
		    	SapforListeCandidat lst=new SapforListeCandidat(nom, Color.green);
		    	
		    	//lst.addMouseListener(componentAdaptInscritToRetenu = new GhostComponentAdapter(glassPane, "Inscrit -> Retenu"));
			    //lst.addMouseListener(componentAdaptInscritToListeDA = new GhostComponentAdapter(glassPane, "Inscrit -> ListeDA"));
			    //lst.addMouseListener(componentAdaptInscritToRefuse = new GhostComponentAdapter(glassPane, "Inscrit -> Refuse"));
		    	lst.addMouseListener(componentAdapter = new GhostComponentAdapter(glassPane, "Done"));
		    	
		    	//componentAdaptInscritToRetenu.addGhostDropListener(listenerJPRetenu);
			    //componentAdaptInscritToListeDA.addGhostDropListener(listenerJPListeDA);
			    //componentAdaptInscritToRefuse.addGhostDropListener(listenerJPRefuse);
		        componentAdapter.addGhostDropListener(listener);
		        lst.addMouseMotionListener(new GhostMotionAdapter(glassPane));
		        System.out.println("Display Candidat - Candidat "+nom);
		    	GererUv.getInscrit().add(lst);
		    }
		}
	}


	@Override
	public void DisplayRetenu(HashMap<Long, String> cand) {
		listenerJPInscrit = new GhostDropManagerDemo(GererUv.getInscrit());
		GererUv.getInscrit().setBackground(Color.gray);
		listenerJPListeDA = new GhostDropManagerDemo(GererUv.getListeDA());
		GererUv.getListeDA().setBackground(Color.blue);
		listenerJPRefuse = new GhostDropManagerDemo(GererUv.getRefuse());
		GererUv.getRefuse().setBackground(Color.red);
		//listener = new GhostDropManagerDemo(GererUv);
		if (cand==null){
			    SapforListeCandidat vide=new SapforListeCandidat ("Pas de candidat ");
			    /*vide.addMouseListener(componentAdapterRetenuToInscrit = new GhostComponentAdapter(glassPane, "Retenu -> Inscrit"));
			    vide.addMouseListener(componentAdapterRetenuToListeDA = new GhostComponentAdapter(glassPane, "Retenu -> ListeDA"));
			    vide.addMouseListener(componentAdapterRetenuToRefuse = new GhostComponentAdapter(glassPane, "Retenu -> Refuse"));
			    componentAdapterRetenuToInscrit.addGhostDropListener(listenerJPInscrit);
			    componentAdapterRetenuToListeDA.addGhostDropListener(listenerJPListeDA);
			    componentAdapterRetenuToRefuse.addGhostDropListener(listenerJPRefuse);*/		        
		        
			    GererUv.getRetenu().add(vide);
		}							
		else {
			for(Entry<Long, String> entry : cand.entrySet()) {
				
		    	String nom = entry.getValue();
		    	SapforListeCandidat lst=new SapforListeCandidat(nom,  Color.green);
		    	lst.addMouseListener(componentAdapterRetenuToInscrit = new GhostComponentAdapter(glassPane, "Retenu -> Inscrit"));
			    lst.addMouseListener(componentAdapterRetenuToListeDA = new GhostComponentAdapter(glassPane, "Retenu -> ListeDA"));
			    lst.addMouseListener(componentAdapterRetenuToRefuse = new GhostComponentAdapter(glassPane, "Retenu -> Refuse"));
		    	//lst.addMouseListener(componentAdapter = new GhostComponentAdapter(glassPane, "Done"));
		    	
			    componentAdapterRetenuToInscrit.addGhostDropListener(listenerJPInscrit);
			    componentAdapterRetenuToListeDA.addGhostDropListener(listenerJPListeDA);
			    componentAdapterRetenuToRefuse.addGhostDropListener(listenerJPRefuse);
						    
			    lst.addMouseMotionListener(new GhostMotionAdapter(glassPane));
		        System.out.println("Display Candidat - Candidat "+nom);
		    	GererUv.getRetenu().add(lst);
		    }
		}
	}
		
	


	@Override
	public void DisplayNonRetenu(HashMap<Long, String> cand) {
		/*listenerJPInscrit = new GhostDropManagerDemo(GererUv.getInscrit());
		listenerJPRetenu = new GhostDropManagerDemo(GererUv.getRetenu());
		listenerJPListeDA = new GhostDropManagerDemo(GererUv.getListeDA());*/
		listener = new GhostDropManagerDemo(GererUv);
		if (cand==null){
			    SapforListeCandidat vide=new SapforListeCandidat ("Pas de candidat ");
			    /*vide.addMouseListener(componentAdapterRefuseToInscrit = new GhostComponentAdapter(glassPane, "Refuse -> Inscrit"));
			    vide.addMouseListener(componentAdapterRefuseToListeDA = new GhostComponentAdapter(glassPane, "Refuse -> ListeDA"));
			    vide.addMouseListener(componentAdapterRefuseToRetenu = new GhostComponentAdapter(glassPane, "Refuse -> Retenu"));
			    componentAdapterRefuseToInscrit.addGhostDropListener(listenerJPInscrit);
			    componentAdapterRefuseToListeDA.addGhostDropListener(listenerJPListeDA);
			    componentAdapterRefuseToRetenu.addGhostDropListener(listenerJPRetenu);*/

			    GererUv.getRefuse().add(vide);
		}							
		else {
			for(Entry<Long, String> entry : cand.entrySet()) {
			    	String nom = entry.getValue();
			    	SapforListeCandidat lst=new SapforListeCandidat(nom, Color.red);
			    	
			    	lst.addMouseListener(componentAdapterRefuseToInscrit = new GhostComponentAdapter(glassPane, "Refuse -> Inscrit"));
				    lst.addMouseListener(componentAdapterRefuseToListeDA = new GhostComponentAdapter(glassPane, "Refuse -> ListeDA"));
				    lst.addMouseListener(componentAdapterRefuseToRetenu = new GhostComponentAdapter(glassPane, "Refuse -> Retenu"));
				    //lst.addMouseListener(componentAdapter = new GhostComponentAdapter(glassPane, "Done"));
				    componentAdapterRefuseToInscrit.addGhostDropListener(listenerJPInscrit);
				    componentAdapterRefuseToListeDA.addGhostDropListener(listenerJPListeDA);
				    componentAdapterRefuseToRetenu.addGhostDropListener(listenerJPRetenu);
				    //componentAdapter.addGhostDropListener(listener);
				    lst.addMouseMotionListener(new GhostMotionAdapter(glassPane));
				    System.out.println("Display Non retenu - Candidat "+nom);
			    	GererUv.getRefuse().add(lst);
			}
		}
	}
		
	


	@Override
	public void DisplayListA(HashMap<Long, String> cand) {
		listenerJPInscrit = new GhostDropManagerDemo(GererUv.getInscrit());
		listenerJPRefuse = new GhostDropManagerDemo(GererUv.getRefuse());
		listenerJPRetenu = new GhostDropManagerDemo(GererUv.getRetenu());
		//listener = new GhostDropManagerDemo(GererUv);
		System.out.println(cand);
		if (cand==null){
			    SapforListeCandidat vide=new SapforListeCandidat ("Pas de candidat ");
/*			    vide.addMouseListener(componentAdapterListeDAToInscrit = new GhostComponentAdapter(glassPane, "ListeDA -> Inscrit"));
			    vide.addMouseListener(componentAdapterListeDAToRefuse = new GhostComponentAdapter(glassPane, "ListeDA -> Refuse"));
			    vide.addMouseListener(componentAdapterListeDAToRetenu = new GhostComponentAdapter(glassPane, "ListeDA -> Retenu"));
			    componentAdapterListeDAToInscrit.addGhostDropListener(listenerJPInscrit);
			    componentAdapterListeDAToRefuse.addGhostDropListener(listenerJPRefuse);
			    componentAdapterRefuseToRetenu.addGhostDropListener(listenerJPRetenu);*/
		        
			    GererUv.getListeDA().add(vide);
		}							
		else {
			for(Entry<Long, String> entry : cand.entrySet()) {
			    	String nom = entry.getValue();
			    	SapforListeCandidat lst=new SapforListeCandidat(nom, Color.orange);
			    	lst.addMouseListener(componentAdapterListeDAToInscrit = new GhostComponentAdapter(glassPane, "ListeDA -> Inscrit"));
				    lst.addMouseListener(componentAdapterListeDAToRefuse = new GhostComponentAdapter(glassPane, "ListeDA -> Refuse"));
				    lst.addMouseListener(componentAdapterListeDAToRetenu = new GhostComponentAdapter(glassPane, "ListeDA -> Retenu"));
				    
				    //lst.addMouseListener(componentAdapter = new GhostComponentAdapter(glassPane, "Done"));
				    //componentAdapterListeDAToInscrit.addGhostDropListener(listenerJPInscrit);
				    //componentAdapterListeDAToRefuse.addGhostDropListener(listenerJPRefuse);
				    //componentAdapterListeDAToRetenu.addGhostDropListener(listenerJPRetenu);
				    
				    lst.addMouseMotionListener(new GhostMotionAdapter(glassPane));    
				    //componentAdapter.addGhostDropListener(listener);    
			        System.out.println("Display Liste A - Candidat "+nom);
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
	

