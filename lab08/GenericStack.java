import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

/** Exercise 3: Stack<T> backed by an ArrayList<T>. */
public class GenericStack<T> {
    private final List<T> items = new ArrayList<>();

    public void push(T item) { items.add(item); }

    public T pop() {
        if (isEmpty()) throw new NoSuchElementException("stack is empty");
        return items.remove(items.size() - 1);
    }

    public T peek() {
        if (isEmpty()) throw new NoSuchElementException("stack is empty");
        return items.get(items.size() - 1);
    }

    public boolean isEmpty() { return items.isEmpty(); }

    public static void main(String[] args) {
        GenericStack<String> s = new GenericStack<>();
        s.push("a"); s.push("b"); s.push("c");
        System.out.println("peek: " + s.peek());
        while (!s.isEmpty()) System.out.print(s.pop() + " ");
        System.out.println();
    }
}

