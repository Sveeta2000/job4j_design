package ru.job4j.ood.lsp.parking.model;

public class Truck extends Auto {
    public Truck(int size, String number) {
        this.size = size;
        this.number = number;
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object o) {
        return super.equals(o);
    }
}
