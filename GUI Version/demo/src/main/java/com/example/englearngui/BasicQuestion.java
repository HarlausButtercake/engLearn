package com.example.englearngui;

import java.util.ArrayList;


public class BasicQuestion {
    protected String question;
    protected String answer;
    protected ArrayList<String> wrongAnswer;
    protected int answerKey = -1;
    BasicQuestionManagement manage = new BasicQuestionManagement();

    public BasicQuestion(String ques, String ans, ArrayList<String> wro) {
        this.question = ques;
        this.answer = ans;
        this.wrongAnswer = wro;
    }

    public void setAnswerKey(int answerKey) {
        this.answerKey = answerKey;
    }

    public int getAnswerKey() {
        return answerKey;
    }

    // public void setAnswerKey(int answerKey) {
    //     this.answerKey = answerKey;
    // }

    public void addWrongAnswer(String s1) {
        if (!s1.equals(answer)) {
            this.wrongAnswer.add(s1);
        }
    }

    public ArrayList<String> getWrongAnswer() {
        return wrongAnswer;
    }

    public String getQuestion() {
        return question;
    }


    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }


    public boolean isCorrect(int submission) {
        return submission == answerKey;
    }

    public String questionToString(int diff) {
        ArrayList<String> select = manage.makeSelection(this, diff);
        String s = this.getQuestion() + "\n";
        s += "[A] " + select.get(0) + "\n";
        s += "[B] " + select.get(1) + "\n";
        if (diff >= 3 && select.size() >= 3) {
            s += "[C] " + select.get(2) + "\n";
            if (diff == 4 && select.size() >= 4) {
                s += "[D] " + select.get(3) + "\n";
            }
        } 
        return s;
    }

}
