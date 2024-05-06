package com.example.eng_proj;

import java.util.ArrayList;

public class Questionnaire extends ArrayList<BasicQuestion> {
    private static Questionnaire basicQuestionManagement;


    public static Questionnaire get() {
        if (basicQuestionManagement == null) {
            basicQuestionManagement = new Questionnaire();
        }
        return basicQuestionManagement;
    }
}
