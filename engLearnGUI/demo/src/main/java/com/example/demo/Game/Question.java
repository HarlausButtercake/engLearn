package com.example.demo.Game;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public abstract class Question {
    protected String question;
    protected String answer;
//    private ArrayList<String> wrongAnswer;
//    private int answerKey;
//    BasicQuestionManagement manage = new BasicQuestionManagement();
    protected final int USER_EXIT = 2;
    protected final int USER_CORRECT = 1;
    protected final int USER_INCORRECT = 0;

    public final ArrayList<String> CORRECT = new ArrayList<>(Arrays.asList("That's right! ", "Well done!"
            , "That is correct!"));

    public final ArrayList<String> INCORRECT = new ArrayList<>(Arrays.asList("Oof! ", "That doesn't seem right. "
            , "That is NOT correct!"));

    public String getReply(String str) {
        String s = "";
        if (str.equals("CORRECT")) {
            Collections.shuffle(CORRECT);
            s += CORRECT.get(0);
        } else if (str.equals("INCORRECT")) {
            Collections.shuffle(INCORRECT);
            s += INCORRECT.get(0);
        }
        
        return s;
    }

    public Question() {

    }
    public Question(String ques, String ans) {
        this.question = ques;
        this.answer = ans;
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

    public ArrayList<String> toStringArr() {
        ArrayList<String> rere = new ArrayList<>();
        rere.add(question);
        rere.add(answer);
        return rere;
    }

    // public abstract int handle(int allowRedo, int i, ArrayList<String> selectionList);

    public boolean isCorrect(String submission) {
        return submission.equals(answer);
    }
}
