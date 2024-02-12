import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, List<Double>> students = new TreeMap<>();

        int n = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < n; i++) {
            String[] input = scanner.nextLine().split("\\s+");
            String name = input[0];
            double grade = Double.parseDouble(input[1]);

            //students.putIfAbsent(name, new ArrayList<>());
            if (students.containsKey(name)) {
                students.get(name).add(grade);
            } else {
                students.put(name, new ArrayList<>());
                students.get(name).add(grade);
            }
        }

        for (String student : students.keySet()) {
            System.out.print(student + " -> ");
            double sum = 0;
            for (int i = 0; i < students.get(student).size(); i++) {
                System.out.printf("%.2f ", students.get(student).get(i));
                sum += students.get(student).get(i);
            }
            sum /= students.get(student).size();
            System.out.printf("(avg: %.2f)\n", sum);
        }
    }
}