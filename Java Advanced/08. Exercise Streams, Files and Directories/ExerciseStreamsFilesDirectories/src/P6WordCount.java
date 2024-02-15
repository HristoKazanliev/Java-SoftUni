import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class P6WordCount {
    public static void main(String[] args) {
        String pathWords  = "D:\\Java SoftUni\\Java Advanced\\08. Exercise Streams, Files and Directories\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\words.txt";
        String pathText  = "D:\\Java SoftUni\\Java Advanced\\08. Exercise Streams, Files and Directories\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\text.txt";
        String outputPath = "D:\\Java SoftUni\\Java Advanced\\08. Exercise Streams, Files and Directories\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\output3.txt";

        Map<String, Integer> countWords = new HashMap<>();

        try (BufferedWriter bufferedWriter = Files.newBufferedWriter(Path.of(outputPath))) {
            List<String> linesFromWords = Files.readAllLines(Path.of(pathWords));
            for (String line : linesFromWords) {
                String[] currWordsLine = line.split("\\s+");
                Arrays.stream(currWordsLine).forEach(word -> {
                    countWords.put(word, 0);
                });
            }

            List<String> linesFromText = Files.readAllLines(Path.of(pathText));
            for (String line : linesFromText) {
                line = line.replaceAll("[\\.\\,\\?\\!\\:]", "");
                String[] currWordsLine = line.split("\\s+");
                Arrays.stream(currWordsLine).forEach(word -> {
                    if (countWords.containsKey(word))
                        countWords.put(word, countWords.get(word) + 1);
                });
            }

            countWords.entrySet().stream()
                    .sorted((e1, e2) -> e2.getValue().compareTo(e1.getValue()))
                    .forEach(entry -> {
                        try {
                            bufferedWriter.write(entry.getKey() + " - " + entry.getValue());
                            bufferedWriter.newLine();
                        } catch (IOException e) {
                            throw new RuntimeException(e);
                        }
                    });

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
