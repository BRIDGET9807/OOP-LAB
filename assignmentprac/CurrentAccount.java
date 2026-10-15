public class CurrentAccount extends Account {
    private double overdraftLimit;
    private static final double MAINTENANCE_FEE = 10.00;

    public CurrentAccount ( String accountNumber, double balance , double overdraftLimit){
        super(accountNumber, balance);
        this.overdraftLimit = overdraftLimit;

    }
    @Override 
    public void withdraw(double amount){
        if (amount<= 0) {
            System.out.println("Withdrawal failed! Ammount must be greater than $0");
            return;
            
        }
        if (balance - amount < -overdraftLimit){
            System.out.printf("Cannot withdraw %.2f. Overdraft limit is %.2f and Current balance: %.2f.%n", amount,overdraftLimit, balance);
            return;
        }
        balance -= amount;
        System.out.printf("Withdrew %.2f from current account. New balance: %.2f%n", amount, balance);
        
    }
    @Override
    public void endOfMonth(){
        balance-= MAINTENANCE_FEE;
        System.out.printf("Monthly maintenance fee charged: -%.2f. New balance: %.2f%n", MAINTENANCE_FEE, balance);

    }
}

