import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class P2SumBytes {
    public static void main(String[] args) {
        String path = "D:\\Java SoftUni\\Java Advanced\\08. Exercise Streams, Files and Directories\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\input.txt";

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(path))){
            String line = bufferedReader.readLine();
            long sum = 0;
            while (line != null) {
                for (char c : line.toCharArray()) {
                    sum += c;
                }

                line = bufferedReader.readLine();
            }

            System.out.println(sum);
        }  catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
