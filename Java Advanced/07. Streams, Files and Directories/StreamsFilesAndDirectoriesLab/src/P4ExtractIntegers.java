import java.io.*;
import java.util.Scanner;

public class P4ExtractIntegers {
    public static void main(String[] args) {
        String inputPath = "D:\\Java SoftUni\\Java Advanced\\07. Streams, Files and Directories\\Files-and-Streams-Lab-Resources\\input.txt";
        String outputPath = "D:\\Java SoftUni\\Java Advanced\\07. Streams, Files and Directories\\Files-and-Streams-Lab-Resources\\04.ExtractIntegersOutput.txt";

        try (FileReader fileReader = new FileReader(inputPath)){
            Scanner scanner = new Scanner(new FileInputStream(inputPath));
            PrintWriter out = new PrintWriter(new FileOutputStream(outputPath));

            while (scanner.hasNext()) {
                if (scanner.hasNextInt()) {
                    out.println(scanner.nextInt());
                }

                scanner.next();
            }
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
