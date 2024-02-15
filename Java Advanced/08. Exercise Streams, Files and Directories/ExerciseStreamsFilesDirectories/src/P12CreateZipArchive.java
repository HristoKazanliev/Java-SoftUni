import java.io.*;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class P12CreateZipArchive {
    public static void main(String[] args) {
        String inputOnePath = "D:\\Java SoftUni\\Java Advanced\\08. Exercise Streams, Files and Directories\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\inputOne.txt";
        String inputTwoPath = "D:\\Java SoftUni\\Java Advanced\\08. Exercise Streams, Files and Directories\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\inputTwo.txt";
        String inputThreePath = "D:\\Java SoftUni\\Java Advanced\\08. Exercise Streams, Files and Directories\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\inputLineNumbers.txt";
        String outputPath = "D:\\Java SoftUni\\Java Advanced\\08. Exercise Streams, Files and Directories\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\files.zip";
        List<String> paths = List.of(inputOnePath, inputTwoPath, inputThreePath);

        try (FileOutputStream fileOutputStream = new FileOutputStream(outputPath);
             ZipOutputStream zipOutputStream = new ZipOutputStream(fileOutputStream)) {
            for (String path : paths) {
                File file = new File(path);
                FileInputStream fileInputStream = new FileInputStream(file);
                ZipEntry zipEntry = new ZipEntry(file.getName());
                zipOutputStream.putNextEntry(zipEntry);

                int oneByte = fileInputStream.read();
                while (oneByte != -1) {
                    zipOutputStream.write(oneByte);

                    oneByte = fileInputStream.read();
                }
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
