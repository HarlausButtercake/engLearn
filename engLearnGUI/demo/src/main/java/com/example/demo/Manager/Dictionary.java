package com.example.demo.Manager;

import java.util.ArrayList;

public class Dictionary extends ArrayList<Word> {

    private static Dictionary dictionary;

    public static Dictionary get() {
        if (dictionary == null) {
            dictionary = new Dictionary();
        }
//        return this;
        return dictionary;
    }

    public static ArrayList<String> getTargetArray(ArrayList<Word> words) {
        ArrayList<String> rere = new ArrayList<>();
        for (Word word: words) {
            rere.add(word.getTarget());
        }
        return rere;
    }
//    private ArrayList<Word> wordArr;

//    public Dictionary() {
//        this.wordArr = new ArrayList<Word>();
//    }

//    public ArrayList<Word> getArr() {
//        return wordArr;
//    }
//
//    public void addWord(Word word) {
//        wordArr.add(word);
//    }
//
//    public void removeWord(Word word) {
//        wordArr.remove(word);
//    }
//    public void removeWord(int word) {
//        wordArr.remove(word);
//    }
//
//    public Word getWord(int i) {
//        return wordArr.get(i);
//    }
//    public int getSize() {
//        return wordArr.size();
//    }
}



