/**
 * Exercise 4: methods are polymorphic, fields are NOT.
 * Output:  method -> Child, field -> Parent
 * Reason: the JVM picks the overridden METHOD from the real object at run time
 * (dynamic dispatch). Fields are resolved at compile time from the reference TYPE.
 */
class Parent {
    String label = "Parent";
    String who() { return "Parent"; }
}
class Child extends Parent {
    String label = "Child";
    @Override String who() { return "Child"; }
}

public class FieldVsMethod {
    public static void main(String[] args) {
        Parent p = new Child();
        System.out.println("method -> " + p.who());
        System.out.println("field  -> " + p.label);
        System.out.println("field via cast -> " + ((Child) p).label);
    }
}
