package com.example.englearngui;

public class Word {
    private String word_target;
    private String word_explain;

    public Word() {
        this.word_target = null;
        this.word_explain = null;
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
    public void rawPrintWord() {
        System.out.println(word_target + ": " + word_explain);
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
