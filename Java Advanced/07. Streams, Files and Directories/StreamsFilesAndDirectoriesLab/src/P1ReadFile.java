import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class P1ReadFile {
    public static void main(String[] args) {
        String path = "D:\\Java SoftUni\\Java Advanced\\07. Streams, Files and Directories\\Files-and-Streams-Lab-Resources\\input.txt";

        try (FileInputStream fileStream = new FileInputStream(path)){
            int oneByte = fileStream.read();
            while (oneByte >= 0) {
                System.out.printf("%s ", Integer.toBinaryString(oneByte));
                oneByte = fileStream.read();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
