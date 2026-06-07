import java.util.Objects;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class LinkedList<T extends Comparable<T>> implements Iterable<T> {

    private class Node {

        private T value;

        private Node next;

        public void setNext(Node next) {
            this.next = next;
        }

        public Node getNext() {
            return next;
        }

        public void setValue(T value) {
            this.value = value;
        }

        public T getValue() {
            return value;
        }
    }

    private class LinkedListIterator implements Iterator<T> {

        private Node current = head;

        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public T next() {
            if (!hasNext()) {
                throw new NoSuchElementException("No more elements");
            }

            T value = current.getValue();
            current = current.getNext();

            return value;
        }
    }

    Node head;
    int size;

    public LinkedList() {
        head = null;
        size = 0;
    }

    public void addFirst(T e) {
        Node node = new Node();
        node.setValue(e);

        node.setNext(head);
        head = node;
        size++;
    }

    public void addLast(T e) {
        Node node = new Node();
        node.setValue(e);
        node.setNext(null);

        if (head == null) {
            head = node;
            size++;
            return;
        }

        Node current = head;

        while (current.getNext() != null) {
            current = current.getNext();
        }
        current.setNext(node);

    }

    public T removeFirst() {
        if (head == null) {
            throw new RuntimeException("List is empty");
        }

        T removedValue = head.getValue();

        head = head.getNext();
        size--;
        return removedValue;
    }

    public T removeLast() {
        if (head == null) {
            throw new RuntimeException("List is empty");
        }

        if (head.getNext() == null) {
            T removedValue = head.getValue();
            head = null;
            size--;
            return removedValue;
        }

        Node previous = head;
        Node current = head.getNext();

        while (current.getNext() != null) {
            previous = current;
            current = current.getNext();
        }

        T removedValue = current.getValue();

        previous.setNext(null);
        return removedValue;
    }

    public T get(int index) {

        if (index < 0) {
            throw new RuntimeException("Index cannot be negative");
        }

        Node current = head;
        int currentIndex = 0;

        while (current != null) {
            if (currentIndex == index) {
                return current.getValue();
            }
            current = current.getNext();
            currentIndex++;
        }
        throw new RuntimeException("Index out of bounds");
    }

    public void set(int index, T v) {
        if (index < 0) {
            throw new RuntimeException("Index cannot be negative");
        }

        Node current = head;
        int currentIndex = 0;

        while (current != null) {
            if (index == currentIndex) {
                current.setValue(v);
                return;
            }
            current = current.getNext();
            currentIndex++;
        }

        throw new RuntimeException("Index out of bounds");
    }

    public T remove(int index) {

        if (index < 0) {
            throw new RuntimeException("Index cannot be negative");
        }

        if (head == null) {
            throw new RuntimeException("List is empty");
        }

        if (index == 0) {
            T removedValue = head.getValue();
            head = head.getNext();
            return removedValue;
        }

        Node current = head;
        Node previous = head;
        int currentIndex = 0;

        while (current.getNext() != null) {
            if (currentIndex == index) {
                T removedValue = current.getValue();
                previous.setNext(current.getNext());
                return removedValue;
            }
            previous = current;
            current = current.getNext();
            currentIndex++;
        }
        size--;

        throw new RuntimeException("Index out of bounds");

    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        if (size == 0)
            return true;
        return false;
    }

    public void clear() {
        head = null;
        size = 0;
    }

    @Override
    public Iterator<T> iterator() {
        return new LinkedListIterator();
    }

    public boolean contains(T value) {
        Node current = head;

        while (current != null) {
            if (Objects.equals(current.getValue(), value)) {
                return true;
            }

            current = current.getNext();
        }

        return false;
    }

}