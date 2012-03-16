package istic.sapfor.client.gui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.HeadlessException;

import javax.swing.JPanel;

public class SapforJFramAdmin extends SapforJFrame {

	private SapforGestionStage main;
	
	public SapforGestionStage getMain() {
		return main;
	}

	public void setMain(SapforGestionStage main) {
		this.main = main;
	}

	public SapforJFramAdmin(String ch) throws HeadlessException {
		super(ch);
		
		BorderLayout framLayout= new BorderLayout();
		this.setLayout(framLayout);

		//Make the center component big, since that's the
		//typical usage of BorderLayout.
		SapforGestionStage main = new SapforGestionStage("main");
		setMain(main);
		main.setPreferredSize(new Dimension(600, 600));
		this.add(main, BorderLayout.CENTER);

		

		JPanel validPanel= new JPanel();
		main.setPreferredSize(new Dimension(200, 600));
		this.add(validPanel, BorderLayout.PAGE_END);

		
		
		
		
	}

}
