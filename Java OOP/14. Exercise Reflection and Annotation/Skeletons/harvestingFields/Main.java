package harvestingFields;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		Class<RichSoilLand> richSoilLandClass = RichSoilLand.class;
		Field[] fields = richSoilLandClass.getDeclaredFields();

		String input = scanner.nextLine();
		while (!"HARVEST".equals(input)) {
			if ("all".equals(input)) {
				Arrays.stream(fields)
						.forEach(f -> System.out.printf("%s %s %s %n", Modifier.toString(f.getModifiers()), f.getType().getSimpleName(), f.getName()));
			} else {
				String accessModifier = input;
				Arrays.stream(fields)
						.filter(field -> Modifier.toString(field.getModifiers()).equals(accessModifier))
						.forEach(field -> System.out.printf("%s %s %s %n", Modifier.toString(field.getModifiers()), field.getType().getSimpleName(), field.getName()));
			}

			input = scanner.nextLine();
		}
	}
}
