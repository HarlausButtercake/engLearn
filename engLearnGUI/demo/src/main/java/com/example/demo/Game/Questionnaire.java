package com.example.demo.Game;

import java.util.ArrayList;

public class Questionnaire extends ArrayList<Question> {
    private static Questionnaire basicQuestionManagement;
    private int allowRedo;
    private int score;

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public int getAllowRedo() {
        return allowRedo;
    }

    public void setAllowRedo(int allowRedo) {
        this.allowRedo = allowRedo;
    }

    public static Questionnaire get() {
        if (basicQuestionManagement == null) {
            basicQuestionManagement = new Questionnaire();
        }
        return basicQuestionManagement;
    }
}
