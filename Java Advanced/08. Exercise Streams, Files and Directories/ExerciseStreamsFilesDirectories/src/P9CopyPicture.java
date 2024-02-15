import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class P9CopyPicture {
    public static void main(String[] args) {
        String inputPath = "C:\\Users\\User\\OneDrive\\Pictures\\img13.jpg";
        String outputPath = "C:\\Users\\User\\OneDrive\\Pictures\\picture-copy.jpg";

        try (FileInputStream fileInputStream = new FileInputStream(inputPath);
             FileOutputStream fileOutputStream = new FileOutputStream(outputPath)) {
            int oneByte = fileInputStream.read();

            while (oneByte != -1) {
                fileOutputStream.write(oneByte);

                oneByte = fileInputStream.read();
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
