package com.example.eng_proj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

import static com.example.eng_proj.Main.dictionary;
import static com.example.eng_proj.Main.scanner;

public class DictionaryManagement {

    public DictionaryManagement() {
        
    }

    public void insertFromCommandline() {
        System.out.println("How many words do you want to add ? (Press 0 to return)");
        while (!scanner.hasNextInt()) {
            System.out.println("Please enter a valid number!");
            scanner.next();
        } 
        int count = scanner.nextInt();
        scanner.nextLine();
     
        for (int i = 0; i < count; i++) {        
            System.out.print("Enter your word: ");
            String dumb = scanner.nextLine();
            System.out.print("Enter the word's definition: ");
            String bump = scanner.nextLine();
            dictionary.add(new Word(dumb, bump));
        }           
    }

    public void insertWordFromFile() {
        InputStream inputStream = getClass().getResourceAsStream("/dictionaries.txt");
        if (inputStream != null) {
            try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream))) {
                String line;
                int count = 0;
                while ((line = bufferedReader.readLine()) != null) {
                    String[] parts = line.split("\t");
                    if (parts.length >= 2) {
                        // System.out.println(parts[0] + " coont " + parts[1]);
                        dictionary.add(new Word(parts[0].trim(), parts[1].trim()));
                        count++;
                    }                
                }
                System.out.println("Inserted " + count + " words from file successfully!");
            } catch (IOException e) {
                e.printStackTrace();
                System.out.println("Reading from file failed to succeed :3");
            }
        } else {
            System.out.println("File not found!");
        }
    }

    public void removeDupeWords() {
        Set<String> uniqueFields = new HashSet<>();
        int i = 0;

        while (i < dictionary.size()) {
            Word obj = dictionary.get(i);
            if (uniqueFields.contains(obj.getTarget())) {
                dictionary.remove(i);
            } else {
                uniqueFields.add(obj.getTarget());
                i++;
            }
        }

    }
}

