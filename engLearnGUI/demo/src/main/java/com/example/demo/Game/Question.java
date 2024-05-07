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

    protected final ArrayList<String> CORRECT = new ArrayList<>(Arrays.asList("That's right! ", "Well done!"
            , "That is correct!"));

    protected final ArrayList<String> INCORRECT = new ArrayList<>(Arrays.asList("Oof! ", "That doesn't seem right. "
            , "That is NOT correct!"));

    protected String getReply(ArrayList<String> arr) {
        Collections.shuffle(arr);
        return arr.get(0);
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

    // public abstract ArrayList<String> loadQuestion();

    public abstract int handle(int allowRedo, int i, ArrayList<String> selectionList);

    public boolean isCorrect(String submission) {
        return submission.equals(answer);
    }
}
