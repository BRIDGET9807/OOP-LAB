import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/** Exercise 3: equals/hashCode by ISBN so a HashSet rejects duplicates. */
class Book {
    private final String isbn;
    private final String title;

    Book(String isbn, String title) { this.isbn = isbn; this.title = title; }

    @Override public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Book other)) return false;
        return isbn.equals(other.isbn);
    }
    @Override public int hashCode() { return Objects.hash(isbn); }
    @Override public String toString() { return title + " [" + isbn + "]"; }
}

public class BookEqualsDemo {
    public static void main(String[] args) {
        Set<Book> set = new HashSet<>();
        System.out.println(set.add(new Book("111", "Clean Code")));          // true
        System.out.println(set.add(new Book("111", "Clean Code (reprint)"))); // false - duplicate
        System.out.println(set.add(new Book("222", "Effective Java")));       // true
        System.out.println("Set size: " + set.size() + " -> " + set);
    }
}

