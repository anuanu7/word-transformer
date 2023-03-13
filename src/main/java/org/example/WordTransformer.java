package org.example;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public class WordTransformer {

    public List<String> findShortestPath(List<String> words, String start, String end) {
        if (!words.contains(start) || !words.contains(end)) {
            return null;
        }
        Set<String> visited = new HashSet<>();
        Queue<List<String>> queue = new LinkedList<>();
        queue.add(Arrays.asList(start));
        while (!queue.isEmpty()) {
            List<String> path = queue.remove();
            String lastWord = path.get(path.size() - 1);
            if (lastWord.equals(end)) {
                return path;
            }
            for (String word : words) {
                if (!visited.contains(word) && canTransform(lastWord, word)) {
                    List<String> newPath = new ArrayList<>(path);
                    newPath.add(word);
                    if (word.equals(end)) {
                        return newPath;
                    }
                    queue.add(newPath);
                    visited.add(word);
                }
            }
        }
        return null;
    }

    private boolean canTransform(String word1, String word2) {
        if (word1.length() != word2.length()) {
            return false;
        }
        int diffCount = 0;
        for (int i = 0; i < word1.length(); i++) {
            if (word1.charAt(i) != word2.charAt(i)) {
                diffCount++;
            }
        }
        return diffCount == 1;
    }
}

