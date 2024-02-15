import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Set;

public class P4CountCharacterTypes {
    public static void main(String[] args) {
        String inputPath = "D:\\Java SoftUni\\Java Advanced\\08. Exercise Streams, Files and Directories\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\input.txt";
        String outputPath = "D:\\Java SoftUni\\Java Advanced\\08. Exercise Streams, Files and Directories\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\output2.txt";

        Set<Character> vowels = Set.of('a', 'e', 'i', 'o', 'u');
        Set <Character> punctuations = Set.of('!', ',', '.', '?');
        int vowelsCount = 0;
        int punctuationsCount = 0;
        int othersCount = 0;

        try (BufferedReader bufferedReader = Files.newBufferedReader(Path.of(inputPath));
             BufferedWriter bufferedWriter = Files.newBufferedWriter(Path.of(outputPath))) {
            String line = bufferedReader.readLine();
            while (line != null) {
                for (int i = 0; i < line.length(); i++) {
                    char c = line.charAt(i);
                    if ( vowels.contains(c) ) {
                        vowelsCount++;
                    } else if ( punctuations.contains(c) ) {
                        punctuationsCount++;
                    } else if ( c != ' ' ) {
                        othersCount++;
                    }
                }

                line = bufferedReader.readLine();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        System.out.println("Vowels: " + vowelsCount);
        System.out.println("Other symbols: " + othersCount);
        System.out.println("Punctuation: " + punctuationsCount);
    }
}
