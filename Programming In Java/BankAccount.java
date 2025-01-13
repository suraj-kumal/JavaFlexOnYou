import Inheritance.customhandle;

public class BankAccount {
    private double balance;
    final private String accountHolder;

    public BankAccount(String accountHolder, double initialBalance) {
        this.accountHolder = accountHolder;
        this.balance = initialBalance;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Rs" + amount + " deposited. New balance: Rs" + balance);
        } else {
            System.out.println("Deposit amount must be positive.");
        }
    }

    public void withdraw(double amount) throws customhandle {
        if (amount <= balance) {
            balance -= amount;
            System.out.println("Rs" + amount + " withdrawn. New balance: Rs" + balance);
        } else {
            throw new customhandle("Insufficient funds for withdrawal! Attempted to withdraw: $"
                    + amount + ", but the current balance is: $" + balance);
        }
    }

    public double getBalance() {
        return balance;
    }

    public String getAccountHolder() {
        return accountHolder;
    }

    public void addInterest(double rate) {
        if (rate > 0) {
            double interest = balance * rate / 100;
            balance += interest;
            System.out.println("Interest added: Rs" + interest + ". New balance: Rs" + balance);
        } else {
            System.out.println("Interest rate must be positive.");
        }
    }

    public static void main(String[] args) {
        BankAccount account = new BankAccount("Suraj Kumal", 500);

        account.deposit(200);
        account.deposit(-50);

        try {
            account.withdraw(100);
            account.withdraw(700);
        } catch (customhandle ex) {
            System.out.println("Caught an error: " + ex.getMessage());
        }

        account.addInterest(5);
        System.out.println("Final balance: Rs" + account.getBalance());
        System.out.println("Name: Suraj Kumal");
        System.out.println("Rollno : 32");
    }
}
