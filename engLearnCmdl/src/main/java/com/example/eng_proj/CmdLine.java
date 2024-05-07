package com.example.eng_proj;

import com.example.eng_proj.Game.GameManagement;

import static com.example.eng_proj.Main.scanner;

public class CmdLine {

    public CmdLine() {
        DictionaryCommandline dictionaryCommandline = new DictionaryCommandline();

        out:
        while(true) {
            System.out.println(
                            "=============================================\r\n" + //
                            "Welcome to EngLearn: Commandline Edition!\r\n" + //
                            "[0] Exit\r\n" + //
                            "[1] Show all words\r\n" + //
                            "[2] Add words manually\r\n" + //
                            "[3] Remove a word\r\n" + //
                            "[4] Remove duplicate words\r\n" + //
                            "[5] Flush dictionary\r\n" + //
                            "[6] Lookup\r\n" + //
                            "[7] Search\r\n" + //
                            "[8] Game\r\n" + //
                            "[9] Import from file\r\n" + //
                            "=============================================");
            System.out.print("Your next action: ");
            while (!scanner.hasNextInt()) {
                System.out.println("Action not supported!");
                scanner.next();
            }
            int legit = scanner.nextInt();
            scanner.nextLine();
            switch (legit) {
                case 0:
                    break out;
                case 1:
                    dictionaryCommandline.showAllWords();
                    break;
                case 2:
                    dictionaryCommandline.insertFromCommandline();
                    break;
                case 3:
                    dictionaryCommandline.removeFromCommandline();
                    break;
                case 4:
                    dictionaryCommandline.removeDupeWords();
                    break;
                case 7:
                    dictionaryCommandline.dictionaryCmdlSearcher();
                    break;
                case 8:
                    new GameManagement();
                    break;
                case 9:
                    dictionaryCommandline.insertWordFromFile(getClass().getResourceAsStream("/dictionaries.txt"));
                    break;
                default:
                    System.out.println("You're not supposed to do that!");
            }
        }
    }

}
