package by.starovoytov;

import java.util.NoSuchElementException;

public class CustomLinkedList<T> {

    private static class Node<T> {
        T item;
        Node<T> next;
        Node<T> prev;

        Node(Node<T> prev, T element, Node<T> next) {
            this.item = element;
            this.next = next;
            this.prev = prev;
        }
    }

    private int size = 0;
    private Node<T> head;
    private Node<T> tail;

    public CustomLinkedList() {}

    public int size() {
        return size;
    }

    public void addFirst(T el) {
        final Node<T> h = head;
        final Node<T> newNode = new Node<>(null, el, h);
        head = newNode;
        if (h == null) {
            tail = newNode;
        } else {
            h.prev = newNode;
        }
        size++;
    }

    public void addLast(T el) {
        final Node<T> t = tail;
        final Node<T> newNode = new Node<>(t, el, null);
        tail = newNode;
        if (t == null) {
            head = newNode;
        } else {
            t.next = newNode;
        }
        size++;
    }
    public void add(int index, T el) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }

        if (index == size) {
            addLast(el);
        } else {
            Node<T> succ = getNode(index);
            Node<T> pred = succ.prev;
            final Node<T> newNode = new Node<>(pred, el, succ);
            succ.prev = newNode;
            if (pred == null) {
                head = newNode;
            } else {
                pred.next = newNode;
            }
            size++;
        }
    }

    public T getFirst() {
        if (head == null) throw new NoSuchElementException();
        return head.item;
    }

    public T getLast() {
        if (tail == null) throw new NoSuchElementException();
        return tail.item;
    }

    public T get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
        return getNode(index).item;
    }

    public T removeFirst() {
        if (head == null) throw new NoSuchElementException();
        return unlink(head);
    }

    public T removeLast() {
        if (tail == null) throw new NoSuchElementException();
        return unlink(tail);
    }

    public T remove(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
        return unlink(getNode(index));
    }
    
    private T unlink(Node<T> x) {
        final T element = x.item;
        final Node<T> next = x.next;
        final Node<T> prev = x.prev;

        if (prev == null) {
            head = next;
        } else {
            prev.next = next;
            x.prev = null;
        }

        if (next == null) {
            tail = prev;
        } else {
            next.prev = prev;
            x.next = null;
        }

        x.item = null;
        size--;
        return element;
    }

    private Node<T> getNode(int index) {
        if (index < (size >> 1)) {
            Node<T> x = head;
            for (int i = 0; i < index; i++) {
                x = x.next;
            }
            return x;
        } else {
            Node<T> x = tail;
            for (int i = size - 1; i > index; i--) {
                x = x.prev;
            }
            return x;
        }
    }
}