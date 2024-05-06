package com.example.eng_proj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

//import static com.example.eng_proj.Main.dictionary;
import static com.example.eng_proj.Main.scanner;

public class DictionaryCommandline {

    private static DictionaryCommandline instance;
    public static DictionaryCommandline get() {
        if (instance == null) {
            instance = new DictionaryCommandline();
        }
        return instance;
    }

    public void removeFromCommandline

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
            Dictionary.get().add(new Word(dumb, bump));
        }
    }

    public void insertWordFromFile(InputStream inputStream) {
//        InputStream inputStream = getClass().getResourceAsStream("/dictionaries.txt");
        if (inputStream != null) {
            try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream))) {
                String line;
                int count = 0;
                while ((line = bufferedReader.readLine()) != null) {
                    String[] parts = line.split("\t");
                    if (parts.length >= 4) {
                        // System.out.println(parts[0] + " coont " + parts[1]);
                        Dictionary.get().add(new Word(parts[0].trim().toLowerCase(), parts[1].trim(), parts[2].trim().toLowerCase(), parts[3].trim()));
                        count++;
                    } else {
//                        System.out.println(line);
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

    public void showAllWords() {
//        DictionaryManagement.get().sortAlpha();
        DictionaryManagement.get().showAllWordsSequence();
    }



    public void dictionaryCmdlSearcher() {
        System.out.print("Type in your keyword:");
        String key = scanner.nextLine();
        DictionaryManagement.get().showWordArray(DictionaryManagement.get().searchKeyword(key));
    }

    public void removeDupeWords() {
        Set<String> uniqueFields = new HashSet<>();
        int i = 0;
        int count = 0;
        while (i < Dictionary.get().size()) {
            Word obj = Dictionary.get().get(i);
            if (uniqueFields.contains(obj.getTarget())) {
                Dictionary.get().remove(i);
                count++;
            } else {
                uniqueFields.add(obj.getTarget());
                i++;
            }
        }
        System.out.println("Found and removed " + count + " words!");
    }
}
