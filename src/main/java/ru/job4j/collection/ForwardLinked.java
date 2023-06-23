package ru.job4j.collection;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Objects;

public class ForwardLinked<T> implements Iterable<T> {

    private int size = 0;
    private int modCount = 0;
    private Node<T> head;

    public void add(T value) {
        Node<T> newNode = new Node<>(value, null);
        if (head == null) {
            head = newNode;
        } else {
            Node<T> last = head;
            while (last.next != null) {
                last = last.next;
            }
            last.next = newNode;
        }
        size++;
        modCount++;
    }

    public T get(int index) {
        Objects.checkIndex(index, size);
        Node<T> value = head;
        for (int i = 0; i < index; i++) {
            value = value.next;
        }
        return value.item;
    }

    public T deleteFirst() {
        if (head == null) {
            throw new NoSuchElementException("This list is empty");
        }
        Node<T> del = head;
        T result = head.item;
        head = del.next;
        del.next = null;
        del.item = null;
        size--;
        modCount++;
        return result;
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<>() {

            private final int expectedModCount = modCount;

            private Node<T> pointer = head;

            @Override
            public boolean hasNext() {
                if (expectedModCount != modCount) {
                    throw new ConcurrentModificationException("Collection has been modified during the iteration");
                }
                return pointer != null;
            }

            @Override
            public T next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                Node<T> rsl = pointer;
                pointer = pointer.next;
                return rsl.item;
            }
        };
    }

    private static class Node<T> {
        private T item;
        private Node<T> next;

        Node(T element, Node<T> next) {
            this.item = element;
            this.next = next;
        }
    }
}
