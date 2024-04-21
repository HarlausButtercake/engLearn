package com.example.eng_proj;

import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;

public class dumbfuck {

    private JFrame mainFrame;
    private JLabel headerLabel;
    private JLabel statusLabel;
    private JPanel controlPanel;

    public dumbfuck(){
        prepareGUI();
    }

    private void prepareGUI() {
        mainFrame = new JFrame("Vi du JList trong Java Swing");
        mainFrame.setSize(500, 300);
        mainFrame.setLayout(new GridLayout(3, 1));
        mainFrame.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent windowEvent) {
                System.exit(0);
            }
        });
        headerLabel = new JLabel("", JLabel.CENTER);
        statusLabel = new JLabel("", JLabel.CENTER);
        statusLabel.setSize(350, 100);
        controlPanel = new JPanel();
        controlPanel.setLayout(new FlowLayout());
        mainFrame.add(headerLabel);
        mainFrame.add(controlPanel);
        mainFrame.add(statusLabel);
        mainFrame.setVisible(true);
    }

    void showListDemo() {
        headerLabel.setText("Control in action: JList");
        final DefaultListModel colorsName = new DefaultListModel();
        colorsName.addElement("Green");
        colorsName.addElement("Red");
        colorsName.addElement("Yello");
        colorsName.addElement("Black");
        final JList fruitList = new JList(colorsName);
        fruitList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        fruitList.setSelectedIndex(0);
        fruitList.setVisibleRowCount(3);
        JScrollPane fruitListScrollPane = new JScrollPane(fruitList);
        JButton showButton = new JButton("Show");
        showButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String data = "";
                if (fruitList.getSelectedIndex() != -1) {
                    data = "Colors Selected: " + fruitList.getSelectedValue();
                    statusLabel.setText(data);
                }

                statusLabel.setText(data);
            }
        });
        controlPanel.add(fruitListScrollPane);
        controlPanel.add(showButton);
        mainFrame.setVisible(true);
    }
}
