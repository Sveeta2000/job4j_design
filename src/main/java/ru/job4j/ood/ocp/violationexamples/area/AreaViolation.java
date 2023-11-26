package ru.job4j.ood.ocp.violationexamples.area;

public class AreaViolation {
    /**
     * Нарушен принцип Open Closed тк при необходимости добавить функционал сравнения
     * площади новой фигуры придется добавлять новый метод и изменять существующий класс.
     * Исправленный вариант находится в папке "best practice example.area".
     */
    public int compareArea(Square a, Square b) {
        return a.area() - b.area();
    }
}
