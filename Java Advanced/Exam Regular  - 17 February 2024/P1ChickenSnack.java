import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.Scanner;

public class P1ChickenSnack {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Deque<Integer> pocketStack = new ArrayDeque<>();
        Deque<Integer> priceQueue = new ArrayDeque<>();

        Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .forEach(pocketStack::push);

        Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .forEach(priceQueue::offer);

        int foodCount = 0;
        while (!pocketStack.isEmpty() && !priceQueue.isEmpty()) {
            int currMoney = pocketStack.peek();
            int currPrice = priceQueue.peek();
            int change = 0;

            if (currMoney == currPrice){
                foodCount++;
                pocketStack.pop();
                priceQueue.poll();
            } else if (currMoney > currPrice) {
                change = currMoney - currPrice;
                pocketStack.pop();
                pocketStack.push(pocketStack.pop() + change);
                priceQueue.poll();
                foodCount++;
            } else if(currMoney < currPrice){
                pocketStack.pop();
                priceQueue.poll();
            }
        }

        if (foodCount == 0){
            System.out.println("Henry remained hungry. He will try next weekend again.");
        } else if(foodCount >= 4) {
            System.out.printf("Gluttony of the day! Henry ate %d foods.", foodCount);
        } else if (foodCount == 1){
            System.out.println("Henry ate: 1 food.");
        } else {
            System.out.printf("Henry ate: %d foods.", foodCount);
        }
    }
}
