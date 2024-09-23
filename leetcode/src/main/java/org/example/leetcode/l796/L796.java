package org.example.leetcode.l796;

/**
 * @description: 第L796题-旋转字符串
 * @question: <a href="https://leetcode-cn.com/problems/rotate-string/">...</a>
 * @answer: 如果旋转可以得到，那么表名 goal 必是 s + s 的子串，然后使用贪心判断
 */
public class L796 {

    public static void main(String[] args) {
        String s = "abcde";
        String goal = "cdeae";
        System.out.println(isRotateString(s, goal));
    }

    private static boolean isRotateString(String s, String goal) {
        if (s.length() != goal.length()) {
            return false;
        }
        String string = s + s;
        // 使用kmp算法匹配

        // 获取kmp数组
        int[] kmpArr = new int[goal.length()];
        kmpArr[0] = 0;
        for (int i = 1, j = 0; i < goal.length(); i++) {
            while (j > 0 && goal.charAt(i) != goal.charAt(j)) {
                j--;
            }
            if (goal.charAt(i) == goal.charAt(j)) {
                j++;
            }
            kmpArr[i] = j;
        }

        // 使用kmp算法
        for (int i = 0, j = 0; i < string.length(); i++) {
            while (j > 0 && string.charAt(i) != goal.charAt(j)) {
                j = kmpArr[j - 1];
            }
            if (string.charAt(i) == goal.charAt(j)) {
                j++;
            }
            if (j == goal.length()) {
                return true;
            }
        }

        return false;
    }

}
