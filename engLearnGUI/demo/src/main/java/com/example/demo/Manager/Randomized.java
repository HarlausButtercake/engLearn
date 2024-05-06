package com.example.demo.Manager;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Randomized {
    public static final ArrayList<String> CORRECT = new ArrayList<>(Arrays.asList("That's right! ", "Well done!"
            , "That is correct!"));

    public static final ArrayList<String> INCORRECT = new ArrayList<>(Arrays.asList("Try again. ", "That doesn't seem right. "
            , "That is correct!"));

    public static String getReply(ArrayList<String> arr) {
        Collections.shuffle(arr);
        return arr.get(0);
    }

//    public static String getCorrectReply() {
//        return getReply(correct);
//    }
}
