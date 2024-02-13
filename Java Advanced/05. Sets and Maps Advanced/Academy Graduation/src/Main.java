import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, Double[]> graduationList = new TreeMap<>();

        int n = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < n; i++) {
            String name = scanner.nextLine();
            String[] gradesArr = scanner.nextLine().split("\\s+");
            Double[] grades = new Double[gradesArr.length];

            for (int j = 0; j < gradesArr.length; j++) {
                grades[j] = Double.parseDouble(gradesArr[j]);
            }
            graduationList.put(name, grades);
        }

        for (String student : graduationList.keySet()) {
            System.out.print(student + " is graduated with ");
            double avg = 0;
            for (int i = 0; i < graduationList.get(student).length; i++) {
                avg += graduationList.get(student)[i];
            }
            avg /= graduationList.get(student).length;
            System.out.println(avg);
        }
    }
}