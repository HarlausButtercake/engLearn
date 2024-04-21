package com.example.englearngui;

import java.util.ArrayList;

public class Dictionary {      
    private ArrayList<Word> wordArr; 
    


    public Dictionary() {
        this.wordArr = new ArrayList<Word>();
    }

    public ArrayList<Word> getArr() {
        return wordArr;
    }

    public void addWord(Word word) {
        wordArr.add(word);
    }

    public void removeWord(Word word) {
        wordArr.remove(word);
    }
    public void removeWord(int word) {
        wordArr.remove(word);
    }

    public Word getWord(int i) {
        return wordArr.get(i);
    }
    public int getSize() {
        return wordArr.size();
    }
}



