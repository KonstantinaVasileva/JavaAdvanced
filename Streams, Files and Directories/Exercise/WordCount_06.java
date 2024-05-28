package Advanced.StreamsFilesAndDirectories.Exercise;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

public class WordCount_06 {
    public static void main(String[] args) throws IOException {

        String path2 = "C:\\Users\\Marti\\IdeaProjects\\JavaAdvanced\\src\\Advanced\\StreamsFilesAndDirectories\\Exercise\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\text.txt";
        String path1 = "C:\\Users\\Marti\\IdeaProjects\\JavaAdvanced\\src\\Advanced\\StreamsFilesAndDirectories\\Exercise\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\words.txt";
        String outPath = "C:\\Users\\Marti\\IdeaProjects\\JavaAdvanced\\src\\Advanced\\StreamsFilesAndDirectories\\Exercise\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\output.txt";

        Map<String, Integer> wordsCounter = new LinkedHashMap<>();

        String[] wordsForCount = Files.readAllLines(Path.of(path1)).toString().replaceAll("[\\[,\\]]", "").split(" ");

        for (String s : wordsForCount) {
            wordsCounter.put(s, 0);
        }

        try (BufferedReader reader = Files.newBufferedReader(Path.of(path2))) {
            String line = reader.readLine();
            while (line != null) {
                String[] words = line.split(" ");
                for (String word : words) {
                    if (wordsCounter.containsKey(word)) {
                        wordsCounter.put(word, wordsCounter.get(word) + 1);
                    }
                }
                line = reader.readLine();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        try (BufferedWriter writer = Files.newBufferedWriter(Path.of(outPath))) {
            wordsCounter.entrySet().stream().sorted(Map.Entry.comparingByValue());
            for (Map.Entry<String, Integer> entry : wordsCounter.entrySet()) {
                String key = entry.getKey();
                Integer value = entry.getValue();
                writer.write(String.format("%s - %s\n", key, value));
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
