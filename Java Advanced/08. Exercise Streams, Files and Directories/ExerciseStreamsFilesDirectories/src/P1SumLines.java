import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class P1SumLines {
    public static void main(String[] args) {
        String path = "D:\\Java SoftUni\\Java Advanced\\08. Exercise Streams, Files and Directories\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\input.txt";

        //BufferedReader bufferedReader1 = Files.newBufferedReader(Paths.get(path));
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(path))){
            String line = bufferedReader.readLine();
            while (line != null) {
                int sum = 0;

                for (int i = 0; i < line.length(); i++) {
                    char symbol = line.charAt(i);
                    sum += symbol;
                }

                System.out.println(sum);
                line = bufferedReader.readLine();
            }
        }  catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}