package istic.sapfor.client.gui.sapforcomponent;

import javax.swing.JTextArea;
import javax.swing.text.Document;

public class SapforJTextArea extends JTextArea {

	public SapforJTextArea() {
		super();

		// setBounds(x,y,longueur,largeur);
		// TODO Auto-generated constructor stub
	}

	public SapforJTextArea(Document doc, String text, int rows, int columns) {
		super(doc, text, rows, columns);
		// TODO Auto-generated constructor stub
	}

	public SapforJTextArea(Document doc) {
		super(doc);
		// TODO Auto-generated constructor stub
	}

	public SapforJTextArea(int rows, int columns) {
		super(rows, columns);
		// TODO Auto-generated constructor stub
	}

	public SapforJTextArea(String text, int rows, int columns) {
		super(text, rows, columns);
		// TODO Auto-generated constructor stub
	}

	public SapforJTextArea(String text) {
		super(text);
		// TODO Auto-generated constructor stub
	}

}
