/*
 * 11:57:38 07/08/00
 *
 * JextHighlightButton.java - Ce bouton a la propriété de "s'éclairer" au passage de la souris
 * Copyright (C) 2000 Romain Guy
 * guy.romain@bigfoot.com
 * www.jext.org
 *
 * This program is free software; you can redistribute it and/or
 * modify it under the terms of the GNU General Public License
 * as published by the Free Software Foundation; either version 2
 * of the License, or any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program; if not, write to the Free Software
 * Foundation, Inc., 59 Temple Place - Suite 330, Boston, MA  02111-1307, USA.
 */

package istic.sapfor.client.gui;

import javax.swing.Icon; 
import javax.swing.JButton;
import java.awt.Color;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * Bouton réactif changeant de couleur au passage de la souris.
 * La couleur est un bleu-violet adapté aux couleurs de Metal.
 */

public class SapforButton extends JButton
{
  private Color nColor;
  // couleur lors du passage de la souris
  private Color hColor = new Color(192, 192, 210);

  public SapforButton()
  {
    super();
    // on récupère la couleur de fond du bouton, on en aura besoin !
    nColor = getBackground();
    addMouseListener(new MouseHandler());
  }

  public SapforButton(String label)
  {
    super(label);
    nColor = getBackground();
    addMouseListener(new MouseHandler());
  }

  public SapforButton(Icon icon)
  {
    super(icon);
    nColor = getBackground();
    addMouseListener(new MouseHandler());
  }

  public SapforButton(String label, Icon icon)
  {
    super(label, icon);
    nColor = getBackground();
    addMouseListener(new MouseHandler());
  }
  
  

  class MouseHandler extends MouseAdapter
  {
    public void mouseEntered(MouseEvent me)
    {
      // si la souris passe au dessus du bouton et que le bouton est actif...
      if (isEnabled())
      {
        // on change la couleur en couleur bleu-violet
        setBackground(hColor);
      }
    }

    public void mouseExited(MouseEvent me)
    {
      // si la souris sort du bouton et que le bouton est actif...
      if (isEnabled())
      {
        // on rétablit la couleur d'origine
        setBackground(nColor);
      }
    }
  }
}

// End of JextHighlightButton.java
