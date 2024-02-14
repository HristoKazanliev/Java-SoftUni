import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class P9SerializeCustomObject {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        //color: "green", w: 15.3, h: 12.4 and d: 3
        Cube cube = new Cube();
        cube.color = "Green";
        cube.width = 15.3;
        cube.height = 12.4;
        cube.depth = 3;

        String path = "D:\\Java SoftUni\\Java Advanced\\07. Streams, Files and Directories\\cube.txt";
        try (ObjectOutputStream oos = new ObjectOutputStream(
                new FileOutputStream(path))) {
            oos.writeObject(cube);
        } catch (IOException e) {
            e.printStackTrace();
        }

//        List<String> names = new ArrayList<>();
//        Collections.addAll(names, "Mimi", "Gosho");
//        FileOutputStream fos = new FileOutputStream(path);
//        ObjectOutputStream oos =
//                new ObjectOutputStream(fos);
//        oos.writeObject(names);

//        FileInputStream fis =
//                new FileInputStream(path);
//        ObjectInputStream oos =
//                new ObjectInputStream(fis);
//        List<String> names =
//                (List<String>) oos.readObject();
//        System.out.println(names);
    }
}
