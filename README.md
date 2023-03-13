Word Transformer Application

The Word Transformer application is a command-line tool that finds the shortest path between two words in a list of words, read from a file. The application uses the WordTransformer class to perform the transformation and returns the shortest path found.

Usage

To use the Word Transformer application, run the main method and provide the path to the input file as a command-line argument. The input file should contain start and end words in the first line followed by a list of words separated by a comma in the second line. The application reads the input file, performs the word transformation, and returns the shortest path found.

mvn clean compile exec:java

To specify custom file
mvn exec:java -Dexec.args={"change_me.txt"}

Word Transformer Algorithm

The Word Transformer class provides a method for finding the shortest path between two words in a list of words, where each path consists of transforming one word into another word by changing one letter at a time. 





