import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class P7MergeTwoFiles {
    public static void main(String[] args) {
        String inputOnePath = "D:\\Java SoftUni\\Java Advanced\\08. Exercise Streams, Files and Directories\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\inputOne.txt";
        String inputTwoPath = "D:\\Java SoftUni\\Java Advanced\\08. Exercise Streams, Files and Directories\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\inputTwo.txt";
        String outputPath = "D:\\Java SoftUni\\Java Advanced\\08. Exercise Streams, Files and Directories\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\output4.txt";

        try (BufferedReader bufferedReader1 = new BufferedReader(new FileReader(inputOnePath));
             BufferedReader bufferedReader2 = new BufferedReader(new FileReader(inputTwoPath));
             BufferedWriter bufferedWriter = Files.newBufferedWriter(Path.of(outputPath))){
            String line = bufferedReader1.readLine();
            while (line != null) {
                bufferedWriter.write(line);
                bufferedWriter.newLine();
                line = bufferedReader1.readLine();
            }

            line = bufferedReader2.readLine();
            while (line != null) {
                bufferedWriter.write(line);
                bufferedWriter.newLine();
                line = bufferedReader2.readLine();
            }

//          PrintWriter writer = new PrintWriter("outputMerge.txt");
//
//          List<String> allLinesFileOne = Files.readAllLines(Path.of(inputOnePath));
//          allLinesFileOne.forEach(line -> writer.println(line));
//          List<String> allLinesFileTwo = Files.readAllLines(Path.of(inputTwoPath));
//          allLinesFileTwo.forEach(line -> writer.println(line));
        }  catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
