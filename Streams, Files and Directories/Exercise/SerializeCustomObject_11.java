package Advanced.StreamsFilesAndDirectories.Exercise;

import java.io.*;

public class SerializeCustomObject_11 {
    public static void main(String[] args) {

        Course course = new Course();
        course.name = "Java";
        course.student = "Pesho";

        String path = "C:\\Users\\Marti\\IdeaProjects\\JavaAdvanced\\src\\Advanced\\StreamsFilesAndDirectories\\Exercise\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\file2.ser";

        try (ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(path))) {
        outputStream.writeObject(course);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        try (ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(path))) {

            Course course1 = (Course) inputStream.readObject();
            System.out.println(course1.name);
            System.out.println(course1.student);
        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
