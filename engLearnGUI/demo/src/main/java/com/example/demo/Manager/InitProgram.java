package com.example.demo.Manager;

import com.example.demo.Game.BasicQuestionManagement;

public class InitProgram {
    public InitProgram() {
//        DictionaryCommandline dictionaryCommandline = new DictionaryCommandline();
        BasicQuestionManagement.get().insertQuestionFromFile();
        DictionaryCommandline.get().insertWordFromFile(getClass().getResourceAsStream("/com/example/demo/data/raw_word.txt"));
        DictionaryManagement.get().sortAlpha();
    }
}
