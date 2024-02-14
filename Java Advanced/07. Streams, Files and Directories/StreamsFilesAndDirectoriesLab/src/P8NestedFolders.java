import java.io.File;
import java.util.ArrayDeque;
import java.util.Deque;

public class P8NestedFolders {
    public static void main(String[] args) {
        String inputPath = "D:\\Java SoftUni\\Java Advanced\\07. Streams, Files and Directories\\Files-and-Streams-Lab-Resources";
        File file = new File(inputPath);
        int count = 0;
        if (file.exists()) {
            count += countFile(file);
        }
        System.out.println(count + " folders");
    }
    public static int countFile(File file){
        int count = 0;
        if(file.exists()){
            if(file.isDirectory()){
                File[] files = file.listFiles();
                for (File f : files) {
                    if (f.isDirectory()) {
                        System.out.printf("%s\n",
                                f.getName());
                        count++;
                    }
                }
                for(File f : files) {
                    count += countFile(f);
                }
            }

        }
        return count;
    }
}
