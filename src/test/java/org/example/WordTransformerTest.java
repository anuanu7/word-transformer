package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import java.util.Arrays;
import java.util.List;

public class WordTransformerTest {

    @Test
    void testValidInputWithValidPath() {
        WordTransformer transformer = new WordTransformer();
        List<String> words = Arrays.asList("ant", "bat", "cat", "cot", "cut", "dog", "dot", "hen", "pig", "rat");
        List<String> path = transformer.findShortestPath(words, "cat", "dog");
        Assertions.assertNotNull(path);
        Assertions.assertEquals(4, path.size());
        Assertions.assertEquals("cat", path.get(0));
        Assertions.assertEquals("cot", path.get(1));
        Assertions.assertEquals("dot", path.get(2));
    }

    @Test
    void testValidInputWithNoValidPath() {
        WordTransformer transformer = new WordTransformer();
        List<String> words = Arrays.asList("ant", "bat", "cat", "cot", "cut", "dog", "dot", "hen", "pig", "rat");
        List<String> path = transformer.findShortestPath(words, "cat", "pig");
        Assertions.assertNull(path);
    }

    @Test
    void testStartWordNotInWordList() {
        WordTransformer transformer = new WordTransformer();
        List<String> words = Arrays.asList("ant", "bat", "cat", "cot", "cut", "dog", "dot", "hen", "pig", "rat");
        List<String> path = transformer.findShortestPath(words, "fox", "dog");
        Assertions.assertNull(path);
    }

    @Test
    void testEndWordNotInWordList() {
        WordTransformer transformer = new WordTransformer();
        List<String> words = Arrays.asList("ant", "bat", "cat", "cot", "cut", "dog", "dot", "hen", "pig", "rat");
        List<String> path = transformer.findShortestPath(words, "cat", "fox");
        Assertions.assertNull(path);
    }

    @Test
    void testStartAndEndWordsNotInWordList() {
        WordTransformer transformer = new WordTransformer();
        List<String> words = Arrays.asList("ant", "bat", "cat", "cot", "cut", "dog", "dot", "hen", "pig", "rat");
        List<String> path = transformer.findShortestPath(words, "fox", "wolf");
        Assertions.assertNull(path);
    }

    @Test
    void testEmptyWordList() {
        WordTransformer transformer = new WordTransformer();
        List<String> words = Arrays.asList();
        List<String> path = transformer.findShortestPath(words, "cat", "dog");
        Assertions.assertNull(path);
    }

    @Test
    void testOneWordInWordList() {
        WordTransformer transformer = new WordTransformer();
        List<String> words = Arrays.asList("cat");
        List<String> path = transformer.findShortestPath(words, "cat", "dog");
        Assertions.assertNull(path);
    }
}
