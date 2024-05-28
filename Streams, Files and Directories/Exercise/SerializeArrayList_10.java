package Advanced.StreamsFilesAndDirectories.Exercise;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SerializeArrayList_10 {
    public static void main(String[] args) {

        List<Double> numbers = new ArrayList<>(Arrays.asList(2.5, 3.5, 8.0));

        String path = "C:\\Users\\Marti\\IdeaProjects\\JavaAdvanced\\src\\Advanced\\StreamsFilesAndDirectories\\Exercise\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\file1.ser";

        try (ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(path))) {
            outputStream.writeObject(numbers);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        try (ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(path))) {
        List<Double> numbers2 = (List<Double>) inputStream.readObject();
            for (Double num : numbers2) {
                System.out.println(num);
            }
        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

    }
}
