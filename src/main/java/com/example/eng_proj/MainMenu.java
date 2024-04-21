package com.example.eng_proj;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

public class MainMenu extends JFrame {
    private JPanel panel1;
    private JPanel right;
    private JPanel left;
    private JTextField userInput;
    private JList list1;
    private JScrollPane listScroll;

    public MainMenu() {
        super("EngLearn");
        setContentPane(panel1);
        setBounds(20,20,1024,768);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        setVisible(true);
//
//        final DefaultListModel colorsName = new DefaultListModel();
//        colorsName.addElement("Green");
//        colorsName.addElement("Red");
//        colorsName.addElement("Yellow");
//        colorsName.addElement("Black");
//        list1 = new JList(colorsName);
//        list1.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
//        list1.setSelectedIndex(0);
//        list1.setVisibleRowCount(3);
//
//        JScrollPane listScroll = new JScrollPane(list1);

        ArrayList<String> colorsName = new ArrayList<>();
        colorsName.add("Green");
        colorsName.add("Red");
        colorsName.add("Yellow");
        colorsName.add("Black");
        colorsName.add("Green");
        colorsName.add("Red");
        colorsName.add("Yellow");
        colorsName.add("Black");
        colorsName.add("Green");
        colorsName.add("Red");
        colorsName.add("Yellow");
        colorsName.add("Black");
        colorsName.add("Green");
        colorsName.add("Red");
        colorsName.add("Yellow");
        colorsName.add("Black");
        colorsName.add("Green");
        colorsName.add("Red");
        colorsName.add("Yellow");
        colorsName.add("Black");
        colorsName.add("Green");
        colorsName.add("Red");
        colorsName.add("Yellow");
        colorsName.add("Black");
        colorsName.add("Green");
        colorsName.add("Red");
        colorsName.add("Yellow");
        colorsName.add("Black");
        colorsName.add("Green");
        colorsName.add("Red");
        colorsName.add("Yellow");
        colorsName.add("Black");

        String[] data = colorsName.toArray(new String[colorsName.size()]);

        Font currentFont = list1.getFont();
        Font newFont = currentFont.deriveFont(20f);
        list1.setFont(newFont);


        list1.setListData(data);
        list1.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        list1.setSelectedIndex(0);
        list1.setVisibleRowCount(3);


//        panel1 = new JPanel(new BorderLayout());
//        panel1.add(new JScrollPane(list1));

        // Set the content pane of the frame
        setContentPane(panel1);

        // Make the frame visible
        setVisible(true);


    }
}
