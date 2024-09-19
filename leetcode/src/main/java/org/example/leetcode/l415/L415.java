package org.example.leetcode.l415;

/**
 * @description: 第L415题-字符串相加
 * @question: <a href="https://leetcode-cn.com/problems/add-strings/">...</a>
 * @answer:
 */
public class L415 {

    public static void main(String[] args) {
        String num1 = "123";
        String num2 = "456";
        String result = addStrings(num1, num2);
        System.out.println(result);
    }

    private static String addStrings(String num1, String num2) {
        int i = num1.length() - 1, j = num2.length() - 1, add = 0;
        StringBuilder stringBuilder = new StringBuilder();
        while (i >= 0 || j >= 0 || add != 0) {
            int x = i >= 0 ? num1.charAt(i) - '0' : 0;
            int y = j >= 0 ? num2.charAt(j) - '0' : 0;
            int ans = x + y + add;
            stringBuilder.append(ans % 10);
            add = ans / 10;
            i--;
            j--;
        }
        stringBuilder.reverse();
        return stringBuilder.toString();
    }

}
