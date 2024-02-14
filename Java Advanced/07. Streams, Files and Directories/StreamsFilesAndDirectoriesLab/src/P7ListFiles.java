import java.io.File;

public class P7ListFiles {
    public static void main(String[] args) {
        String inputPath = "D:\\Java SoftUni\\Java Advanced\\07. Streams, Files and Directories\\Files-and-Streams-Lab-Resources\\Files-and-Streams";
        String outputPath = "D:\\Java SoftUni\\Java Advanced\\07. Streams, Files and Directories\\Files-and-Streams-Lab-Resources\\06.SortLinesOutput.txt";

        File file = new File(inputPath);
        if (file.exists()) {
            if (file.isDirectory()) {
                File[] files = file.listFiles();
                for (File f : files) {
                    if (!f.isDirectory()) {
                        System.out.printf("%s: [%s]%n", f.getName(), f.length());
                    }
                }
            }
        }
    }
}
