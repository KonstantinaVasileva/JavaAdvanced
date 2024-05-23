package Advanced.StreamsFilesAndDirectories.Lab;

import java.io.*;

public class WriteToFile_02 {
    public static void main(String[] args) throws FileNotFoundException {

        String path = "C:\\Users\\Marti\\IdeaProjects\\JavaAdvanced\\src\\Advanced\\StreamsFilesAndDirectories\\Lab\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\input.txt";
        try (FileOutputStream fileOutputStream = new FileOutputStream("C:\\Users\\Marti\\IdeaProjects\\JavaAdvanced\\src\\Advanced\\StreamsFilesAndDirectories\\Lab\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\02.WriteToFileOutput.txt")) {

            try (FileInputStream fileInputStream = new FileInputStream(path)) {
                int oneByte = fileInputStream.read();
                String punctuation = ",.!?";
                while (oneByte != -1) {
                    if (!punctuation.contains(String.valueOf((char) oneByte))) {
                        fileOutputStream.write(oneByte);
                    }
                    oneByte = fileInputStream.read();
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
