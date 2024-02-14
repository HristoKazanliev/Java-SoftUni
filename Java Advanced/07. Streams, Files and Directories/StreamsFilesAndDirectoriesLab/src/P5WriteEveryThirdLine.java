import java.io.*;
import java.util.Scanner;

public class P5WriteEveryThirdLine {
    public static void main(String[] args) {
        String inputPath = "D:\\Java SoftUni\\Java Advanced\\07. Streams, Files and Directories\\Files-and-Streams-Lab-Resources\\input.txt";
        String outputPath = "D:\\Java SoftUni\\Java Advanced\\07. Streams, Files and Directories\\Files-and-Streams-Lab-Resources\\05.WriteEveryThirdLineOutput.txt";

        try (FileReader fileReader = new FileReader(inputPath);
             FileWriter fileWriter = new FileWriter(outputPath)) {
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            PrintWriter out = new PrintWriter(fileWriter);

            int counter = 1;
            String line = bufferedReader.readLine();
            while (line != null) {
                if (counter % 3 == 0) {
                    out.println(line);
                }
                counter++;
                line = bufferedReader.readLine();
            }
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
