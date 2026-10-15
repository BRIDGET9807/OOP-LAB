public abstract class Account{
    protected String accountNumber;
    protected double balance;

    public Account(String accountNumber, double balance){
        this.accountNumber = accountNumber;
        this.balance = balance;
    }
    public void deposit(double amount){
        if (amount <= 0){
            System.out.println("Deposit failed! Amount must be more than $0 ");
            return; 
        }
        balance += amount;
        System.out.printf("Deposited %.2f. New balance: %.2f%n", amount, balance);
    }
public double getBalance(){
        return balance;
    }
    public String getAccountNumber(){
        return accountNumber;
    }
    public abstract void withdraw(double amount);
    public abstract void endOfMonth();
}