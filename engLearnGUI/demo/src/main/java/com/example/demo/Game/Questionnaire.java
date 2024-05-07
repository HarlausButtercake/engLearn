package com.example.eng_proj.Game;

import java.util.ArrayList;

public class Questionnaire extends ArrayList<Question> {
    private static Questionnaire basicQuestionManagement;


    public static Questionnaire get() {
        if (basicQuestionManagement == null) {
            basicQuestionManagement = new Questionnaire();
        }
        return basicQuestionManagement;
    }
}
