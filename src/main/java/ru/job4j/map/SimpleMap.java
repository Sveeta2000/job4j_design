package ru.job4j.map;

import java.util.*;

public class SimpleMap<K, V> implements Map<K, V> {
    private static final float LOAD_FACTOR = 0.75f;

    private int capacity = 8;

    private int count = 0;

    private int modCount = 0;

    private MapEntry<K, V>[] table = new MapEntry[capacity];

    @Override
    public boolean put(K key, V value) {
        if (count >= capacity * LOAD_FACTOR) {
            expand();
        }
        boolean success = false;
        int index = getIndex(key);
        if (table[index] == null) {
            table[index] = new MapEntry<>(key, value);
            success = true;
            count++;
            modCount++;
        }
        return success;
    }

    private int hash(int hashCode) {
        return (hashCode == 0) ? 0 : (hashCode) ^ (hashCode >>> 16);
    }

    private int indexFor(int hash) {
        return hash & (capacity - 1);
    }

    private void expand() {
        capacity += capacity;
        MapEntry<K, V>[] newTable = new MapEntry[capacity];
        for (MapEntry<K, V> entry : table) {
            if (entry != null) {
                int index = getIndex(entry.key);
                newTable[index] = entry;
            }
        }
        table = newTable;
    }

    @Override
    public V get(K key) {
        V val = null;
        if (checkElement(key)) {
            int index = getIndex(key);
            val = table[index].value;
        }
        return val;
    }

    private int getIndex(K key) {
        return indexFor(hash(Objects.hashCode(key)));
    }

    @Override
    public boolean remove(K key) {
        boolean success = false;
        if (checkElement(key)) {
            int index = getIndex(key);
            table[index] = null;
            success = true;
            count--;
            modCount++;
        }
        return success;
    }

    private boolean checkElement(K key) {
        int index = getIndex(key);
        return Objects.nonNull(table[index])
                && Objects.hashCode(key) == Objects.hashCode(table[index].key)
                && Objects.equals(table[index].key, key);
    }

    @Override
    public Iterator<K> iterator() {
        return new Iterator<>() {

            private final int expectedModCount = modCount;

            private int index = 0;

            @Override
            public boolean hasNext() {
                if (expectedModCount != modCount) {
                    throw new ConcurrentModificationException("Collection has been modified during the iteration");
                }
                while (index < capacity && table[index] == null) {
                    index++;
                }
                return index < capacity;
            }

            @Override
            public K next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                return table[index++].key;
            }
        };
    }

    private static class MapEntry<K, V> {

        K key;
        V value;

        public MapEntry(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }
}
