package com.example.eng_proj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
// import java.util.Random;

public class BasicQuestionManagement extends ArrayList<BasicQuestion> {
//    public ArrayList<BasicQuestion> questArr;

    private static BasicQuestionManagement basicQuestionManagement;

//    public BasicQuestionManagement() {
//        questArr = new ArrayList<>();
//    }

    public static BasicQuestionManagement get() {
        if (basicQuestionManagement == null) {
            basicQuestionManagement = new BasicQuestionManagement();
        }
        return basicQuestionManagement;
    }

    public ArrayList<String> makeSelection(BasicQuestion ques, int diffi) {
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
                    if (parts.length >= 3) {
                        ArrayList<String> wrong = new ArrayList<>();
                        for(int i = 2; i < parts.length; i++) {
                            wrong.add(parts[i].trim());
                        }
                        this.add(new BasicQuestion(parts[0].trim(), parts[1].trim(), wrong));
                        count++;
                    }                
                }
                System.out.println("Inserted " + count + " questions from file successfully!");
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            System.err.println("File not found!");
        }
    }
}
