package istic.sapfor.client.gui;

import java.awt.GraphicsConfiguration;
import java.awt.HeadlessException;

import javax.swing.JFrame;

public class SapforJFrame extends JFrame{

	public SapforJFrame(String titre) throws HeadlessException {
		super();
setDefaultCloseOperation(EXIT_ON_CLOSE);
        //pack();
        //this.setExtendedState(this.getExtendedState() | this.MAXIMIZED_BOTH);
		setSize(800,600);
        setPreferredSize(getSize());
        setResizable(false);
        setTitle(titre);
        pack();
		// TODO Auto-generated constructor stub
	}
	
}
