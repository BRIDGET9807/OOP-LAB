public class SavingsAccount extends Account{
    private double minimumBalance;
    private static final double INTEREST_RATE = 0.02; 

    public SavingsAccount( String accountNumber, double balance, double minimumBalance){
        super(accountNumber, balance);
        this.minimumBalance = minimumBalance;

    }
    @Override
    public void withdraw( double amount){
        if(amount<= 0){
            System.out.println("Withdrawal failed!The amount must be greater thsn $0");
            return;}
    
    if( balance - amount < minimumBalance){
        System.out.printf("Withdrawal of %.2f failed!! The balance cannot fall below minimum balance of %.2f ( current balace:%.2f).%n",amount,minimumBalance ,balance);
    return;}
    balance -= amount;
    System.out.printf("Withdrew %.2f from savings. New balance: %.2f%n", amount, balance);
    }
    @Override
    public void endOfMonth(){
        double interest = balance * INTEREST_RATE;
        balance += interest;
        System.out.printf("Savings interest applied: +%.2f. New balance: %.2f%n", interest, balance);
    }
}