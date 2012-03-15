package istic.sapfor.client.gui;

import java.awt.LayoutManager;
import javax.swing.JPanel;
import javax.swing.border.BevelBorder;

public class SapforJPanelUV extends JPanel {


	public SapforJPanelUV() {
		super();
		SapforLabel desc = new SapforLabel("Description du Stage");
		this.add(desc);
		this.setBounds(400, 50, 150, 300);
		this.setBorder(new javax.swing.border.BevelBorder(BevelBorder.RAISED));
		
		// TODO Auto-generated constructor stub
	}

	public SapforJPanelUV(boolean isDoubleBuffered) {
		super(isDoubleBuffered);
		// TODO Auto-generated constructor stub
	}

	public SapforJPanelUV(LayoutManager layout, boolean isDoubleBuffered) {
		super(layout, isDoubleBuffered);
		// TODO Auto-generated constructor stub
	}

	public SapforJPanelUV(LayoutManager layout) {
		super(layout);
		// TODO Auto-generated constructor stub
	}

	
	
}
