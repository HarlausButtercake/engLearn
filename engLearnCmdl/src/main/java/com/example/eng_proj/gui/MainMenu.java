package com.example.eng_proj.gui;

import com.example.eng_proj.Dictionary;
import com.example.eng_proj.Word;

import javax.swing.*;
import java.awt.*;
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
//        this.setJMenuBar(new JMenuBar());
        setContentPane(panel1);
        setBounds(20,20,1024,768);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        setVisible(true);
//
//        final DefaultListModel wordList = new DefaultListModel();
//        wordList.addElement("Green");
//        wordList.addElement("Red");
//        wordList.addElement("Yellow");
//        wordList.addElement("Black");
//        list1 = new JList(wordList);
//        list1.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
//        list1.setSelectedIndex(0);
//        list1.setVisibleRowCount(3);
//
//        JScrollPane listScroll = new JScrollPane(list1);

        ArrayList<String> wordList = new ArrayList<>();
        for (Word word: Dictionary.get()) {
            wordList.add(word.getTarget());
        }

//        wordList.add("Homo");
//        wordList.add("Homo");
//        wordList.add("Homo");
//        wordList.add("Homo");
//        wordList.add("Homo");
//        wordList.add("Homo");

        String[] data = wordList.toArray(new String[wordList.size()]);

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

    private void createUIComponents() {
        // TODO: place custom component creation code here
    }
}
