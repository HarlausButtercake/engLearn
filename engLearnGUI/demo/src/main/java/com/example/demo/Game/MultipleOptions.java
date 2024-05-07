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

    public ArrayList<String> getSelection() {
        ArrayList<String> select = this.shuffleSelection();
        // String s = this.getQuestion() + "\n";
        // s += "[1] " + select.get(0) + "\n";
        // s += "[2] " + select.get(1) + "\n";
        // if (select.size() >= 3) {
        //     s += "[3] " + select.get(2) + "\n";
        //     if (select.size() >= 4) {
        //         s += "[4] " + select.get(3) + "\n";
        //     }
        // }
        return select;
    }

    @Override
    public int handle(int allowRedo, int i, ArrayList<String> selectionList) {
        selectionList.clear();
        selectionList = new ArrayList<>(shuffleSelection());
        
        return 69;
        // int legit;
        // int wrongSize = wrongAnswer.size();
        // while (true) {
        //     if (legit == answerKey + 1) {
        //         System.out.println(getReply(CORRECT));
        //         return USER_CORRECT;
        //     } else {
        //         System.out.println(getReply(INCORRECT));
        //         if (allowRedo == 0) {
        //             return USER_INCORRECT;
        //         }
        //     }
        // }
    }
}
