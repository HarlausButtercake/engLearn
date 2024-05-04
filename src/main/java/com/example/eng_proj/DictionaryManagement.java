package com.example.eng_proj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

//import static com.example.eng_proj.Main.dictionary;
import static com.example.eng_proj.Main.scanner;

public class DictionaryManagement {
    private static DictionaryManagement dictionaryManagement;

    public static DictionaryManagement get() {
        if (dictionaryManagement == null) {
            dictionaryManagement = new DictionaryManagement();
        }
        return dictionaryManagement;
    }

    public void sortAlpha() {
        Dictionary.get().sort((o1, o2)
                -> o1.getTarget().compareTo(
                o2.getTarget()));
    }

    public void showAllWordsSequence() {
        for (int i = 0; i < Dictionary.get().size(); i++) {
            Dictionary.get().get(i).rawPrintWord();
        }
    }

//    public int waitForIntInput(int min,int max) {
//
//        while (true) {
//
//            if (legit >= min && legit <= max) {
//                return legit;
//            } else {
//                System.out.println("Action not supported!");
//                scanner.next();
//            }
//        }
//
//    }




}

