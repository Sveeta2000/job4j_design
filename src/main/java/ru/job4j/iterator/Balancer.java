package ru.job4j.iterator;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Balancer {
    public static void split(List<ArrayList<Integer>> nodes, Iterator<Integer> source) {
        int listIndex = 0;
        while (source.hasNext()) {
            if (listIndex == nodes.size()) {
                listIndex = 0;
            }
            nodes.get(listIndex++).add(source.next());
        }
    }
}
