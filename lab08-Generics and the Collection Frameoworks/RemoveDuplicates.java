import java.util.*;

/** Exercise 2: remove duplicates with a Set. */
public class RemoveDuplicates {
    public static void main(String[] args) {
        List<String> names = List.of("Ada", "Ben", "Ada", "Cara", "Ben", "Dan");
        Set<String> unique = new LinkedHashSet<>(names);   // keeps first-seen order
        System.out.println("Original: " + names);
        System.out.println("Unique:   " + unique);
    }
}
