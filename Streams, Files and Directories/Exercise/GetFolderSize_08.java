package Advanced.StreamsFilesAndDirectories.Exercise;

import java.io.File;

public class GetFolderSize_08 {
    public static void main(String[] args) {

        String path = "C:\\Users\\Marti\\IdeaProjects\\JavaAdvanced\\src\\Advanced\\StreamsFilesAndDirectories\\Exercise\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\Exercises Resources";

        File file = new File(path);
        //File[] files = file.listFiles();

        if (file.exists()) {
            long size = 0;
            if (file.isDirectory()){
                File[] files = file.listFiles();
                for (File f : files) {
                    if (!f.isDirectory()){
                        size+= f.length();
                    }
                }
            }
            System.out.println("Folder size: " + size);

        }

    }
}
