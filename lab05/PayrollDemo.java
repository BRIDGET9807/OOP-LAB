/**
 * Exercise 3: adding Intern to the employee hierarchy.
 * The payroll loop is untouched - new subclasses just override pay().
 */
abstract class Staff {
    protected final String name;
    Staff(String name) { this.name = name; }
    abstract double monthlyPay();
}
class FullTime extends Staff {
    private final double salary;
    FullTime(String n, double salary) { super(n); this.salary = salary; }
    double monthlyPay() { return salary; }
}
class Manager extends FullTime {
    private final double bonus;
    Manager(String n, double salary, double bonus) { super(n, salary); this.bonus = bonus; }
    @Override double monthlyPay() { return super.monthlyPay() + bonus; }
}
class Intern extends Staff {
    private final double stipend;
    Intern(String n, double stipend) { super(n); this.stipend = stipend; }
    double monthlyPay() { return stipend; }
}

public class PayrollDemo {
    public static void main(String[] args) {
        Staff[] team = {
            new FullTime("Kudzai", 1500),
            new Manager("Rudo", 2500, 500),
            new Intern("Tino", 300)
        };
        double total = 0;
        for (Staff s : team) {           // payroll loop never changes
            total += s.monthlyPay();
            System.out.println(s.name + ": " + s.monthlyPay());
        }
        System.out.println("Total payroll: " + total);
    }
}
