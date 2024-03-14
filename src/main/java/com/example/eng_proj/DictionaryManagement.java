package com.example.eng_proj;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.Scanner;

public class DictionaryManagement {

    public DictionaryManagement() {
        
    }

    public void insertFromCommandline(Dictionary dictionary) {
        Scanner scan = new Scanner(System.in);
        System.out.println("How many words do you want to add ? (Press 0 to return)");
        while (!scan.hasNextInt()) {
            System.out.println("Please enter a valid number!");
            scan.next();
        } 
        int count = scan.nextInt();
        scan.nextLine();
     
        for (int i = 0; i < count; i++) {        
            System.out.println("Enter your word:");
            String dumb = scan.nextLine();
            System.out.println("What is the word definition ?");
            String bump = scan.nextLine();
            dictionary.addWord(new Word(dumb, bump));
        }           
    }

    public void insertFromFile(Dictionary dictionary) {
        InputStream inputStream = getClass().getResourceAsStream("/dictionaries.txt");
        if (inputStream != null) {
            try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream))) {
                String line;
                int count = 0;
                while ((line = bufferedReader.readLine()) != null) {
                    String[] parts = line.split("\t");
                    if (parts.length >= 2) {
                        // System.out.println(parts[0] + " cunt " + parts[1]);
                        dictionary.addWord(new Word(parts[0].trim(), parts[1].trim()));
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
}

class WordComparator implements Comparator<Word> {
    @Override
    public int compare(Word word1, Word word2) {
        // Compare based on the target attribute
        return word1.getTarget().compareTo(word2.getTarget());
    }
}
