package account;

public class Account {

    private double balance;

    public Account(double balance) {
        this.balance = balance;
    }

    public boolean withdraw(double amount) {
        if (amount > balance) {
            return false;
        }
        balance -= amount;
        return true;
    }

    public void deposit(double amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("Amount for deposit cannot be negative or zero.");
        }
        balance += amount;
    }

    public double getBalance() {
        return balance;
    }

    @Override
    public String toString() {
        return String.format("balance = %.2f", balance);
    }

    public enum Type {
        CREDIT, SAVING
    }
}
