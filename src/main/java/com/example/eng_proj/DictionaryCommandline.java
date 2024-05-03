package com.example.eng_proj;

import java.util.Collections;

import static com.example.eng_proj.Main.dictionary;
import static com.example.eng_proj.Main.scanner;

public class DictionaryCommandline extends Dictionary {

    public void showAllWordsSequence() {
        for (int i = 0; i < dictionary.size(); i++) {
            dictionary.get(i).rawPrintWord();
        }
    }

    public void sortAlpha() {
        dictionary.sort((o1, o2)
                  -> o1.getTarget().compareTo(
                      o2.getTarget()));
    }

    public void showAllWords() {
        sortAlpha();
        showAllWordsSequence();
    }

    public void dictionarySearcher() {
        System.out.println("Type in your keyword:");
        String key = scanner.nextLine();
        for (Word word : dictionary) {
            if (word.getTarget().toLowerCase().startsWith(key.toLowerCase())) {
                word.rawPrintWord();
            }
        }
    }

    public void startGame() {
        System.out.println("Choose difficulty from 1 to 3!");     
        int difficulty = 0;
        while (true) {
            if (scanner.hasNextInt()) {
                int input = scanner.nextInt();
                if (input >= 1 && input <= 3) {
                    difficulty = input;
                    break;
                }
            }
            System.out.println("Please enter a valid number!");
            scanner.next(); // Consume invalid input
        }
    

        System.out.print("Starting the questionnaire with the difficulty of " + difficulty);
        for (int i = 0; i <= 5; i++) {
            System.out.print(".");
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("\nLoading complete!");
     
        Collections.shuffle(Main.basicQuestionManagement.questArr);
        for (int i = 0; i < Main.basicQuestionManagement.questArr.size(); i++) {   
            System.out.println("Question " + (i + 1) + ":");
            System.out.println(Main.basicQuestionManagement.questArr.get(i).questionToString(difficulty + 1));
        }       
    }
}
