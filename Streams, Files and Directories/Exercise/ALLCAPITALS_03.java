package Advanced.StreamsFilesAndDirectories.Exercise;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class ALLCAPITALS_03 {
    public static void main(String[] args) {

        String path = "C:\\Users\\Marti\\IdeaProjects\\JavaAdvanced\\src\\Advanced\\StreamsFilesAndDirectories\\Exercise\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\input.txt";
        String outPath = "C:\\Users\\Marti\\IdeaProjects\\JavaAdvanced\\src\\Advanced\\StreamsFilesAndDirectories\\Exercise\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\output.txt";

        try (BufferedReader reader = Files.newBufferedReader(Path.of(path));
             BufferedWriter writer = Files.newBufferedWriter(Path.of(outPath))) {
            String line = reader.readLine();
            while (line!=null){
                writer.write(line.toUpperCase());
                writer.newLine();
                line = reader.readLine();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
