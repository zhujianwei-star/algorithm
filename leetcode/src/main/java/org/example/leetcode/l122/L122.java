package org.example.leetcode.l122;

/**
 * @description: 第L122题 - 买卖股票的最佳时机 II
 * @question: <a href="https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-ii/">...</a>
 * @answer: 使用一个变量存储上一次的价格，一个变量存储买入时的价格，
 *  一个存储最大利润，遍历数组，
 *  如果现在的价格低于上一次的价格，那么就算出上一次买入的价格-购入价格作为一次利润，并把当前价格作为购入时的价格
 *  如果高于价格，则不做修改，然后到数组的最后一位时，需要使用当前价格-购入价格，得到最高利润
 */
public class L122 {

    public static void main(String[] args) {
        // int[] prices = {7,1,5,3,6,4};
        int[] prices = {1,2,3,4,5};
        int result = maxProfit(prices);
        System.out.println(result);
    }

    public static int maxProfit(int[] prices) {
        int maxProfit = 0;
        int inPrice = prices[0];
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] <= prices[i - 1]) {
                if (prices[i - 1] > inPrice) {
                    maxProfit += prices[i - 1] - inPrice;
                }
                inPrice = prices[i];
            }
            if (i == prices.length - 1) {
                if (prices[i] > inPrice) {
                    maxProfit += prices[i] - inPrice;
                }
            }
        }
        return maxProfit;
    }

}
