package ru.job4j.ood.ocp.bestpracticeexamples.area;

public class Square implements Shape {
    int height;

    public Square(int height) {
        this.height = height;
    }

    @Override
    public int area() {
        return height * height;
    }
}
