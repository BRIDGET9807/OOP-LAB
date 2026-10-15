import java.util.ArrayList;
import java.util.List;

public class BankDemo  {

    public static void main (String[] args ){

        List<Account> accounts = new ArrayList<>();
        accounts.add(new SavingsAccount("SAV-001", 1000.00, 200.00));
        accounts.add(new CurrentAccount( "CUR-001", 500.00,  300.00));
        accounts.add(new SavingsAccount("SAV-002", 150.00, 100.00));
        accounts.add(new CurrentAccount( "CUR-002", 100.00,  300.00));
    
        
        System.out.println("===== Withdrawal round =====");
        withdrawFrom(accounts.get(2), 80.00);
        withdrawFrom(accounts.get(3), 250.00);
        withdrawFrom(accounts.get(0), 100.00);
        withdrawFrom(accounts.get(1), 100.00);

        System.out.println("......End of Month Processing......");
        for (Account acc: accounts){
            System.out.print(acc.getAccountNumber() + ":");
            acc.endOfMonth();
        }
       System.out.println("......Final Balances....");
       for(Account acc: accounts){
        System.out.printf("%s-> %.2f", acc.getAccountNumber(), acc.getBalance());

       }
    }
    private static void withdrawFrom(Account acc, double amount){
        System.out.print(acc.getAccountNumber() + ":");
        acc.withdraw(amount);
    }
}