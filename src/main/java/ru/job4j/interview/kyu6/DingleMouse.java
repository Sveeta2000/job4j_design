package ru.job4j.interview.kyu6;

import java.util.ArrayList;
import java.util.List;

public class DingleMouse {
    private String name;
    private int age;
    private char sex;

    private final List<String> order = new ArrayList<>();

    public DingleMouse() {
    }

    public DingleMouse setAge(int age) {
        this.age = age;
        if (!order.contains("age")) {
            order.add("age");
        }
        return this;
    }

    public DingleMouse setSex(char sex) {
        this.sex = sex;
        if (!order.contains("sex")) {
            order.add("sex");
        }
        return this;
    }

    public DingleMouse setName(String name) {
        this.name = name;
        if (!order.contains("name")) {
            order.add("name");
        }
        return this;
    }

    public String hello() {
        StringBuilder result = new StringBuilder("Hello. ");
        for (String item : order) {
            switch (item) {
                case "name" -> result.append("My name is ").append(name).append(". ");
                case "age" -> result.append("I am ").append(age).append(". ");
                case "sex" -> result.append("I am ").append(sex == 'M' ? "male" : "female").append(". ");
                default -> { }
            }
        }
        return result.toString().trim();
    }
}
