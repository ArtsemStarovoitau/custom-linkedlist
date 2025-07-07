package by.starovoytov;

import java.util.NoSuchElementException;

public class CustomLinkedList<T> {

    private static class Node<T> {
        T item;
        Node<T> next;

        Node(T element, Node<T> next) {
            this.item = element;
            this.next = next;
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
        final Node<T> newNode = new Node<>(el, h);
        head = newNode;
        if (h == null) {
            tail = newNode;
        }
        size++;
    }

    public void addLast(T el) {
        final Node<T> t = tail;
        final Node<T> newNode = new Node<>(el, null);
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
        if (index == 0) {
            addFirst(el);
        } else if (index == size) {
            addLast(el);
        } else {
            Node<T> pred = getNode(index - 1);
            Node<T> newNode = new Node<>(el, pred.next);
            pred.next = newNode;
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
        final T element = head.item;
        final Node<T> next = head.next;
        head.item = null;
        head.next = null;
        head = next;
        if (next == null) {
            tail = null;
        }
        size--;
        return element;
    }

    public T removeLast() {
        if (tail == null) throw new NoSuchElementException();
        final T element = tail.item;
        if (head == tail) {
            head = null;
            tail = null;
        } else {
            Node<T> newTail = getNode(size - 2);
            tail = newTail;
            newTail.next = null;
        }
        size--;
        return element;
    }

    public T remove(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
        if (index == 0) return removeFirst();
        if (index == size - 1) return removeLast();
        Node<T> pred = getNode(index - 1);
        Node<T> toRemove = pred.next;
        T element = toRemove.item;
        pred.next = toRemove.next;
        toRemove.item = null;
        toRemove.next = null;
        size--;
        return element;
    }

    private Node<T> getNode(int index) {
        Node<T> x = head;
        for (int i = 0; i < index; i++) {
            x = x.next;
        }
        return x;
    }
}