package com.example.eng_proj;

public class DictionaryCommandline {


    public DictionaryCommandline() {
       
    }

    public void showAllWordsSequence(Dictionary dictionary) {
        for (int i = 0; i < dictionary.wordArr.size(); i++) {
            dictionary.wordArr.get(i).rawPrintWord();
        }
    }
    public void showAllWords() {

    }
}
