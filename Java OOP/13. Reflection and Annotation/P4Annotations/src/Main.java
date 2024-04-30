import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Class<Reflection> reflectionClass = Reflection.class;
        if(reflectionClass.isAnnotationPresent(Subject.class)){
            final var annotation = reflectionClass.getAnnotation(Subject.class);
            System.out.println(Arrays.toString(annotation.categories()));
        }
    }
}