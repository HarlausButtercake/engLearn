package com.example.eng_proj;

import java.util.Scanner;
// import javax.swing.*;

public class Main {
    public static Scanner scanner = new Scanner(System.in);
    public static Dictionary dictionary = new Dictionary();
    public static BasicQuestionManagement basicQuestionManagement = new BasicQuestionManagement();

    public static void main(String[] args) {
        

//
        basicQuestionManagement.insertQuestionFromFile();

        new CmdLine();

//        dictionaryManagement.insertWordFromFile();
//        new MainMenu();

        scanner.close();
    }
}