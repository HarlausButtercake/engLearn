package com.example.eng_proj;

import com.example.eng_proj.game.BasicQuestionManagement;

import static com.example.eng_proj.Main.scanner;

public class InitProgram {
    public InitProgram() {
        BasicQuestionManagement.get().insertQuestionFromFile();
        DictionaryCommandline.get().insertWordFromFile(getClass().getResourceAsStream("/raw_word.txt"));
        DictionaryManagement.get().sortAlpha();
    }
}
