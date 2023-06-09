package ru.job4j.set;

import ru.job4j.collection.SimpleArrayList;

import java.util.Iterator;
import java.util.Objects;

public class SimpleSet<T> implements Set<T> {

    private SimpleArrayList<T> set = new SimpleArrayList<>(0);

    @Override
    public boolean add(T value) {
        boolean hadNoValue = !contains(value);
        if (hadNoValue) {
            set.add(value);
        }
        return hadNoValue;
    }

    @Override
    public boolean contains(T value) {
        boolean rsl = false;
        for (T val : set) {
            if (Objects.equals(val, value)) {
                rsl = true;
                break;
            }
        }
        return rsl;
    }

    @Override
    public Iterator<T> iterator() {
        return set.iterator();
    }
}
