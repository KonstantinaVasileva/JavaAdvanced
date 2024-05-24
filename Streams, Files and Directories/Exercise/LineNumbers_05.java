package Advanced.StreamsFilesAndDirectories.Exercise;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class LineNumbers_05 {
    public static void main(String[] args) {

        String path = "C:\\Users\\Marti\\IdeaProjects\\JavaAdvanced\\src\\Advanced\\StreamsFilesAndDirectories\\Exercise\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\inputLineNumbers.txt";
        String outPath = "C:\\Users\\Marti\\IdeaProjects\\JavaAdvanced\\src\\Advanced\\StreamsFilesAndDirectories\\Exercise\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\output.txt";

        try (BufferedReader reader = Files.newBufferedReader(Path.of(path));
             BufferedWriter writer = Files.newBufferedWriter(Path.of(outPath))) {

            String line = reader.readLine();
            int countLine = 1;
            while (line!=null){
                writer.write(String.format("%s. %s", countLine, line));
                writer.newLine();
                line = reader.readLine();
                countLine++;
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
