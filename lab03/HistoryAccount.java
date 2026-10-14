import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/** Exercise 3: BankAccount with a transaction history (unmodifiable getter). */
public class HistoryAccount {
    private final String owner;
    private double balance;
    private final List<String> history = new ArrayList<>();

    public HistoryAccount(String owner, double opening) {
        this.owner = owner;
        this.balance = opening;
        history.add("OPEN " + opening);
    }

    public void deposit(double amount) {
        if (amount <= 0) throw new IllegalArgumentException("Deposit must be positive");
        balance += amount;
        history.add("DEPOSIT " + amount);
    }

    public boolean withdraw(double amount) {
        if (amount <= 0 || amount > balance) {
            history.add("FAILED WITHDRAW " + amount);
            return false;
        }
        balance -= amount;
        history.add("WITHDRAW " + amount);
        return true;
    }

    public double getBalance() { return balance; }

    // Return a read-only copy so callers cannot alter our internal list
    public List<String> getHistory() {
        return Collections.unmodifiableList(new ArrayList<>(history));
    }

    public static void main(String[] args) {
        HistoryAccount acc = new HistoryAccount("Tendai", 500);
        acc.deposit(250);
        acc.withdraw(100);
        acc.withdraw(5000);
        acc.getHistory().forEach(System.out::println);
        try {
            acc.getHistory().clear();
        } catch (UnsupportedOperationException e) {
            System.out.println("History is read-only (UnsupportedOperationException)");
        }
    }
}

