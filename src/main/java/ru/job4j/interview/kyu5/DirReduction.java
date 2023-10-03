package ru.job4j.interview.kyu5;

import java.util.Stack;

public class DirReduction {
    public static String[] dirReduc(String[] arr) {
        if (arr == null || arr.length == 0) {
            return new String[] {};
        }
        Stack<String> stack = new Stack<>();
        for (String s : arr) {
            stack.push(s);
            if (stack.size() >= 2) {
                String last = stack.pop();
                String prev = stack.peek();
                if (findOpposite(last).equals(prev)) {
                    stack.pop();
                } else {
                    stack.push(last);
                }
            }
        }
        return stack.toArray(new String[0]);
    }

    private static String findOpposite(String str) {
        return switch (str) {
            case "NORTH" -> "SOUTH";
            case "SOUTH" -> "NORTH";
            case "EAST" -> "WEST";
            case "WEST" -> "EAST";
            default -> "";
        };
    }

    public static void main(String[] args) {
        String[] a = new String[] {"a", "b"};
        System.out.println(String.join(" ", a));
    }
}
