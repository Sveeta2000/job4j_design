package ru.job4j.ood.isp.violation.animal;

public class Dog implements Animal {
    @Override
    public void eat() {
        System.out.println("A dog can eat");
    }

    @Override
    public void sleep() {
        System.out.println("A dog can sleep");
    }

    @Override
    public void fly() {
        throw new UnsupportedOperationException("Dogs can't fly");
    }
}
