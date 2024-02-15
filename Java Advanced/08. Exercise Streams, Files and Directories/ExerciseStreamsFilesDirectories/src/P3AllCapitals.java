import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class P3AllCapitals {
    public static void main(String[] args) {
        String inputPath = "D:\\Java SoftUni\\Java Advanced\\08. Exercise Streams, Files and Directories\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\input.txt";
        String outputPath = "D:\\Java SoftUni\\Java Advanced\\08. Exercise Streams, Files and Directories\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\output.txt";

        try (BufferedReader bufferedReader = Files.newBufferedReader(Path.of(inputPath));
             BufferedWriter bufferedWriter = Files.newBufferedWriter(Path.of(outputPath))){
            String line = bufferedReader.readLine();

            while (line != null) {
                bufferedWriter.write(line.toUpperCase());
                bufferedWriter.newLine();

                line = bufferedReader.readLine();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
