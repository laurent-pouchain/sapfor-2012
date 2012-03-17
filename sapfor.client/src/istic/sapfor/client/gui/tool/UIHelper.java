package istic.sapfor.client.gui.tool;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Toolkit;

import java.net.URL;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;

public final class UIHelper
{
    public static JButton createButton(String text)
    {
        JButton button = new JButton(text);
        button.setFocusPainted(true);
        button.setBorderPainted(true);
        button.setContentAreaFilled(true);
        return button;
    }

    public static JButton createButton(String text, String icon)
    {
        return createButton(text, icon, false);
    }

    public static JButton createButton(String text, String icon, boolean flat)
    {
        ImageIcon iconNormal = readImageIcon(icon + ".png");
        ImageIcon iconHighlight = readImageIcon(icon + "_highlight.png");
        ImageIcon iconPressed = readImageIcon(icon + "_pressed.png");

        JButton button = new JButton(text, iconNormal);
        button.setFocusPainted(!flat);
        button.setBorderPainted(!flat);
        button.setContentAreaFilled(!flat);
        if (iconHighlight != null) 
        {
            button.setRolloverEnabled(true);
            button.setRolloverIcon(iconHighlight);
        }
        if (iconPressed != null)
            button.setPressedIcon(iconPressed);
        return button;
    }

    public static JLabel createLabel(String text, String icon)
    {
        ImageIcon iconNormal = readImageIcon(icon + ".png");
        JLabel label = new JLabel(text, iconNormal, JLabel.LEFT);
        return label;
    }

    public static ImageIcon readImageIcon(String filename)
    {
        return new ImageIcon(Toolkit.getDefaultToolkit().getImage(UIHelper.class.getResource("images/" + filename)));
    }
}
