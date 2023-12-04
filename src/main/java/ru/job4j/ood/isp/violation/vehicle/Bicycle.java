package ru.job4j.ood.isp.violation.vehicle;

public class Bicycle implements Vehicle {
    @Override
    public void speedUp() {
        System.out.println("Speeding up");
    }

    @Override
    public void slowDown() {
        System.out.println("Slowing down");
    }

    @Override
    public void refuel() {
        throw new UnsupportedOperationException("Simple bicycles don't need fuel");
    }
}
