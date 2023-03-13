package org.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;


public class WordTransformerFileReader {
    public Transform readFromFile(String fileName) {

        try (BufferedReader br = new BufferedReader(new java.io.FileReader(fileName))) {
            String line = br.readLine();
            if (line == null) {
                System.out.println("ERROR: File is empty.");
                return null;
            }

            String[] words = line.split(",");
            if (words.length != 2) {
                System.out.println("ERROR:Line 1 should contain exactly two words separated by comma.");
                return null;
            }

            String firstWord = words[0].trim();
            String secondWord = words[1].trim();

            if (firstWord.length() != secondWord.length()) {
                System.out.println("ERROR: The length of the words in the first line should match in the file to transform.");
                return null;
            }

            line = br.readLine();
            if (line == null) {
                System.out.println("ERROR: File contains only one line.");
                return null;
            }

            String[] wordsList = line.split(",");
            ArrayList<String> list = new ArrayList<>();
            for (String word : wordsList) {
                list.add(word.trim());
            }
            Transform transform = new Transform(firstWord, secondWord, list);
            return transform;
        } catch (IOException e) {
            System.out.println("ERROR: File not found, please check if the file exist");
            return null;
        }

    }
}
