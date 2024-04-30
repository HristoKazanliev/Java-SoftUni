import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Arrays;
import java.util.Comparator;

public class Main {
    public static void main(String[] args) {
        Field[] fields = Reflection.class.getDeclaredFields();
        sortFields(fields);

        for (Field field : fields) {
            if (!Modifier.isPrivate(field.getModifiers())) {
                System.out.printf("%s must be private!%n", field.getName());
            }
        }

        Method[] methods = Reflection.class.getDeclaredMethods();
        sortMethods(methods);

        for (Method method : methods) {
            if (method.getName().startsWith("get") && method.getParameterCount() == 0) {
                if (!Modifier.isPublic(method.getModifiers())) {
                    System.out.printf("%s have to be public!%n", method.getName(), method.getReturnType().getTypeName());
                }
            }
        }

        for (Method method : methods) {
            if (method.getName().startsWith("set") && method.getParameterCount() == 1) {
                if (!Modifier.isPrivate(method.getModifiers())) {
                    System.out.printf("%s have to be private!%n", method.getName(), method.getParameterTypes()[0].getTypeName());
                }
            }
        }
    }

    private static void sortMethods(Method[] methods) {
        Arrays.sort(methods, Comparator.comparing(Method::getName));
    }

    private static void sortFields(Field[] fields) {
        Arrays.sort(fields, Comparator.comparing(Field::getName));
    }
}