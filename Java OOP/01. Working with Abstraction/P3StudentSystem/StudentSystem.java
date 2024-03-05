import java.util.Dictionary;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class StudentSystem {
    private Map<String, Student> students;

    public StudentSystem() {
        this.students = new HashMap<>();
    }

    public Map<String, Student> getRepo() {
        return this.students;
    }
    public void parseCommand(String[] args)
    {
//        Scanner scanner = new Scanner(System.in);
//        String[] args = scanner.nextLine().split(" ");
        String command = args[0];
        if ("Create".equals(command)) {
            createStudent(args);
        } else if ("Show".equals(command)) {
            showStudent(args);
        }

//        if (args[0].equals("Create"))
//        {
//            var name = args[1];
//            var age = Integer.parseInt(args[2]);
//            var grade =Double.parseDouble(args[3]);
//            if (!students.containsKey(name))
//            {
//                var student = new Student(name, age, grade);
//                students.put(name,student);
//            }
//        }
//        else if (args[0].equals("Show"))
//        {
//            var name = args[1];
//            if (students.containsKey(name))
//            {
//                var student = students.get(name);
//                String view = String.format("%s is %s years old.",student.getName(),student.getAge());
//
//                if (student.getGrade() >= 5.00)
//                {
//                    view += " Excellent student.";
//                }
//                else if (student.getGrade() < 5.00 && student.getGrade() >= 3.50)
//                {
//                    view += " Average student.";
//                }
//                else
//                {
//                    view += " Very nice person.";
//                }
//
//                System.out.println(view);
//            }
//        }
    }

    private void createStudent(String[] cmdParts) {
        String name = cmdParts[1];
        int age = Integer.parseInt(cmdParts[2]);
        double grade = Double.parseDouble(cmdParts[3]);
        Student student = new Student(name, age, grade);
        students.putIfAbsent(name, student);
    }

    private void showStudent(String[] cmdParts) {
        String name = cmdParts[1];
        if (students.containsKey(name)) {
            Student student = students.get(name);
            StringBuilder output = new StringBuilder();
            output.append(student.toString());
            if (student.getGrade() >= 5.00) {
                output.append(" Excellent student.");
            }  else if (student.getGrade() < 5.00 && student.getGrade() >= 3.50) {
                output.append(" Average student.");
            } else {
                output.append(" Very nice person.");
            }
            System.out.println(output);
        }
    }
}
