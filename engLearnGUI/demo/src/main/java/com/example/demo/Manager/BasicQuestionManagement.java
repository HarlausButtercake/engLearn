package com.example.demo.Manager;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
// import java.util.Random;

public class BasicQuestionManagement {
//    public ArrayList<BasicQuestion> questArr;

//    private static BasicQuestionManagement basicQuestionManagement;

//    public BasicQuestionManagement() {
//        questArr = new ArrayList<>();
//    }

    private static BasicQuestionManagement instance;
    public static BasicQuestionManagement get() {
        if (instance == null) {
            instance = new BasicQuestionManagement();
        }
        return instance;
    }

    public ArrayList<String> shuffleSelection(BasicQuestion ques, int diffi) {
        // Random random = new Random();
        ArrayList<String> randomElements = new ArrayList<>();
        Collections.shuffle(ques.getWrongAnswer());
        for (int i = 0; i < diffi; i++) {
            if (i >= ques.getWrongAnswer().size()) {
                break;
            }
            // int randomIndex = random.nextInt(ques.getWrongAnswer().size());
            randomElements.add(ques.getWrongAnswer().get(i));
        }
        randomElements.add(ques.getAnswer());
        Collections.shuffle(randomElements);
        // this.answerKey = 
        ques.setAnswerKey(randomElements.indexOf(ques.getAnswer()));
        return randomElements;
    }



    public void insertQuestionFromFile() {
        InputStream inputStream = getClass().getResourceAsStream("/questionnaire.txt");
        if (inputStream != null) {
            try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream))) {
                String line;
                int count = 0;
                while ((line = bufferedReader.readLine()) != null) {
                    String[] parts = line.split("\t");
                    if (parts.length >= 2) {
                        ArrayList<String> wrong = new ArrayList<>();
                        for(int i = 2; i < parts.length; i++) {
                            wrong.add(parts[i].trim());
                        }
                        Questionnaire.get().add(new BasicQuestion(parts[0].trim(), parts[1].trim(), wrong));
                        count++;
                    }                
                }
                System.out.println("Inserted " + count + " questions from file successfully!");
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            System.err.println("Questionnaire file not found!");
        }
    }
}
