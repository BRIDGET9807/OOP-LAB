package lab03;
public class StudentRecord {
    private String name;
    private int marks;

    public StudentRecord(String name, int marks) {
        setName(name);
        setMarks(marks);
    }

    public String getName() { return name; }
    public void setName(String name) {
        if (name == null || name.isBlank()) throw new IllegalArgumentException("Name required");
        this.name = name;
    }

    public int getMarks() { return marks; }
    public void setMarks(int marks) {
        if (marks < 0 || marks > 100) throw new IllegalArgumentException("Marks must be 0-100");
        this.marks = marks;
    }

    // Grade is derived from marks, so it is never stored (can't get out of sync)
    public char getGrade() {
        if (marks >= 70) return 'A';
        if (marks >= 60) return 'B';
        if (marks >= 50) return 'C';
        return 'F';
    }

    public static void main(String[] args) {
        StudentRecord s = new StudentRecord("Tariro", 78);
        System.out.println(s.getName() + " -> " + s.getMarks() + " grade " + s.getGrade());
        try {
            s.setMarks(150);
        } catch (IllegalArgumentException e) {
            System.out.println("Rejected: " + e.getMessage());
        }
        s.setMarks(45);
        System.out.println("After update: grade " + s.getGrade());
    }
}

    

