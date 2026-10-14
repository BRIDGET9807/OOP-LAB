/** Exercise 2: records give constructor, getters, equals, hashCode, toString. */
record StudentInfo(String name, int age) { }

public class StudentRecordDemo {
    public static void main(String[] args) {
        StudentInfo a = new StudentInfo("Tariro", 20);
        StudentInfo b = new StudentInfo("Tariro", 20);
        System.out.println(a);                          // StudentInfo[name=Tariro, age=20]
        System.out.println("equal? " + a.equals(b));    // true (compared by value)
        System.out.println("same object? " + (a == b)); // false
        System.out.println("name component: " + a.name());
    }
}

