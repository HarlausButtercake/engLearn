package com.example.eng_proj;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

//public class MainMenuController implements ActionListener {
//
//    private MainMenu mainMenu;
//
//    public MainMenuController(MainMenu view) {
//        this.mainMenu = view;
//        view.getBtnKetQua().addActionListener(this);
//        view.addWindowListener(new WindowAdapter() {
//            @Override
//            public void windowClosing(WindowEvent e) {
//                System.exit(1);
//            }
//        });
//    }
//
//    @Override
//    public void actionPerformed(ActionEvent e) {
//        if (validateHangSoA() && validateHangSoB() && validateHangSoC()) {
//            mainMenu.getTextArea().setText(giaiPTBac2(hangsoA, hangsoB, hangsoC));
//        } else {
//            view.getTextArea().setText("");
//        }
//    }
//
//}
