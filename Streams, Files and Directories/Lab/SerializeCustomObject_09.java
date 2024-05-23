package Advanced.StreamsFilesAndDirectories.Lab;

import java.io.*;

public class SerializeCustomObject_09 {
    public static void main(String[] args) {

        Cube cube = new Cube();
        cube.color = "green";
        cube.width = 15.3;
        cube.height = 12.4;
        cube.depth = 3;

        String path = "C:\\Users\\Marti\\IdeaProjects\\JavaAdvanced\\src\\Advanced\\StreamsFilesAndDirectories\\Lab\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\file.ser";

        try (ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(path))) {
        outputStream.writeObject(cube);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        try (ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(path))) {
        Cube cube1 = (Cube) inputStream.readObject();

            System.out.println(cube1.color);
            System.out.println(cube1.height);
            System.out.println(cube1.width);
            System.out.println(cube1.depth);

        } catch (ClassNotFoundException | IOException e) {
            throw new RuntimeException(e);
        }
    }
}
