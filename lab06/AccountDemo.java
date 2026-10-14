/** Exercise 3: abstract Account with concrete deposit() and abstract monthlyFee(). */
abstract class Account {
    protected double balance;

    void deposit(double amount) {
        if (amount <= 0) throw new IllegalArgumentException("Deposit must be positive");
        balance += amount;
    }

    abstract double monthlyFee();

    void applyFee() { balance -= monthlyFee(); }
    double getBalance() { return balance; }
}

class SavingsAccount extends Account {
    double monthlyFee() { return 0; }          // free
}
class CurrentAccount extends Account {
    double monthlyFee() { return 5.0; }
}

public class AccountDemo {
    public static void main(String[] args) {
        Account[] accounts = { new SavingsAccount(), new CurrentAccount() };
        for (Account a : accounts) {
            a.deposit(100);
            a.applyFee();
            System.out.println(a.getClass().getSimpleName() + " balance: " + a.getBalance());
        }
    }
}

