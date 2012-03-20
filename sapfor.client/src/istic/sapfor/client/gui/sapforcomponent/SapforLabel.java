package istic.sapfor.client.gui.sapforcomponent;

import java.awt.Color;
import java.awt.HeadlessException;
import java.awt.Label;

public class SapforLabel extends Label {

	public SapforLabel() throws HeadlessException {
		super();
		// TODO Auto-generated constructor stub
	}

	public SapforLabel(String text, int alignment) throws HeadlessException {
		super(text, alignment);
		// TODO Auto-generated constructor stub
	}

	public SapforLabel(String text) throws HeadlessException {
		super(text);
		// TODO Auto-generated constructor stub
	}

	public SapforLabel(String text, Color c) {
		super(text);
		this.setBackground(c);
		// TODO Auto-generated constructor stub
	}

}
