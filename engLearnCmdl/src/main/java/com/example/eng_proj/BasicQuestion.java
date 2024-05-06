package com.example.eng_proj;

import java.util.ArrayList;


public class BasicQuestion {
    private String question;
    private String answer;
    private ArrayList<String> wrongAnswer;
    private int answerKey;
    BasicQuestionManagement manage = new BasicQuestionManagement();

    public BasicQuestion(String ques, String ans, ArrayList<String> wro) {
        this.question = ques;
        this.answer = ans;
        this.wrongAnswer = wro;
    }

    public int getAnswerKey() {
        return answerKey;
    }

     public void setAnswerKey(int answerKey) {
         this.answerKey = answerKey;
     }

//    public void addWrongAnswer(String s1) {
//        if (!s1.equals(answer)) {
//            this.wrongAnswer.add(s1);
//        }
//    }

    public ArrayList<String> getWrongAnswer() {
        return wrongAnswer;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }


    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }


    public boolean isCorrect(String submission) {
        return submission.equals(answer);
    }

    public String questionToString(int diff) {
        ArrayList<String> select = BasicQuestionManagement.get().shuffleSelection(this, diff);
        String s = this.getQuestion() + "\n";
        s += "[1] " + select.get(0) + "\n";
        s += "[2] " + select.get(1) + "\n";
        if (diff >= 3 && select.size() >= 3) {
            s += "[3] " + select.get(2) + "\n";
            if (diff == 4 && select.size() >= 4) {
                s += "[4] " + select.get(3) + "\n";
            }
        }
        return s;
    }

}