package Advanced.StreamsFilesAndDirectories.Exercise;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;

public class CountCharacterTypes_04 {
    public static void main(String[] args) throws IOException {

        String path = "C:\\Users\\Marti\\IdeaProjects\\JavaAdvanced\\src\\Advanced\\StreamsFilesAndDirectories\\Exercise\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\input.txt";

        BufferedReader reader = Files.newBufferedReader(Path.of(path));

        String vowels = "aeiou";
        String punctuation = "!?.,";

        String line = reader.readLine();
        int vowelsCount = 0;
        int punctuationCount = 0;
        int othersCount = 0;
        while (line != null) {
            for (char c : line.toCharArray()) {
                if (vowels.contains(String.valueOf(c))){
                    vowelsCount++;
                } else if (punctuation.contains(String.valueOf(c))) {
                    punctuationCount++;
                } else if (c!=' ') {
                    othersCount++;
                }
            }
            line = reader.readLine();
        }
        System.out.printf("Vowels: %s\nOther symbols: %s\nPunctuation: %s", vowelsCount, othersCount, punctuationCount);

    }
}
