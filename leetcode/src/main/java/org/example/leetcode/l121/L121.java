package org.example.leetcode.l121;

import java.util.HashMap;
import java.util.Map;

/**
 * @description: 第L121题 - 买卖股票的最佳时机
 * @question: <a href="https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock/">...</a>
 * @answer: 获取最大利润，直接遍历当前数组，然后如果当前数小于最小值，就替换，如果没有，就将最大利润值设置为当前值-最小值
 */
public class L121 {

    public static void main(String[] args) {
        // int[] prices = {7,1,5,3,6,4};
        int[] prices = {1,2};
        int maxProfit = maxProfit(prices);
        System.out.println(maxProfit);
    }

    private static int maxProfit(int[] prices) {
        int maxProfit = 0;
        int min = Integer.MAX_VALUE;
        for (int price : prices) {
            if (price >= min) {
                maxProfit = Math.max(maxProfit, price - min);
            } else {
                min = price;
            }
        }
        return maxProfit;
    }

}
