package ru.job4j.interview.kyu6;

public class StocksProfit {
    public int maxProfit(int[] prices) {
        int maxProfit = 0;
        int minPrice = prices[0];
        for (int i = 1; i < prices.length; i++) {
            int today = prices[i];
            if (today < minPrice) {
                minPrice = today;
            } else if (today - minPrice > maxProfit) {
                maxProfit = today - minPrice;
            }
        }
        return maxProfit;
    }
}
