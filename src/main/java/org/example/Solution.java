package org.example;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public int maxProfit(int[] prices) {
        Map<String, Integer> memo = new HashMap<>();

        return dfs(prices, 0, true, memo);
    }

    private int dfs(int[] prices, int index, boolean ableToBuy, Map<String, Integer> memo) {
        if (index >= prices.length) {
            return 0;
        }

        if (memo.containsKey(index + " " + ableToBuy)) {
            return memo.get(index + " " + ableToBuy);
        }

        if (ableToBuy) {
            int buy = dfs(prices, index + 1, false, memo) - prices[index];
            int skip = dfs(prices, index + 1, true, memo);
            memo.put(index + " " + ableToBuy, Math.max(buy, skip));
        }
        if (!ableToBuy) {
            int sell = dfs(prices, index + 2, true, memo) + prices[index];
            int skip = dfs(prices, index + 1, false, memo);
            memo.put(index + " " + ableToBuy, Math.max(sell, skip));
        }

        return memo.get(index + " " + ableToBuy);
    }
}
