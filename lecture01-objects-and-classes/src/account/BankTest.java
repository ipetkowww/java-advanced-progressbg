package account;

public class BankTest {

    public static void main(String[] args) {
        Client bobi = new Client("Bobi", 500, 1000);
        Client marti = new Client("Marti", 1000, 3000);

        printWithdrawInfo(bobi, Account.Type.SAVING, 501);
    }

    public static void printWithdrawInfo(Client client, Account.Type accountType, double withdrawAmount) {
        boolean isSuccessfulWithdraw = isSuccessfulWithdraw(client, accountType, withdrawAmount);

        if (isSuccessfulWithdraw) {
            System.out.printf("%s successfully withdrew $%.2f%n from account: %s%n",
                    client.getName(), withdrawAmount, accountType);
        } else {
            System.out.printf("Cannot withdraw $%.2f from %s account. " +
                            "Account balance = $%.2f and you want to withdraw = $%.2f",
                    withdrawAmount, accountType, accountType, withdrawAmount);
        }
    }

    public static boolean isSuccessfulWithdraw(Client client, Account.Type accountType, double amount) {
        switch (accountType) {
            case CREDIT:
                return client.withdrawCredit(amount);
            case SAVING:
                return client.withdrawSavings(amount);
            default:
                return false;
        }
    }

}
