package org.example;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.*;
import javax.swing.border.Border;

public class Window extends JFrame implements ActionListener {
  private static final String TITLE = "A window displaying a list of objects";

  private final List<JLabel> list;
  private int count;

  public Window() {
    super(TITLE);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    list = new ArrayList<>();

    addNewItem(list);
    addNewItem(list);
    addNewItem(list);
    addNewItem(list);

    repack();

    setSize(400, 200);
    addMouseListener(new PopClickListener(null, this));
    setLocationRelativeTo(null);
  }

  public static void main(String[] args) {
    new Window().show();
  }

  public void removeItem(JLabel jLabel) {
    list.remove(jLabel);
    repack();
  }

  private void repack() {
    int width = getWidth();
    int height = getHeight();

    getContentPane().removeAll();
    getContentPane().add(generatePanel(list));
    pack();
    setSize(width, height);
  }

  private JPanel generatePanel(List<JLabel> list) {
    JPanel panel = new JPanel();
    panel.setLayout(new FlowLayout());

    list.stream().forEach(item -> panel.add(item));
    panel.setLayout(new GridLayout(list.size(), 1, 2, 2));
    return panel;
  }

  private void addNewItem(List<JLabel> list) {
    Border blackLine = BorderFactory.createLineBorder(Color.black);
    count++;
    JLabel label = new JLabel("Label " + count);
    label.setSize(100, 70);
    label.setBorder(blackLine);
    label.addMouseListener(new PopClickListener(label, this));
    list.add(label);
  }

  public void addNewItem() {
    addNewItem(list);
    repack();
  }

  @Override
  public void actionPerformed(ActionEvent e) {
    System.out.println(e);
  }
}