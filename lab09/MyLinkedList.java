import java.util.Iterator;
import java.util.NoSuchElementException;

/** Exercise 4: LinkedList with a static nested Node and an inner Iterator class. */
public class MyLinkedList<T> implements Iterable<T> {

    // static nested: a Node does not need access to the list instance
    private static class Node<T> {
        T value;
        Node<T> next;
        Node(T value) { this.value = value; }
    }

    private Node<T> head, tail;
    private int size;

    public void add(T value) {
        Node<T> n = new Node<>(value);
        if (head == null) head = tail = n;
        else { tail.next = n; tail = n; }
        size++;
    }

    public int size() { return size; }

    // inner (non-static) class: it reads the list's 'head' field directly
    private class ListIterator implements Iterator<T> {
        private Node<T> current = head;
        public boolean hasNext() { return current != null; }
        public T next() {
            if (current == null) throw new NoSuchElementException();
            T v = current.value;
            current = current.next;
            return v;
        }
    }

    @Override public Iterator<T> iterator() { return new ListIterator(); }

    public static void main(String[] args) {
        MyLinkedList<String> list = new MyLinkedList<>();
        list.add("one"); list.add("two"); list.add("three");
        for (String s : list) System.out.println(s);   // for-each works via Iterable
    }
}
