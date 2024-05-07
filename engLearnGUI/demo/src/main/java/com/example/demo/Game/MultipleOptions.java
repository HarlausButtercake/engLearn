package com.example.eng_proj.Game;

import java.util.ArrayList;
import java.util.Collections;

import static com.example.eng_proj.Main.scanner;

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
        // Random random = new Random();
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
        // this.answerKey =
        this.setAnswerKey(randomElements.indexOf(this.getAnswer()));
        return randomElements;
    }

    public String toString() {
        ArrayList<String> select = this.shuffleSelection();
        String s = this.getQuestion() + "\n";
        s += "[1] " + select.get(0) + "\n";
        s += "[2] " + select.get(1) + "\n";
        if (select.size() >= 3) {
            s += "[3] " + select.get(2) + "\n";
            if (select.size() >= 4) {
                s += "[4] " + select.get(3) + "\n";
            }
        }
        return s;
    }

    @Override
    public int handle(int allowRedo) {
        int legit;
        int wrongSize = wrongAnswer.size();
        while (true) {
            System.out.print("Your answer: ");
            while (!scanner.hasNextInt()) {
                System.out.println("Action not supported!");
                scanner.next();
            }
            legit = scanner.nextInt();
            scanner.nextLine();
            if (legit == 0) {
                return USER_EXIT;
            } else if (legit >= 1 && legit <= ((wrongSize >= 3) ? 4 : (wrongSize + 1))) {
                if (legit == answerKey + 1) {
                    System.out.println(getReply(CORRECT));
                    return USER_CORRECT;
                } else {
                    System.out.println(getReply(INCORRECT));
                    if (allowRedo == 0) {
                        return USER_INCORRECT;
                    }
                }
            } else {
                System.out.print("Action not supported! ");
            }
        }
    }
}
