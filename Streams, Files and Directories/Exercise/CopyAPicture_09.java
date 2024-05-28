package Advanced.StreamsFilesAndDirectories.Exercise;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class CopyAPicture_09 {
    public static void main(String[] args) {
        String path = "C:\\Users\\Marti\\IdeaProjects\\JavaAdvanced\\src\\Advanced\\StreamsFilesAndDirectories\\Exercise\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\picture.jpg";
        String outPath = "C:\\Users\\Marti\\IdeaProjects\\JavaAdvanced\\src\\Advanced\\StreamsFilesAndDirectories\\Exercise\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\pictureCopy.jpg";

        try (FileInputStream inputStream = new FileInputStream(path);
             FileOutputStream outputStream = new FileOutputStream(outPath)) {
            int oneByte = inputStream.read();
            while (oneByte !=-1){
                outputStream.write(oneByte);
                oneByte = inputStream.read();
            }


        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
