package Advanced.StreamsFilesAndDirectories.Lab;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.List;

public class SortLines_06 {
    public static void main(String[] args) throws IOException {

        String path = "C:\\Users\\Marti\\IdeaProjects\\JavaAdvanced\\src\\Advanced\\StreamsFilesAndDirectories\\Lab\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\input.txt";

        List<String> lines = Files.readAllLines(Path.of(path));

        Collections.sort(lines);

        Path out = Paths.get("C:\\Users\\Marti\\IdeaProjects\\JavaAdvanced\\src\\Advanced\\StreamsFilesAndDirectories\\Lab" +
                "\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\Files-and-Streams\\output.txt");

        Files.write(out, lines);

    }
}
