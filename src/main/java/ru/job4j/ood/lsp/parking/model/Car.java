package ru.job4j.ood.lsp.parking.model;

public class Car extends Auto {
    private static final int CAR_SIZE = 1;

    public Car(String number) {
        this.size = CAR_SIZE;
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
