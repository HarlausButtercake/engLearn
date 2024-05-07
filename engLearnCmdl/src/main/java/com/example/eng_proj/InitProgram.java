package com.example.eng_proj;

import com.example.eng_proj.Game.BasicQuestionManagement;

public class InitProgram {
    public InitProgram() {
        BasicQuestionManagement.get().insertQuestionFromFile();
        DictionaryCommandline.get().insertWordFromFile(getClass().getResourceAsStream("/raw_word.txt"));
        DictionaryCommandline.get().sortAlpha();
    }
}
