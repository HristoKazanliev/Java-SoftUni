import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class P3CopyBytes {
    public static void main(String[] args) {
        String inputPath = "D:\\Java SoftUni\\Java Advanced\\07. Streams, Files and Directories\\Files-and-Streams-Lab-Resources\\input.txt";
        String outputPath = "D:\\Java SoftUni\\Java Advanced\\07. Streams, Files and Directories\\input.txt";

        try (FileInputStream fileStream = new FileInputStream(inputPath);
             FileOutputStream fileOutputStream = new FileOutputStream(outputPath)){
            int oneByte = fileStream.read();
            while (oneByte >= 0) {
                if (oneByte == 10 || oneByte == 32) {
                    fileOutputStream.write(oneByte);
                } else {
                    String digits = String.valueOf(oneByte);
                    for (int i = 0; i < digits.length(); i++) {
                        fileOutputStream.write(digits.charAt(i));
                    }
                }
                oneByte = fileStream.read();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
