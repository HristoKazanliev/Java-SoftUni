import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<Integer, BankAccount> bankAccounts = new HashMap<>();

        String input = scanner.nextLine();
        while (!"End".equals(input)) {
            String[] tokens = input.split("\\s+");
            String command = tokens[0];

            switch (command) {
                case "Create":
                    BankAccount bankAccount = new BankAccount();
                    bankAccounts.putIfAbsent(bankAccount.getId(), bankAccount);
                    System.out.printf("Account ID%d created%n", bankAccount.getId());
                    break;
                case "Deposit":
                    int accountId = Integer.parseInt(tokens[1]);
                    double amount = Double.parseDouble(tokens[2]);

                    if (bankAccounts.containsKey(accountId)) {
                        bankAccounts.get(accountId).deposit(amount);
                        DecimalFormat format = new DecimalFormat("##,####");
                        String formatted = format.format(amount);
                        System.out.printf("Deposited %s to ID%d%n", formatted, accountId);
                    } else {
                        System.out.println("Account does not exist");
                    }
                    break;
                case "SetInterest":
                    double interest = Double.parseDouble(tokens[1]);
                    BankAccount.setInterestRate(interest);
                    break;
                case "GetInterest":
                    accountId = Integer.parseInt(tokens[1]);
                    int years = Integer.parseInt(tokens[2]);

                    if (bankAccounts.containsKey(accountId)) {
                       double interestGet = bankAccounts.get(accountId).getInterest(years);
                        System.out.printf("%.2f%n", interestGet);
                    } else {
                        System.out.println("Account does not exist");
                    }

                    break;
            }

            input = scanner.nextLine();
        }
    }
}