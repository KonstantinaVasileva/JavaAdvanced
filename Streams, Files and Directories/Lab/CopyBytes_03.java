package Advanced.StreamsFilesAndDirectories.Lab;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class CopyBytes_03 {
    public static void main(String[] args) {

        String path = "C:\\Users\\Marti\\IdeaProjects\\JavaAdvanced\\src\\Advanced\\StreamsFilesAndDirectories\\Lab\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\input.txt";

        try (FileInputStream fileInputStream = new FileInputStream(path)) {
            try (FileOutputStream fileOutputStream = new FileOutputStream("C:\\Users\\Marti\\IdeaProjects\\JavaAdvanced\\src\\Advanced\\StreamsFilesAndDirectories\\Lab\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\03.CopyBytesOutput.txt")) {

                int oneByte = fileInputStream.read();
                while (oneByte != -1) {
                    if ((char) oneByte == ' ' || (char) oneByte == '\n') {
                        fileOutputStream.write((char) oneByte);
                    } else {
                        String message = String.valueOf(oneByte);

                        for (char c : message.toCharArray()) {
                            fileOutputStream.write(c);
                        }
                    }
                    oneByte = fileInputStream.read();
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
