package istic.sapfor.client.gui.tool;
import java.awt.Point;
import java.awt.Rectangle;

import javax.swing.JComponent;
import javax.swing.SwingUtilities;


public abstract class AbstractGhostDropManager implements GhostDropListener {
	protected JComponent component;

	public AbstractGhostDropManager() {
		this(null);
	}
	
	public AbstractGhostDropManager(JComponent component) {
		this.component = component;
	}

	protected Point getTranslatedPoint(Point point) {
        Point p = (Point) point.clone();
        SwingUtilities.convertPointFromScreen(p, component);
		return p;
	}

	protected boolean isInTarget(Point point) {
		Rectangle bounds = component.getBounds();
		return bounds.contains(point);
	}

	public void ghostDropped(GhostDropEvent e) {
	}
}