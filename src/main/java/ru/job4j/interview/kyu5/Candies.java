package ru.job4j.interview.kyu5;

public class Candies {
    public int distributeCandies(int n, int limit) {
        if (n > 3 * limit) {
            return 0;
        }
        long ans = comb2(n + 2);
        if (n > limit) {
            ans -= 3 * comb2(n - limit + 1);
        }
        if (n - 2 >= 2 * limit) {
            ans += 3 * comb2(n - 2 * limit);
        }
        return (int) ans;
    }

    private long comb2(int n) {
        return (long) n * (n - 1) / 2;
    }

    /**
     * The method counts how many different ways we can distribute n candies among 3 children with :
     * @param n - the number of candies
     * @param limit - the maximum amount of candies per child
     * @return the total number of ways to distribute n candies among 3 children such that no child gets more than limit candies.
     */
    public int distributeCandies2(int n, int limit) {
        return dynamicDistribution(n, 3, limit);
    }

    /**
     * declare recursive function that takes, candies, children and limit
     * 1. check for recursion base case and check if candies are 0 then return 1 else 0.
     * 2. take range as minimum between candies and limit and increment by 1 (range is the maximum addend);
     * 3. loop through range and on each range call recursive function with candies - current range and decrement children by 1, limit not changed
     * @return count of combinations
     */
    public int dynamicDistribution(int candies, int children, int limit) {
        if (children == 0) {
            return candies == 0 ? 1 : 0;
        }
        int count = 0;
        int range = Math.min(candies, limit) + 1;
        for (int i = 0; i < range; i++) {
            count += dynamicDistribution(candies - i, children - 1, limit);
        }
        return count;
    }
}
