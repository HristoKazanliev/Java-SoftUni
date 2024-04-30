import java.util.Arrays;

public class Tracker {
    @Author(name = "George")
    public static void main(String[] args) {
        Tracker.printMethodsByAuthor(Tracker.class);
    }
    @Author(name = "Peter")
    public static void printMethodsByAuthor(Class<?> cl){
        Arrays.stream(cl.getDeclaredMethods())
                .filter(a -> a.isAnnotationPresent(Author.class))
                .forEach(m -> {
                    System.out.println(m.getAnnotation(Author.class).name() + ": " + m.getName());
                });

    }
}
