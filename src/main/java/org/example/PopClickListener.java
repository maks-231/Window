package org.example;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.*;

class PopClickListener extends MouseAdapter {
  JLabel jlabel;
  Object parent;

  public PopClickListener(JLabel jlabel, Object parent) {
    this.jlabel = jlabel;
    this.parent = parent;
  }

  public void mousePressed(MouseEvent e) {
    if (e.isPopupTrigger()) {
      doPop(e);
    }
  }

  public void mouseReleased(MouseEvent e) {
    if (e.isPopupTrigger()) {
      doPop(e);
    }
  }

  private void doPop(MouseEvent e) {
    PopUpMenu menu = new PopUpMenu(jlabel, parent);
    menu.show(e.getComponent(), e.getX(), e.getY());
  }
}
