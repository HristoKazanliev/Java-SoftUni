import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class P6SortLines {
    public static void main(String[] args) {
        String inputPath = "D:\\Java SoftUni\\Java Advanced\\07. Streams, Files and Directories\\Files-and-Streams-Lab-Resources\\input.txt";
        String outputPath = "D:\\Java SoftUni\\Java Advanced\\07. Streams, Files and Directories\\Files-and-Streams-Lab-Resources\\06.SortLinesOutput.txt";

        try {
            Path path = Paths.get(inputPath);
            Path path2 = Paths.get(outputPath);

            List<String> lines = Files.readAllLines(path);
            lines = lines.stream()
                    .filter(l -> !l.isBlank()).collect(Collectors.toList());
            Collections.sort(lines);
            Files.write(path2, lines);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
