package Advanced.StreamsFilesAndDirectories.Lab;

import java.io.File;

public class NestedFolders_08 {
    public static void main(String[] args) {

        File file = new File("C:\\Users\\Marti\\IdeaProjects\\JavaAdvanced\\src\\Advanced\\StreamsFilesAndDirectories\\Lab\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\Files-and-Streams");

        if (file.exists()){
            int count = 0;
            if (file.isDirectory()) {
                System.out.println(file.getName());
                count++;
                count = printer(file, count);
            }
            System.out.println(count);
        }
    }

    private static int printer(File file, int count) {

            File[] files =  file.listFiles();
            for (int i = 0; i < files.length; i++) {
                if (files[i].isDirectory()) {
                    System.out.println(files[i].getName());
                    count++;
                   count =  printer(files[i], count);
                }
            }

        return count;
    }
}
