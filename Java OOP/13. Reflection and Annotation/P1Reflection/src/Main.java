import java.lang.reflect.InvocationTargetException;

public class Main {
    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        Class<Reflection> reflectionClass = Reflection.class;

        System.out.println(reflectionClass);
        Class superClass = reflectionClass.getSuperclass();
        System.out.println(superClass);
        Class[] interfaces = reflectionClass.getInterfaces();
        for (Class anInterface : interfaces) {
            System.out.println(anInterface);
        }

        Object reflectionObj = reflectionClass.getDeclaredConstructor().newInstance();
        System.out.println(reflectionObj);
    }
}