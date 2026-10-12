package lab02;
class Employee {
    private static int nextId = 1;
    private final int employeeId;
    private String name;
    private String department;
    private double salary;

    Employee(String name, String department, double salary) {
        this.employeeId = nextId++;
        this.name = name;
        this.department = department;
        this.salary = salary;
    }

    Employee(String name, String department) { this(name, department, 0.0); }

    Employee(String name) { this(name, "Unassigned"); }

    // copy constructor: new id, same details
    Employee(Employee other) { this(other.name, other.department, other.salary); }

    @Override public String toString() {
        return "#" + employeeId + " " + name + " | " + department + " | " + salary;
    }
}

public class EmployeeDemo {
    public static void main(String[] args) {
        Employee e1 = new Employee("Kudzai", "IT", 1500);
        Employee e2 = new Employee("Rudo", "HR");
        Employee e3 = new Employee("Tendai");
        Employee e4 = new Employee(e1);
        System.out.println(e1);
        System.out.println(e2);
        System.out.println(e3);
        System.out.println(e4);
    }
}
