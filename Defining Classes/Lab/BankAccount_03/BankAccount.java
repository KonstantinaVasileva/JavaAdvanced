package Advanced.DefiningClasses.Lab.BankAccount_03;

public class BankAccount {
    private final static double DEFAULT_INTEREST_RATE = 0.02;
    private static double interestRate = DEFAULT_INTEREST_RATE;
    private static int bankAccountCount = 1;
    private int id;
    private double balance;

    public static void setInterestRate(double interestRate) {
        BankAccount.interestRate = interestRate;
    }

    public double getInterest(int year) {
        return BankAccount.interestRate * year * this.balance;
    }

    public void deposit(double amount) {
        this.balance += amount;
    }
    public BankAccount(){
        this.id = bankAccountCount++;
    }

    public int getId() {
        return id;
    }
}
