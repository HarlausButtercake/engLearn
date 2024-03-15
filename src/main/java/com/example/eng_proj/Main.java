package com.example.eng_proj;

import java.util.Scanner;

public class Main {
    public static Scanner scanner = new Scanner(System.in);
    public static Dictionary dictionary = new Dictionary();

    public static void main(String[] args) {
        
        DictionaryCommandline dictionaryCommandline = new DictionaryCommandline();
        DictionaryManagement dictionaryManagement = new DictionaryManagement();
        
        int intput;
        out:
        while(true) {
            System.out.println(
                        "=============================================\r\n" + //
                        "Welcome to My Application!\r\n" + //
                        "[0] Exit\r\n" + //
                        "[1] Show all words sequentially\r\n" + //
                        "[2] Add words manually\r\n" + //
                        "[3] Remove\r\n" + //
                        "[4] Update\r\n" + //
                        "[5] Flush dictionary\r\n" + //
                        "[6] Lookup\r\n" + //
                        "[7] Search\r\n" + //
                        "[8] Game\r\n" + //
                        "[9] Import from file\r\n" + //
                        "=============================================");    
                        
            while (!scanner.hasNextInt()) {
                System.out.println("Action not supported!");
                scanner.next();
            }                
            intput = scanner.nextInt();
            switch (intput) {
                case 0:
                    break out;
                case 1:
                    dictionaryCommandline.showAllWords();
                    break;
                case 2:
                    dictionaryManagement.insertFromCommandline();
                    break;
                case 7:
                    dictionaryCommandline.dictionarySearcher();
                    break;
                case 9:
                    dictionaryManagement.insertFromFile();
                    break;
                default:
                    System.out.println("Malussy");
            }      
        } 
        scanner.close();
    }
}