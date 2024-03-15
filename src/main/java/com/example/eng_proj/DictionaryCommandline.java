package com.example.eng_proj;

public class DictionaryCommandline {

    public DictionaryCommandline() {
       
    }

    public void showAllWordsSequence() {
        for (int i = 0; i < Main.dictionary.wordArr.size(); i++) {
            Main.dictionary.wordArr.get(i).rawPrintWord();
        }
    }

    public void sortAlpha() {
        Main.dictionary.wordArr.sort((o1, o2)
                  -> o1.getTarget().compareTo(
                      o2.getTarget()));
    }

    public void showAllWords() {
        sortAlpha();
        showAllWordsSequence();
    }

    public void dictionarySearcher() {
        // Scanner scanner = new Scanner(System.in);

    }
}
