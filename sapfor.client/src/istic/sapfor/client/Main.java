package istic.sapfor.client;
import istic.sapfor.api.service.ServiceAgent;
import istic.sapfor.client.command.ICommand;
import istic.sapfor.client.gui.ContainerGestionStage;
import istic.sapfor.client.gui.MainContainer;

import java.awt.BorderLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import org.springframework.context.support.ClassPathXmlApplicationContext;




public class Main {
	public static void main(String[] args) throws Exception {
		
		/* Init Spring Default Config */
	  
final ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(new String[] {"sapforclient.xml"});

		
ContainerGestionStage rootUI = (ContainerGestionStage) context.getBean("ui1");
rootUI.showUI(context);

		
	
}

	
}