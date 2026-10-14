import java.util.*;

/** Exercise 4: Comparable (by name) plus a Comparator (by marks). */
class Student implements Comparable<Student> {
    final String name;
    final int marks;
    Student(String name, int marks) { this.name = name; this.marks = marks; }

    @Override public int compareTo(Student o) { return name.compareTo(o.name); }
    @Override public String toString() { return name + "(" + marks + ")"; }
}

public class StudentSortDemo {
    public static void main(String[] args) {
        List<Student> list = new ArrayList<>(List.of(
            new Student("Tariro", 78), new Student("Anesu", 91), new Student("Moyo", 64)));

        Collections.sort(list);                                   // natural order: name
        System.out.println("By name : " + list);

        list.sort(Comparator.comparingInt((Student s) -> s.marks).reversed());   // by marks, high first
        System.out.println("By marks: " + list);
    }
}
