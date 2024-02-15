import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class P5LineNumbers {
    public static void main(String[] args) {
        String inputPath = "D:\\Java SoftUni\\Java Advanced\\08. Exercise Streams, Files and Directories\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\inputLineNumbers.txt";
        String outputPath = "D:\\Java SoftUni\\Java Advanced\\08. Exercise Streams, Files and Directories\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\output2.txt";

        try (BufferedReader bufferedReader = Files.newBufferedReader(Path.of(inputPath));
             BufferedWriter bufferedWriter = Files.newBufferedWriter(Path.of(outputPath))){
            List<String> lines = Files.readAllLines(Path.of(inputPath));
            int lineNum = 1;

            for (String line : lines) {
                 bufferedWriter.write(lineNum + ". " + line);
                 bufferedWriter.newLine();
                 lineNum++;
            }
        }  catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
