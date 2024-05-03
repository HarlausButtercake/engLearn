package com.example.eng_proj;

import static com.example.eng_proj.Main.scanner;

public class CmdLine {

    public CmdLine() {
        DictionaryCommandline dictionaryCommandline = new DictionaryCommandline();
        DictionaryManagement dictionaryManagement = new DictionaryManagement();

        int intput;
        out:
        while(true) {
            System.out.println(
                    "=============================================\r\n" + //
                            "Welcome to My Application!\r\n" + //
                            "[0] Exit\r\n" + //
                            "[1] Show all words\r\n" + //
                            "[2] Add words manually\r\n" + //
                            "[3] Remove\r\n" + //
                            "[4] Clean up duplicate words\r\n" + //
                            "[5] Flush dictionary\r\n" + //
                            "[6] Lookup\r\n" + //
                            "[7] Search\r\n" + //
                            "[8] Game\r\n" + //
                            "[9] Import from file\r\n" + //
                            "=============================================");

            while (!scanner.hasNextInt()) {
                System.out.println("Action not supported!");
                scanner.next();
            }
            intput = scanner.nextInt();
            scanner.nextLine();
            switch (intput) {
                case 0:
                    break out;
                case 1:
                    dictionaryCommandline.showAllWords();
                    break;
                case 2:
                    dictionaryManagement.insertFromCommandline();
                    break;
                case 4:
                    dictionaryManagement.removeDupeWords();
                    break;
                case 7:
                    dictionaryCommandline.dictionarySearcher();
                    break;
                case 8:
                    dictionaryCommandline.startGame();
                    break;
                case 9:
                    dictionaryManagement.insertWordFromFile();
                    break;
                default:
                    System.out.println("Malussy");
            }
        }
    }

}
