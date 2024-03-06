import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Signal[] signals = Arrays.stream(scanner.nextLine().split("\\s+"))
                                .map(Signal::valueOf)
                                .toArray(Signal[]::new);
        int n = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < n; i++) {
            Signal.changeSignals(signals);
            Signal.print(signals);
        }
    }
}