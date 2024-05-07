package com.example.demo.Game;

// import static com.example.eng_proj.Main.scanner;

public class FillTheGap extends Question {
    public FillTheGap(String q, String a) {
        super(q, a);
    }

    public String toString() {
//        System.out.println("Fill in the gap:");
        String re = "Fill in the gap:\n";
        return re + this.getQuestion();
    }

    public int handle(int allowRedo) {
        while (true) {
            System.out.print("Your answer: ");
            String bump = scanner.nextLine();
            if (bump.equals("0")) {
                scanner.nextLine();
                return USER_EXIT;
            } else if (bump.equals(answer)) {
                System.out.println(getReply(CORRECT));
                return USER_CORRECT;
            } else {
                System.out.println(getReply(INCORRECT));
                if (allowRedo == 0) {
                    return USER_INCORRECT;
                }

            }
        }

    }
}
