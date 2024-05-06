package com.example.eng_proj;

public class Word {


    private String word_target;
    private String word_explain;
    private String word_pronounce;
    private String word_type;

//    public Word() {
//        this.word_target = null;
//        this.word_explain = null;
//    }

    public Word(String word_target, String word_pronounce, String word_type, String word_explain) {
        this.word_target = word_target;
        this.word_explain = word_explain;
        this.word_pronounce = word_pronounce;
        this.word_type = word_type;
    }
    public Word(String tar, String exp) {
        this.word_target = tar;
        this.word_explain = exp;
    }
    public void setTarget(String s) {
        this.word_target = s;
    }
    public void setExplain(String s) {
        this.word_explain = s;
    }
    public String getTarget() {
        return word_target;
    }
    public String getExplain() {
        return word_explain;
    }
    public void simplePrintWord() {
        System.out.println(word_target + ": " + word_explain);
    }
    public void fullPrintWord() {
        System.out.println(word_target + " " + word_pronounce + " (" + word_type + "): " + word_explain);
    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Word word = (Word) obj;
        return word_target.equals(word.word_target);
    }



    @Override
    public int hashCode() {
        return word_target.hashCode();
    }
}
