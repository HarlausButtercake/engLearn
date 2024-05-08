package com.example.demo.Game;

import java.util.ArrayList;
import java.util.Collections;

// import static com.example.eng_proj.Main.scanner;

public class MultipleOptions extends Question {
    private ArrayList<String> wrongAnswer;
    private int answerKey;

    public MultipleOptions(String ques, String ans, ArrayList<String> wro) {
        super(ques, ans);
        this.wrongAnswer = wro;
    }

    public void setAnswerKey(int answerKey) {
        this.answerKey = answerKey;
    }
    public int getAnswerKey() {
        return answerKey;
    }
    public ArrayList<String> getWrongAnswer() {
        return wrongAnswer;
    }
    public ArrayList<String> shuffleSelection() {
        ArrayList<String> randomElements = new ArrayList<>();
        Collections.shuffle(this.getWrongAnswer());
        for (int i = 0; i < 3; i++) {
            if (i >= this.getWrongAnswer().size()) {
                break;
            }
            randomElements.add(this.getWrongAnswer().get(i));
        }
        randomElements.add(this.getAnswer());
        Collections.shuffle(randomElements);
        this.setAnswerKey(randomElements.indexOf(this.getAnswer()));
        return randomElements;
    }

    @Override
    public ArrayList<String> toStringArr() {
        ArrayList<String> select = new ArrayList<>();
        select.add(question);
        select.addAll(this.shuffleSelection());
        return select;
    }
}
