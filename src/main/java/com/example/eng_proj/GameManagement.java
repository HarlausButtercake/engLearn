package com.example.eng_proj;

import java.util.Collections;

public class GameManagement {
    private static GameManagement gameManagement;

    public GameManagement() {
        //        System.out.println("Choose difficulty from 1 to 3!");
//        int difficulty = 0;
//        while (true) {
//            if (scanner.hasNextInt()) {
//                int input = scanner.nextInt();
//                if (input >= 1 && input <= 3) {
//                    difficulty = input;
//                    break;
//                }
//            }
//            System.out.println("Please enter a valid number!");
//            scanner.next(); // Consume invalid input
//        }
//
//
//        System.out.print("Starting the questionnaire with the difficulty of " + difficulty);
        System.out.print("Starting the questionnaire!");
        int difficulty = 3;
//        for (int i = 0; i <= 5; i++) {
//            System.out.print(".");
//            try {
//                Thread.sleep(100);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//        }
//        System.out.println("\nLoading complete!");

        Collections.shuffle(BasicQuestionManagement.get());
        for (int i = 0; i < BasicQuestionManagement.get().size(); i++) {
            System.out.println("Question " + (i + 1) + ":");
            System.out.println(BasicQuestionManagement.get().get(i).questionToString(difficulty + 1));



        }
    }

}
