package org.example;

import java.util.Arrays;

public class Solution {
    public int maxProfit(int[] prices) {
        boolean ableToBuy = true; // false == able to sell
        int[][] memo = new int[prices.length][2];
        int[] maxResult = {0};
        dfs(prices, 0, true, 0, memo, maxResult);
        return maxResult[0];
    }

    private int dfs(int[] prices, int index, boolean ableToBuy, int total, int[][] memo, int[] maxResult) {
        if (index >= prices.length) {
            maxResult[0] = Math.max(maxResult[0], total);
            return total;
        }
        int result = 0;
        if (ableToBuy) {
            int buy = dfs(prices, index + 1, false, total - prices[index], memo, maxResult);
            int skip = dfs(prices, index + 1, true, total, memo, maxResult);
            result = Math.max(buy, skip);
        }
        if (!ableToBuy) {
            int sell = dfs(prices, index + 2, true, total + prices[index], memo, maxResult);
            int skip = dfs(prices, index + 1, false, total, memo, maxResult);
            result = Math.max(sell, skip);
        }

        System.out.println(result);
        return result;
    }
}
