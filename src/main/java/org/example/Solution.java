package org.example;

import java.util.Arrays;

public class Solution {
    public int maxProfit(int[] prices) {
        boolean ableToBuy = true; // false == able to sell


        return dfs(prices, 0, true, 0);
    }
    private int dfs(int[] prices, int index, boolean ableToBuy, int total){
        if(index >= prices.length) return total;
        int result = 0;
        for (int i = index; i < prices.length; i++) {
            if(ableToBuy){
                result = Math.max(dfs(prices, index + 1, false, total - prices[index]), dfs(prices, index + 1, ableToBuy, total));
            }
            if(!ableToBuy){
                result = Math.max(dfs(prices, index + 2, true, total + prices[index]), dfs(prices, index + 1, false, total));
            }
        }

        return result;
    }

}
