package org.example;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

class PopUpMenu extends JPopupMenu {
  private static String ADD_NEW_ITEM = "Add New Item";
  private static String REMOVE_ITEM = "Remove Item";
  private static String EDIT_ITEM = "Edit Item";

  JMenuItem addItem;
  JMenuItem removeItem;
  JMenuItem editItem;
  JLabel jLabel;
  Object parent;

  public PopUpMenu(JLabel jLabel, Object parent) {
    this.jLabel = jLabel;
    this.parent = parent;

    addItem = new JMenuItem(ADD_NEW_ITEM);
    add(addItem).addActionListener(new PopUpMenuActionListener());

    if (jLabel != null) {
      removeItem = new JMenuItem(REMOVE_ITEM);
      editItem = new JMenuItem(EDIT_ITEM);
      add(removeItem).addActionListener(new PopUpMenuActionListener());
      add(editItem).addActionListener(new PopUpMenuActionListener());
      ;
    }
  }

  private class PopUpMenuActionListener implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
      if (e.getActionCommand().equals(REMOVE_ITEM)) {
        ((Window) parent).removeItem(jLabel);
      } else if (e.getActionCommand().equals(ADD_NEW_ITEM)) {
        ((Window) parent).addNewItem();
      } else if (e.getActionCommand().equals(EDIT_ITEM)) {
        String m = JOptionPane.showInputDialog(((Window) parent), "Edit Item", jLabel.getText());
        if (!m.isEmpty()) {
          jLabel.setText(m);
        }
      }
    }
  }
}
