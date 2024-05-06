package com.example.eng_proj;

public class InitProgram {
    public InitProgram() {
//        DictionaryCommandline dictionaryCommandline = new DictionaryCommandline();
        BasicQuestionManagement.get().insertQuestionFromFile();
        DictionaryCommandline.get().insertWordFromFile(getClass().getResourceAsStream("/raw_word.txt"));
        DictionaryManagement.get().sortAlpha();
    }
}