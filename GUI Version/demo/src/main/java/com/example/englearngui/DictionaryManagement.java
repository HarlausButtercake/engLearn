package com.example.englearngui;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class DictionaryManagement {

    public DictionaryManagement() {
        
    }

    // public void insertFromCommandline() {
    //     System.out.println("How many words do you want to add ? (Press 0 to return)");
    //     while (!Main.scanner.hasNextInt()) {
    //         System.out.println("Please enter a valid number!");
    //         Main.scanner.next();
    //     } 
    //     int count = Main.scanner.nextInt();
    //     Main.scanner.nextLine();
     
    //     for (int i = 0; i < count; i++) {        
    //         System.out.println("Enter your word:");
    //         String dumb = Main.scanner.nextLine();
    //         System.out.println("What is the word definition ?");
    //         String bump = Main.scanner.nextLine();
    //         Main.dictionary.addWord(new Word(dumb, bump));
    //     }           
    // }

    public void insertWordFromFile() {
        InputStream inputStream = getClass().getResourceAsStream("/com/example/englearngui/dictionaries.txt");
        if (inputStream != null) {
            try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream))) {
                String line;
                int count = 0;
                while ((line = bufferedReader.readLine()) != null) {
                    String[] parts = line.split("\t");
                    if (parts.length >= 2) {
                        // System.out.println(parts[0] + " coont " + parts[1]);
                        App.dictionary.addWord(new Word(parts[0].trim(), parts[1].trim()));
                        count++;
                    }                
                }
                System.out.println("Inserted " + count + " words from file successfully!");
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            System.err.println("File not found!");
        }
    }

    

    public void removeDupeWords() {
        Set<String> uniqueFields = new HashSet<>();
        int i = 0;

        while (i < App.dictionary.getSize()) {
            Word obj = App.dictionary.getWord(i);
            if (uniqueFields.contains(obj.getTarget())) {
                App.dictionary.removeWord(i);
            } else {
                uniqueFields.add(obj.getTarget());
                i++;
            }
        }

    }
}
