package ru.job4j.ood.ocp.violationexamples.area;

public class Square {
    int height;

    public Square(int height) {
        this.height = height;
    }

    public int area() {
        return height * height;
    }
}
