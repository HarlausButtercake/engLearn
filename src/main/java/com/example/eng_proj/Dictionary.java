package com.example.eng_proj;

import java.util.ArrayList;

public class Dictionary {      
    public ArrayList<Word> wordArr; 

    public Dictionary() {
        this.wordArr = new ArrayList<Word>();
    }

    public void addWord(Word word) {
        wordArr.add(word);
    }
}



