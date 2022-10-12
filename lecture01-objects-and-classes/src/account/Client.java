package account;

public class Client {

    private String name;
    private Account savingAccount;
    private Account creditAccount;

    public Client(String name, double initialAmountSavingAccount, double initialAmountCreditAccount) {
        this.name = name;
        this.savingAccount = new Account(initialAmountSavingAccount);
        this.creditAccount = new Account(initialAmountCreditAccount);
    }

    public double getBalanceCredit() {
        return this.creditAccount.getBalance();
    }

    public boolean withdrawCredit(double creditAmount) {
        return this.creditAccount.withdraw(creditAmount);
    }

    public void depositCredit(double creditAmount) {
        this.creditAccount.deposit(creditAmount);
    }

    public double getBalanceSavings() {
        return this.savingAccount.getBalance();
    }

    public boolean withdrawSavings(double savingsAmount) {
        return this.savingAccount.withdraw(savingsAmount);
    }

    public void depositSavings(double savingsAmount) {
        this.savingAccount.deposit(savingsAmount);
    }

    public boolean transfer(Account fromAccount, Account toAccount, double amount) {
        if (amount > 0 && fromAccount.getBalance() >= amount) {
            fromAccount.withdraw(amount);
            toAccount.deposit(amount);
            return true;
        }
        return false;
    }

    public Account getSavingAccount() {
        return savingAccount;
    }

    public Account getCreditAccount() {
        return creditAccount;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Client{" +
                "name='" + name + '\'' +
                ", saving account " + savingAccount +
                ", credit account " + creditAccount +
                '}';
    }
}
