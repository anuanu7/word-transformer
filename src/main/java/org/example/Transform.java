package org.example;

import java.util.ArrayList;

public class Transform {

    String startWord;
    String endWord;
    ArrayList<String> wordsList;

    public Transform(String startWord, String endWord, ArrayList<String> wordsList) {
        this.startWord = startWord;
        this.endWord = endWord;
        this.wordsList = wordsList;
    }

    public String getStartWord() {
        return startWord;
    }

    public void setStartWord(String startWord) {
        this.startWord = startWord;
    }

    public String getEndWord() {
        return endWord;
    }

    public void setEndWord(String endWord) {
        this.endWord = endWord;
    }

    public ArrayList<String> getWordsList() {
        return wordsList;
    }

    public void setWordsList(ArrayList<String> wordsList) {
        this.wordsList = wordsList;
    }
}
