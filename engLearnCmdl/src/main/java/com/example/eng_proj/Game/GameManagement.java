package com.example.eng_proj.Game;

import java.util.Collections;

import static com.example.eng_proj.Main.scanner;

public class GameManagement {
//    private GameManagement gameManagement;

    public GameManagement() {
        //
//        int difficulty = 0;
//        while (true) {
        System.out.print("Type 1 to allow retrying: ");
        while (!scanner.hasNextInt()) {
            System.out.println("Action not supported!");
            scanner.next();
        }
        int allowRedo = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Starting the questionnaire. Type 0 at anytime to exit!");
        for (int i = 0; i <= 3; i++) {
            System.out.print(".");
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("\n");
        if (allowRedo == 1) {
            System.out.println("Retrying is possible!");
        } else {
            System.out.println("Retrying is not possible!");
        }
        Collections.shuffle(Questionnaire.get());
        int i = 1;
        for (Question question: Questionnaire.get()) {

            System.out.print("Question " + i + ": ");
//            System.out.println(Questionnaire.get().get(i).questionToString(difficulty + 1));
            ;
            System.out.println(question.toString());
            question.handle(allowRedo);
            i++;


            }



        }

}
