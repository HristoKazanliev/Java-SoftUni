import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class P2WriteToFile {
    public static void main(String[] args) {
        String inputPath = "D:\\Java SoftUni\\Java Advanced\\07. Streams, Files and Directories\\Files-and-Streams-Lab-Resources\\input.txt";
        String outputPath = "D:\\Java SoftUni\\Java Advanced\\07. Streams, Files and Directories\\input.txt";
        List<Character> symbols = new ArrayList<>(Arrays.asList(',', '.', '?', '!'));

        try (FileInputStream fileInputStream = new FileInputStream(inputPath);
             FileOutputStream fileOutputStream = new FileOutputStream(outputPath)){
            int oneByte = fileInputStream.read();
            while (oneByte >= 0) {
                if (!symbols.contains((char)oneByte)) {
                    fileOutputStream.write(oneByte);
                }

                oneByte = fileInputStream.read();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
