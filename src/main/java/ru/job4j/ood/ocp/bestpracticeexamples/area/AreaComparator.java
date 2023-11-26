package ru.job4j.ood.ocp.bestpracticeexamples.area;

public class AreaComparator {
    /**
     * Класс не зависит от имплементаций и может работать с любыми фигурами Shape
     */
    public int compareArea(Shape a, Shape b) {
        return a.area() - b.area();
    }
}
