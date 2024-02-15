import java.io.*;

public class P11SerializeCustomObject {
    public static void main(String[] args) {
        String outputPath = "D:\\Java SoftUni\\Java Advanced\\08. Exercise Streams, Files and Directories\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\course.ser";

        Course course1 = new Course("Java", 100);
        Course course2 = new Course("C#", 150);

        try (FileOutputStream fileOutputStream = new FileOutputStream(outputPath);
             ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
             FileInputStream fileInputStream = new FileInputStream(outputPath);
             ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream)){
            //serializing
            objectOutputStream.writeObject(course1);

            //deserializing
            Course deserializedCourse = (Course) objectInputStream.readObject();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
