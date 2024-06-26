package com.example.demo.Manager;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;



public class DictionaryManagement {


    public void sortAlpha() {
        Dictionary.get().sort((o1, o2)
                -> o1.getTarget().compareTo(
                o2.getTarget()));
    }

    public void showAllWordsSequence() {
        for (int i = 0; i < Dictionary.get().size(); i++) {
//            Dictionary.get().get(i).simplePrintWord();

            Dictionary.get().get(i).fullPrintWord();
        }
    }

    public ArrayList<Word> searchKeyword(String key) {
        ArrayList<Word> returnee = new ArrayList<>();
        for (Word word : Dictionary.get()) {
            if (word.getTarget().toLowerCase().startsWith(key.toLowerCase())) {
                returnee.add(word);
            }
        }
        return returnee;
    }
}

