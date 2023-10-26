package ru.job4j.interview.kyu6;

import java.util.HashMap;
import java.util.Map;

public class StockList {
    public static String stockSummary(String[] listOfArt, String[] listOf1stLetter) {
        if (listOfArt == null || listOf1stLetter == null
             || listOfArt.length == 0 || listOf1stLetter.length == 0) {
            return "";
        }
        Map<String, Integer> stock = new HashMap<>();
        for (String code : listOf1stLetter) {
            stock.put(code, 0);
        }
        for (String book : listOfArt) {
            String code = book.substring(0, 1);
            if (stock.containsKey(code)) {
                int count = Integer.parseInt(book.split(" ")[1]);
                stock.put(book.substring(0, 1), stock.get(code) + count);
            }
        }
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<String, Integer> entry : stock.entrySet()) {
            sb.append("(").append(entry.getKey()).append(" : ").append(entry.getValue()).append(") - ");
        }
        return sb.delete(sb.length() - 3, sb.length()).toString();
    }
}
