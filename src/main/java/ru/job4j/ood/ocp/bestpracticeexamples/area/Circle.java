package ru.job4j.ood.ocp.bestpracticeexamples.area;

public class Circle implements Shape {
    int r;

    public Circle(int r) {
        this.r = r;
    }

    @Override
    public int area() {
        return (int) (Math.PI * r * r);
    }
}
