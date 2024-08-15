package org.example.leetcode.l392;

import java.util.Objects;

/**
 * @description: 第L392题 - 判断子序列
 * @question: <a href="https://leetcode-cn.com/problems/is-subsequence">...</a>
 * @answer:
 */
public class L392 {

    public static void main(String[] args) {
        String s = "abc";
        String t = "ahbgdc";
        System.out.println(isSubsequence(s, t));
    }

    private static boolean isSubsequence(String s, String t) {
        if (s.isEmpty()) {
            return true;
        }
        if (t.isEmpty()) {
            return false;
        }
        int sLen = 0;
        for (int i = 0; i < t.length(); i++) {
            if (Objects.equals(t.charAt(i), s.charAt(sLen))) {
                sLen++;
            }
            if (sLen == s.length()) {
                return true;
            }
        }
        return false;
    }

}
