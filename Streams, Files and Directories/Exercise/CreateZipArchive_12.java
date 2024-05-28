package Advanced.StreamsFilesAndDirectories.Exercise;

import java.io.*;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class CreateZipArchive_12 {
    public static void main(String[] args) {

        String path1 = "C:\\Users\\Marti\\IdeaProjects\\JavaAdvanced\\src\\Advanced\\StreamsFilesAndDirectories\\Exercise\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\inputOne.txt";
        String path2 = "C:\\Users\\Marti\\IdeaProjects\\JavaAdvanced\\src\\Advanced\\StreamsFilesAndDirectories\\Exercise\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\inputTwo.txt";
        String path3 = "C:\\Users\\Marti\\IdeaProjects\\JavaAdvanced\\src\\Advanced\\StreamsFilesAndDirectories\\Exercise\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\input.txt";

        String outPath = "C:\\Users\\Marti\\IdeaProjects\\JavaAdvanced\\src\\Advanced\\StreamsFilesAndDirectories\\Exercise\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\files.zip";

        List<String> paths = List.of(path1, path2, path3);

        try (FileOutputStream outputStream = new FileOutputStream(outPath);
             ZipOutputStream zipOutputStream = new ZipOutputStream(outputStream)) {

            for (String path : paths) {
                File fileToZip = new File(path);
                FileInputStream inputStream = new FileInputStream(path);
                ZipEntry zipEntry = new ZipEntry(fileToZip.getName());
                zipOutputStream.putNextEntry(zipEntry);

                int oneByte = inputStream.read();
                while (oneByte != -1) {
                    zipOutputStream.write(oneByte);
                    oneByte = inputStream.read();
                }
                inputStream.close();
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
