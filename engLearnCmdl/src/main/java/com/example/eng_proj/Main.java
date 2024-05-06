package com.example.eng_proj;

import com.example.eng_proj.gui.MainMenu;

import java.util.Scanner;
// import javax.swing.*;

public class Main {
    public static Scanner scanner = new Scanner(System.in);
//    public static Dictionary dictionary = new Dictionary();


    public static void main(String[] args) {

//        try {
//            // Specify the path to your file
//            String filePath = "src/main/resources/raw_word.txt";
//
//            // Read the content of the file
//            BufferedReader reader = new BufferedReader(new FileReader(filePath));
//            StringBuilder stringBuilder = new StringBuilder();
//            String line;
//            int i = 1;
//            while ((line = reader.readLine()) != null) {
//
//                if (i != 5) {
//                    if (line.equals("")) {
//                        continue;
//                    } else {
//                        stringBuilder.append(line.trim()).append("\t");
//                        i++;
//                    }
//                } else {
//                    i = 1;
//                    stringBuilder.append(line.trim()).append("\n");
//                }
//
//                // Append the modified line to the StringBuilder
//
//
//
//            }
//            reader.close();
//
//            // Write the modified content back to the file
//            BufferedWriter writer = new BufferedWriter(new FileWriter(filePath));
//            writer.write(stringBuilder.toString());
//            writer.close();
//
//            System.out.println("Replacement completed successfully.");
//        } catch (IOException e) {
//            System.out.println("An error occurred: " + e.getMessage());
//        }

        new InitProgram();
//
//        new CmdLine();
        new MainMenu();


        scanner.close();
    }
}