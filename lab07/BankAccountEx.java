/**
 * Exercise 4: withdraw throws a checked exception instead of returning false.
 * Trade-offs:
 *  + the caller cannot silently ignore a failure (the compiler forces handling)
 *  + the exception carries details (shortfall) and a message
 *  - more boilerplate (try/catch or throws) for callers
 *  - exceptions are heavier than a boolean for expected, frequent outcomes
 */
public class BankAccountEx {
    private double balance;

    public BankAccountEx(double opening) { this.balance = opening; }

    public void withdraw(double amount) throws InsufficientFundsException {
        if (amount > balance) {
            throw new InsufficientFundsException("Insufficient funds", amount - balance);
        }
        balance -= amount;
    }

    public double getBalance() { return balance; }

    public static void main(String[] args) {
        BankAccountEx acc = new BankAccountEx(100);
        try {
            acc.withdraw(30);
            System.out.println("Balance: " + acc.getBalance());
            acc.withdraw(500);
        } catch (InsufficientFundsException e) {
            System.out.println(e.getMessage() + ", short by " + e.getShortfall());
        }
    }
}

