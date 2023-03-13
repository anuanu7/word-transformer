package org.example;


import java.util.List;

public class WordTransformerApplication {

    public static void main(String[] args) {

        if (args.length < 1) {
            System.out.println("ERROR: Please provide filename as command line argument.");
            return;
        }
        new WordTransformerApplication().findShortestPath(args[0]);

    }

    public void findShortestPath(String fileName) {
        WordTransformerFileReader fileReader = new WordTransformerFileReader();
        Transform transform = fileReader.readFromFile(fileName);
        if (transform != null) {
            WordTransformer wordTransformer = new WordTransformer();
            List<String> path = wordTransformer.findShortestPath(transform.getWordsList(), transform.startWord, transform.endWord);
            if (path != null) {
                System.out.println("Shortest path: " + String.join(", ", path));
            } else {
                System.out.println("Cannot transform " + transform.startWord + " to " + transform.endWord);
            }
        }
    }

}