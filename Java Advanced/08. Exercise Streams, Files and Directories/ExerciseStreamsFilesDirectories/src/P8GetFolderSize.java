import java.io.File;

public class P8GetFolderSize {
    public static void main(String[] args) {
        String path = "D:\\Java SoftUni\\Java Advanced\\08. Exercise Streams, Files and Directories\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\Exercises Resources";

        File file = new File(path);
        int size = 0;
        if ( file.isDirectory() ) {
            File[] files = file.listFiles();
            for (File f : files) {
                size += f.length();
            }
        }

        System.out.printf("Folder size: %d", size);
    }
}
