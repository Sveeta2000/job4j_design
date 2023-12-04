package ru.job4j.ood.lsp.parking.model;

import java.util.Objects;

public abstract class Auto {
    protected int size;
    protected String number;

    public int getSize() {
        return size;
    }

    public String getNumber() {
        return number;
    }

    public int hashCode() {
        return Objects.hash(number);
    }

    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Auto auto = (Auto) o;
        return Objects.equals(number, auto.number);
    }
}
