package org.example;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import org.junit.jupiter.api.Test;

public class WordTransformerFileReaderTest {

    private static final String VALID_FILE_NAME = "test.txt";
    private static final String EMPTY_FILE_NAME = "empty.txt";
    private static final String WRONG_WORDS_NAME = "wrong_words.txt";
    private static final String DIFFERENT_LENGTH_NAME = "different_lengths.txt";
    private static final String SINGLE_LINE_NAME = "single_line.txt";


    @Test
    public void testReadFromFileSuccess() throws IOException {
        //Create valid file
        File file = new File(VALID_FILE_NAME);
        FileWriter writer = new FileWriter(file);
        writer.write("cat, dog\n");
        writer.write("bat, rat, hat, mat\n");
        writer.close();

        //validate
        WordTransformerFileReader reader = new WordTransformerFileReader();
        Transform transform = reader.readFromFile(VALID_FILE_NAME);

        assertEquals("cat", transform.getStartWord());
        assertEquals("dog", transform.getEndWord());
        ArrayList<String> wordsList = transform.getWordsList();
        assertEquals(4, wordsList.size());
        assertEquals("bat", wordsList.get(0));
        assertEquals("rat", wordsList.get(1));
        assertEquals("hat", wordsList.get(2));
        assertEquals("mat", wordsList.get(3));

        //Delete the file
        file.delete();
    }

    @Test
    public void testReadFromFileEmptyFile() throws IOException {
        //Create empty file
        File file = new File(EMPTY_FILE_NAME);
        FileWriter writer = new FileWriter(file);

        //Validate
        WordTransformerFileReader reader = new WordTransformerFileReader();
        Transform transform = reader.readFromFile(EMPTY_FILE_NAME);
        assertNull(transform);

        //Delete the file
        file.delete();
    }

    @Test
    public void testReadFromFileWrongNumberOfWords() throws IOException {
        //Create file with wrong number of words in first line
        File file = new File(WRONG_WORDS_NAME);
        FileWriter writer = new FileWriter(file);
        writer.write("cat, dog, cot\n");
        writer.write("bat, rat, hat, mat\n");
        writer.close();

        //Validate
        WordTransformerFileReader reader = new WordTransformerFileReader();
        Transform transform = reader.readFromFile(WRONG_WORDS_NAME);
        assertNull(transform);

        //Delete the file
        file.delete();
    }

    @Test
    public void testReadFromFileDifferentWordLengths() throws IOException {
        //Create file with different length words in first line
        File file = new File(DIFFERENT_LENGTH_NAME);
        FileWriter writer = new FileWriter(file);
        writer.write("cat, dogs\n");
        writer.write("bat, rat, hat, mat\n");
        writer.close();

        //validate
        WordTransformerFileReader reader = new WordTransformerFileReader();
        Transform transform = reader.readFromFile(DIFFERENT_LENGTH_NAME);
        assertNull(transform);

        //Delete the file
        file.delete();
    }

    @Test
    public void testReadFromFileSingleLineFile() throws IOException {
        //Create file with only one line
        File file = new File(SINGLE_LINE_NAME);
        FileWriter writer = new FileWriter(file);
        writer.write("cat, dog\n");
        writer.close();

        //validate
        WordTransformerFileReader reader = new WordTransformerFileReader();
        Transform transform = reader.readFromFile(SINGLE_LINE_NAME);
        assertNull(transform);

        //Delete the file
        file.delete();
    }

    @Test
    public void testReadFromFileNonexistentFile() {
        WordTransformerFileReader reader = new WordTransformerFileReader();
        Transform transform = reader.readFromFile("nonexistent.txt");

        assertNull(transform);
    }
}
