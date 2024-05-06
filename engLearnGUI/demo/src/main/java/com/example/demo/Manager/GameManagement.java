// package com.example.demo.Manager;

// import java.util.Collections;

// import static com.example.demo.Manager.Main.scanner;

// public class GameManagement {
//     // private GameManagement gameManagement;

//     public GameManagement() {
//         //        System.out.println("Choose difficulty from 1 to 3!");
// //        int difficulty = 0;
// //        while (true) {
// //            if (scanner.hasNextInt()) {
// //                int input = scanner.nextInt();
// //                if (input >= 1 && input <= 3) {
// //                    difficulty = input;
// //                    break;
// //                }
// //            }
// //            System.out.println("Please enter a valid number!");
// //            scanner.next(); // Consume invalid input
// //        }
// //
// //
// //        System.out.print("Starting the questionnaire with the difficulty of " + difficulty);
//         System.out.print("Starting the questionnaire! Enter 0 to exit.");
//         int difficulty = 3;
//         for (int i = 0; i <= 3; i++) {
//             System.out.print(".");
//             try {
//                 Thread.sleep(100);
//             } catch (InterruptedException e) {
//                 e.printStackTrace();
//             }
//         }
//         System.out.println("\n");

//         Collections.shuffle(Questionnaire.get());
//         for (int i = 0; i < Questionnaire.get().size(); i++) {
//             System.out.println("Question " + (i + 1) + ":");
//             System.out.println(Questionnaire.get().get(i).questionToString(difficulty + 1));

//             int legit;
//             int wrongSize = Questionnaire.get().get(i).getWrongAnswer().size();
//             while (true) {
//                 System.out.print("Your answer: ");
//                 while (!scanner.hasNextInt()) {
//                     System.out.println("Action not supported!");
//                     scanner.next();
//                 }
//                 legit = scanner.nextInt();
//                 if (legit == 0) {
//                     i = Questionnaire.get().size();
//                     break;
//                 } else if (legit >= 1 && legit <= ((wrongSize >= 3) ? 4 : (wrongSize + 1))) {
//                     if (legit == Questionnaire.get().get(i).getAnswerKey() + 1) {
//                         System.out.println(Randomized.getReply(Randomized.CORRECT));
//                         break;
//                     } else {
//                         System.out.print(Randomized.getReply(Randomized.INCORRECT));
//                     }
//                 } else {
//                     System.out.print("Action not supported! ");
//                 }

//             }



//         }
//     }

// }
