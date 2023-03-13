package org.example;


import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;


import static org.junit.jupiter.api.Assertions.*;

public class WordTransformerApplicationTest {

    @Test
    public void testFindShortestPathWithValidFile() {
        String[] args = {"valid_words.txt"};
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));
        WordTransformerApplication.main(args);
        assertEquals("Shortest path: cat, cot, dot, dog\n", outputStream.toString());
        System.setOut(System.out);
    }

    @Test
    public void testFindShortestPathWithInvalidFile() {
        String[] args = {"invalid_words.txt"};
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));
        WordTransformerApplication.main(args);
        assertEquals("Cannot transform cat to pig\n", outputStream.toString());
        System.setOut(System.out);
    }

    @Test
    public void testFindShortestPathWithNoArgs() {
        String[] args = {};
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));
        WordTransformerApplication.main(args);
        assertEquals("ERROR: Please provide filename as command line argument.\n", outputStream.toString());
        System.setOut(System.out);
    }

}
