package org.example.leetcode.l151;

/**
 * @description: 第L151题-反转字符串中的单词
 * @question: <a href="https://leetcode-cn.com/problems/reverse-words-in-a-string">...</a>
 * @answer:
 */
public class L151 {

    public static void main(String[] args) {
        String s = "a good   example";
        String result = reverseWords(s);
        System.out.println(result);
    }

    private static String reverseWords(String s) {
        if (s == null || s.trim().isEmpty()) {
            return s;
        }
        String[] split = s.trim().split(" ");
        StringBuilder stringBuilder = new StringBuilder();
        for (int length = split.length - 1; length >= 0; length--) {
            if (length != 0 && !"".equals(split[length])) {
                stringBuilder.append(split[length]).append(" ");
            } else {
                stringBuilder.append(split[length]);
            }
        }
        return stringBuilder.toString();
    }

}
