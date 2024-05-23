package Advanced.StreamsFilesAndDirectories.Lab;

import java.io.*;
import java.util.Scanner;

public class ExtractIntegers_04 {
    public static void main(String[] args) throws IOException {

        String path = "C:\\Users\\Marti\\IdeaProjects\\JavaAdvanced\\src\\Advanced\\StreamsFilesAndDirectories\\Lab\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\input.txt";
        Scanner scanner = new Scanner(new FileInputStream(path));

        PrintWriter print = new PrintWriter(new FileOutputStream("C:\\Users\\Marti\\IdeaProjects\\JavaAdvanced\\src\\Advanced\\StreamsFilesAndDirectories\\Lab\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\04.ExtractIntegersOutput.txt"));

        while (scanner.hasNext()){

            if (scanner.hasNextInt()){
                print.println(scanner.next());
            }
            scanner.next();
        }
        print.close();
    }
}
