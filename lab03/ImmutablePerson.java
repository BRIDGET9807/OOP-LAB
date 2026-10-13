/**
 * Exercise 4: an immutable class.
 *  - final class     : nobody can subclass it and add mutable behaviour.
 *  - private final   : fields are assigned once, in the constructor.
 *  - no setters      : state can never change after construction.
 *  - "withX" methods : return a NEW object instead of modifying this one.
 */
package lab03;  
public final class ImmutablePerson {
    private final String name;
    private final int age;

    public ImmutablePerson(String name, int age) {
        if (age < 0) throw new IllegalArgumentException("age < 0");
        this.name = name;
        this.age = age;
    }

    public String getName() { return name; }
    public int getAge()     { return age; }

    public ImmutablePerson withAge(int newAge) { return new ImmutablePerson(name, newAge); }

    @Override public String toString() { return name + " (" + age + ")"; }

    public static void main(String[] args) {
        ImmutablePerson p = new ImmutablePerson("Bridget", 20);
        ImmutablePerson older = p.withAge(21);
        System.out.println(p + " -> " + older);   // original unchanged
    }
}
/*
The design of this class is immutable beacause: 

final class: Nobody can extend ImmutablePerson. Without this, someone could write a subclass that adds mutable fields or overrides methods to change behaviour, which would break the immutability guarantee.

private final fields: private means outside code can’t touch the fields directly. final means each field can be assigned exactly once, in the constructor, and the compiler enforces it. Together they stop the state changing after construction.

Validation in the constructor: The age < 0 check runs before anything is assigned, so an invalid object can never exist. Since the object can’t change later, it also can’t become invalid later.

No setters: There are only getters (getName, getAge). With no method that writes to the fields, there’s no way to modify state.
withAge (“wither”) method: Instead of changing the age, it returns a new object with the new age and the same name. This is how you “modify” immutable objects.
toString: Just a readable representation for printing. It only reads the fields, so it doesn’t affect immutability. */
