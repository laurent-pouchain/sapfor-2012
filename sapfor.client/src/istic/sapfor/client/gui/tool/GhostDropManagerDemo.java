package istic.sapfor.client.gui.tool;
import java.awt.Point;
import javax.swing.JComponent;
import javax.swing.JOptionPane;

public class GhostDropManagerDemo extends AbstractGhostDropManager {
    private JComponent target;

    public GhostDropManagerDemo(JComponent target) {
        super(target);
    }

	public void ghostDropped(GhostDropEvent e) {
	   String action = e.getAction();
	   Point p = getTranslatedPoint(e.getDropLocation());

	   if (isInTarget(p)) {
	       JOptionPane.showMessageDialog(this.component, "Action: " + action);
	   }
	}
}