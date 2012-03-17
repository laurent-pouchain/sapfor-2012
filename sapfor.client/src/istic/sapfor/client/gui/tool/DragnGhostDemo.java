
package istic.sapfor.client.gui.tool;
import java.awt.*;
import java.awt.image.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;
import javax.swing.table.*;

public class DragnGhostDemo extends JFrame
{
    private GhostGlassPane glassPane;

    public DragnGhostDemo()
    {
		super("Drag n' Ghost Demo");
		setDefaultCloseOperation(EXIT_ON_CLOSE);

        glassPane = new GhostGlassPane();
        setGlassPane(glassPane);

        TableModel dataModel = new AbstractTableModel()
        {
            public int getColumnCount() { return 10; }
            public int getRowCount() { return 10;}
            public Object getValueAt(int row, int col) { return new Integer((row + 1) * (col + 1)); }
        };
        JTable table = new JTable(dataModel);

        GhostDropListener listener = new GhostDropManagerDemo(table);
        GhostPictureAdapter pictureAdapter;
        GhostComponentAdapter componentAdapter;

        JLabel label;
        Box box = Box.createVerticalBox();
        box.setBorder(new EmptyBorder(0, 0, 0, 20));

        box.add(label = UIHelper.createLabel("New Sale", "new_sale"));
        label.addMouseListener(pictureAdapter = new GhostPictureAdapter(glassPane, "new_sale", "images/new_sale.png"));
        pictureAdapter.addGhostDropListener(listener);
        label.addMouseMotionListener(new GhostMotionAdapter(glassPane));

        box.add(label = UIHelper.createLabel("View Sale", "view_sale"));
        label.addMouseListener(pictureAdapter = new GhostPictureAdapter(glassPane, "view_sale", "images/view_sale.png"));
        pictureAdapter.addGhostDropListener(listener);
        label.addMouseMotionListener(new GhostMotionAdapter(glassPane));

        box.add(label = UIHelper.createLabel("Quit", "quit"));
        label.addMouseListener(pictureAdapter = new GhostPictureAdapter(glassPane, "quit", "images/quit.png"));
        pictureAdapter.addGhostDropListener(listener);
        label.addMouseMotionListener(new GhostMotionAdapter(glassPane));

        Container c = getContentPane();
		c.setLayout(new BorderLayout());
		c.add(BorderLayout.WEST, box);

        JPanel buttons = new JPanel();
        JButton button;

        buttons.add(button = new JButton("Drag n' Drop"));
        button.addMouseListener(componentAdapter = new GhostComponentAdapter(glassPane, "button1"));
        componentAdapter.addGhostDropListener(listener);
        button.addMouseMotionListener(new GhostMotionAdapter(glassPane));

        buttons.add(button = new JButton("Ghost Alike"));
        button.addMouseListener(componentAdapter = new GhostComponentAdapter(glassPane, "button2"));
        componentAdapter.addGhostDropListener(listener);
        button.addMouseMotionListener(new GhostMotionAdapter(glassPane));

        c.add(BorderLayout.SOUTH, buttons);

        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.addMouseListener(new GhostComponentAdapter(glassPane, "table"));
        scrollPane.addMouseMotionListener(new GhostMotionAdapter(glassPane));

        c.add(BorderLayout.CENTER, scrollPane);

        JPanel headerPanel = new JPanel(new BorderLayout());
        HeaderPanel header = new HeaderPanel();
        headerPanel.add(BorderLayout.NORTH, header);
        headerPanel.add(BorderLayout.SOUTH, new JSeparator(JSeparator.HORIZONTAL));
        headerPanel.setBorder(new EmptyBorder(0, 0, 6, 0));
        c.add(BorderLayout.NORTH, headerPanel);

        pack();
        setResizable(false);
		setLocationRelativeTo(null);
    }

 	public static void main(String[] args)
	{
		DragnGhostDemo demo = new DragnGhostDemo();
		demo.setVisible(true);
	}
}