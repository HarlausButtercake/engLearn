package com.example.eng_proj;

import java.util.Scanner;
// import javax.swing.*;

public class Main {
    public static Scanner scanner = new Scanner(System.in);
//    public static Dictionary dictionary = new Dictionary();


    public static void main(String[] args) {
        new InitProgram();
        new CmdLine();
        scanner.close();
    }
}