package com.example.demo.Manager;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

// import static com.example.demo.Main.dictionary;
// import static com.example.eng_proj.Main.scanner;

public class DictionaryCommandline extends DictionaryManagement {

    private static DictionaryCommandline instance;
    public static DictionaryCommandline get() {
        if (instance == null) {
            instance = new DictionaryCommandline();
        }
        return instance;
    }

    public Word removeFromGui(String rem) {
        // System.out.print("Enter word that needs removing: ");
        //  = scanner.nextLine();
        for (Word word: DictionaryCommandline.get().searchKeyword(rem)) {
            if (word.getTarget().equals(rem)) {
                Dictionary.get().remove(new Word(word));
                // System.out.println("Word called \"" + rem + "\" has been removed!");
                // System.out.println("Press Enter to continue...");
                // scanner.nextLine();
                return word;
            }
        }
        // System.out.println("There is no such word called \"" + rem + "\"");
        // System.out.println("Press Enter to continue...");
        // scanner.nextLine();
        return new Word(null);

    }

    public void insertFromCommandline(String dumb, String bump) {
            Dictionary.get().add(new Word(dumb, bump));
    }

    public void insertWordFromFile(InputStream inputStream) {
//        InputStream inputStream = getClass().getResourceAsStream("/dictionaries.txt");
        if (inputStream != null) {
            try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream))) {
                String line;
                // int count = 0;
                while ((line = bufferedReader.readLine()) != null) {
                    String[] parts = line.split("\t");
                    if (parts.length >= 4) {
                        // System.out.println(parts[0] + " coont " + parts[1]);
                        Dictionary.get().add(new Word(parts[0].trim().toLowerCase(), parts[1].trim(), parts[2].trim().toLowerCase(), parts[3].trim()));
                        // count++;
                    } else {
//                        System.out.println(line);
                    }
                }
                // System.out.println("Inserted " + count + " words from file successfully!");
                // System.out.println("Press Enter to continue...");
                // scanner.nextLine();
            } catch (IOException e) {
                e.printStackTrace();
                // System.out.println("Reading from file failed to succeed :3");
                // System.out.println("Press Enter to continue...");
                // scanner.nextLine();
            }
        } else {
            // System.out.println("File not found!");
            // System.out.println("Press Enter to continue...");
            // scanner.nextLine();
        }
    }

//     public void showAllWords() {
// //        DictionaryManagement.get().sortAlpha();
//         DictionaryManagement.get().showAllWordsSequence();
//         System.out.print("Press Enter to continue...");
//         // scanner.nextLine();
//     }



    // public void dictionaryCmdlSearcher() {
    //     System.out.print("Type in your keyword:");
    //     String key = scanner.nextLine();
    //     DictionaryManagement.get().showWordArray(DictionaryManagement.get().searchKeyword(key));
    //     System.out.print("Press Enter to continue...");
    //     scanner.nextLine();
    // }

    public void removeDupeWords() {
        Set<String> uniqueFields = new HashSet<>();
        int i = 0;
        // int count = 0;
        while (i < Dictionary.get().size()) {
            Word obj = Dictionary.get().get(i);
            if (uniqueFields.contains(obj.getTarget())) {
                Dictionary.get().remove(i);
                
            } else {
                uniqueFields.add(obj.getTarget());
                i++;
            }
        }
        // System.out.println("Found and removed " + count + " words!");
        // System.out.println("Press Enter to continue...");
        // scanner.nextLine();
    }
}
