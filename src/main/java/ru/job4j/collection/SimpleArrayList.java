package ru.job4j.collection;

import java.util.*;

public class SimpleArrayList<T> implements SimpleList<T> {
    private T[] container;
    private int size;
    private int modCount;

    public SimpleArrayList(int capacity) {
        container = (T[]) new Object[capacity];
    }

    @Override
    public void add(T value) {
        if (size == container.length) {
            grow();
        }
        container[size++] = value;
        modCount++;
    }

    @Override
    public T set(int index, T newValue) {
        Objects.checkIndex(index, size);
        T el = container[index];
        container[index] = newValue;
        return el;
    }

    @Override
    public T remove(int index) {
        Objects.checkIndex(index, size);
        T el = container[index];
        System.arraycopy(container, index + 1, container, index, size - index - 1);
        container[size - 1] = null;
        size--;
        modCount++;
        return el;
    }

    @Override
    public T get(int index) {
        Objects.checkIndex(index, size);
        return container[index];
    }

    @Override
    public int size() {
        return this.size;
    }

    /**
     * creates a new array twice as big as a previous one
     * and fills it with all the values from the first array
     * then assigns the new array to the container variable
     */
    private void grow() {
        container = Arrays.copyOf(container, (container.length + 1) * 2);
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {

            private final int expectedModCount = modCount;

            private int index = 0;

            @Override
            public boolean hasNext() {
                checkDefined();
                return index < size;
            }

            @Override
            public T next() {
                checkDefined();
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                return container[index++];
            }

            /**
             * checks whether the collection has been changed since the creation of this iterator
             * if so, throws ConcurrentModificationException
             */
            private void checkDefined() {
                if (expectedModCount != modCount) {
                    throw new ConcurrentModificationException("Collection has been modified during the iteration");
                }
            }
        };
    }
}
