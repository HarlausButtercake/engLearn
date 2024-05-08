package com.example.demo.Game;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
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





    public void insertQuestionFromFile() {
        InputStream inputStream = getClass().getResourceAsStream("/com/example/demo/data/questionnaire.txt");
        if (inputStream != null) {
            try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream))) {
                String line;
                // int count = 0;
                while ((line = bufferedReader.readLine()) != null) {
                    String[] parts = line.split("\t");
                    if (parts.length > 2) {
                        ArrayList<String> wrong = new ArrayList<>();
                        for(int i = 2; i < parts.length; i++) {
                            wrong.add(parts[i].trim());
                        }
                        Questionnaire.get().add(new MultipleOptions(parts[0].trim(), parts[1].trim(), wrong));
                        // count++;
                    } else if (parts.length == 2) {
                        Questionnaire.get().add(new FillTheGap(parts[0].trim(), parts[1].trim()));
                        
                    }
                }
                // System.out.println("Inserted " + count + " questions from file successfully!");
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            System.err.println("Questionnaire file not found!");
        }
    }
}
