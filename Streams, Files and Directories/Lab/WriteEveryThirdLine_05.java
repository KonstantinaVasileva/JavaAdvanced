package Advanced.StreamsFilesAndDirectories.Lab;

import java.io.*;

public class WriteEveryThirdLine_05 {
    public static void main(String[] args) {

        String path = "C:\\Users\\Marti\\IdeaProjects\\JavaAdvanced\\src\\Advanced\\StreamsFilesAndDirectories\\Lab\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\input.txt";

        try (BufferedReader in = new BufferedReader(new FileReader(path))) {
            PrintWriter out = new PrintWriter(new FileWriter(
                    "C:\\Users\\Marti\\IdeaProjects\\JavaAdvanced\\src\\Advanced\\StreamsFilesAndDirectories\\Lab\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\05.WriteEveryThirdLineOutput.txt"));

            String line = in.readLine();
            int count = 1;
            while (line != null) {
                if (count % 3 == 0) {
                    out.println(line);
                }
                line = in.readLine();
                count++;

            }
            out.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
