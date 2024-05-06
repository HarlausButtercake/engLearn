package com.example.demo.Manager;

public class InitProgram {
    public InitProgram() {
//        DictionaryCommandline dictionaryCommandline = new DictionaryCommandline();
        BasicQuestionManagement.get().insertQuestionFromFile();
        DictionaryCommandline.get().insertWordFromFile(getClass().getResourceAsStream("/com/example/demo/data/raw_word.txt"));
        DictionaryManagement.get().sortAlpha();
    }
}
