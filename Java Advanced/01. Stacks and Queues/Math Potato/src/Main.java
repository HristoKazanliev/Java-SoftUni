import java.util.ArrayDeque;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] input = scanner.nextLine().split("\\s+");
        PriorityQueue<String> queue = new PriorityQueue<>();

        for (String child : input) {
            queue.offer(child);
        }

        int cycle = 1;
        int n = Integer.parseInt(scanner.nextLine());
        while (queue.size() > 1) {
            for (int i = 0; i < n - 1; i++) {
                queue.offer(queue.poll());
            }

            if (isPrime(cycle)) {
                System.out.println("Prime " + queue.peek());
            } else {
                System.out.println("Removed " + queue.poll());
            }

            cycle++;
        }

        System.out.println("Last is " + queue.poll());
    }

    public static boolean isPrime(int cycle) {
        // Corner case
        if (cycle <= 1)
            return false;

        // Check from 2 to n-1
        for (int i = 2; i < cycle; i++) {
            if (cycle % i == 0)
                return  false;
        }

        return true;
    }
}