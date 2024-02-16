public class BankAccount {
    private static final double DEFAULT_INTEREST_RATE = 0.02;
    private static int bankAccountCount = 1;
    private static double bankInterestRate = DEFAULT_INTEREST_RATE;
    private int id;
    private double balance;

    public BankAccount() {
        this.id = bankAccountCount++;
    }

    public static void setInterestRate(double interestRate) {
        BankAccount.bankInterestRate = interestRate;
    }
    public void deposit(double amount) {
        this.balance += amount;
    }
    public double getInterest(int years) {
        return this.balance * years * BankAccount.bankInterestRate;
    }

    public int getId() {
        return this.id;
    }
}
