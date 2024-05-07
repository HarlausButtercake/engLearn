package com.example.eng_proj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

//import static com.example.eng_proj.Main.dictionary;
import static com.example.eng_proj.Main.scanner;

public class DictionaryManagement {

    private static DictionaryManagement instance;
    public static DictionaryManagement get() {
        if (instance == null) {
            instance = new DictionaryManagement();
        }
        return instance;
    }

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

    public void showWordArray(ArrayList<Word> words) {
        for (Word word : words) {
            word.fullPrintWord();
        }
    }



}

