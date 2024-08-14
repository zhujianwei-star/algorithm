package org.example.leetcode.l409;

/**
 * @description: 第L409题--最长回文串
 * @question: <a href="https://leetcode-cn.com/problems/longest-palindrome/">...</a>
 * @answer: 先哈希统计，回文和=偶数和+奇数减1后之和+1
 * @TODO: 未解决
 */
public class L409 {

    public static void main(String[] args) {
        String s = "babad";
        System.out.println(longestPalindrome(s));
    }

    private static int longestPalindrome(String s) {
        int[] count = new int[128];
        int length = s.length();
        for (int i = 0; i < length; ++i) {
            char c = s.charAt(i);
            count[c]++;
        }

        int ans = 0;
        for (int v: count) {
            ans += v / 2 * 2;
            if (v % 2 == 1 && ans % 2 == 0) {
                ans++;
            }
        }
        return ans;
    }
}
