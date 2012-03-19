package istic.sapfor.client.gui;

import istic.sapfor.client.command.impl.DefaultCommandContext;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.util.HashMap;

import javax.swing.JPanel;
import javax.swing.border.BevelBorder;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ContainerGestionAgent implements IHMAdmin{
	private ClassPathXmlApplicationContext context = null;
	private SapforJFrame frameGestionStage;
	private IHMAdmin ihmAdmin;
	
	public IHMAdmin getIhmAdmin() {
		return ihmAdmin;
	}

	public void setIhmAdmin(IHMAdmin ihmAdmin) {
		this.ihmAdmin = ihmAdmin;
	}

	private SapforJFrameAgent frame;
	private SapforJFrame frameAgent;
	private SapforButton accueil;
	

	@Override
	public void GererInscriptionUvDir(HashMap<Long, String> st) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void DisplayCandidat(String idTemp, HashMap<Long, String> cand) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void DisplayRetenu(String idTemp, HashMap<Long, String> cand) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void DisplayNonRetenu(String idTemp, HashMap<Long, String> cand) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void DisplayListA(String idTemp, HashMap<Long, String> cand) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void Rafraichir() {
		// TODO Auto-generated method stub
		
	}

	public void showUI(ClassPathXmlApplicationContext context2,
			DefaultCommandContext ctx, SapforJFrameAgent frame) {
			context = context2;
			this.frame= frame;
			frame.setVisible(false);
			frameAgent = new SapforJFrame("Gestion Agent");
			JPanel main= new JPanel();
			GridLayout mainLayout = new GridLayout(0,2);
			main.setLayout(mainLayout);
			JPanel candidat=new JPanel();
			JPanel addcandidat =new JPanel();
			candidat.setBorder(new javax.swing.border.BevelBorder(BevelBorder.RAISED));
			addcandidat.setBorder(new javax.swing.border.BevelBorder(BevelBorder.RAISED));
			
			main.add(candidat);
			main.add(addcandidat);
			
			
			BorderLayout agentLayout= new BorderLayout();
			frameAgent.setLayout(agentLayout);
			frameAgent.add(main, BorderLayout.CENTER);

			JPanel validPanel= new JPanel();
			validPanel.setBorder(new javax.swing.border.BevelBorder(BevelBorder.RAISED));

			accueil = new SapforButton ("accueil");
			
			validPanel.add(accueil);
			frameAgent.add(validPanel, BorderLayout.PAGE_END);
			frameAgent.setVisible(true);
		
	}

}
