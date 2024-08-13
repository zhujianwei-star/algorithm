package org.example.leetcode.l387;

/**
 * @description: 第L387题-字符串中的第一个唯一字符
 * @question: <a href="https://leetcode-cn.com/problems/first-unique-character-in-a-string">...</a>
 * @answer: 给定一个字符串，找到它的第一个不重复的字符，并返回它的索引。如果不存在，则返回 -1。
 */
public class L387 {

    public static void main(String[] args) {
        String s = "leetcode";
        int result = firstUniqChar(s);
        System.out.println(result);
    }

    private static int firstUniqChar(String s) {
        int[] intArray = new int[26];
        for (int i = 0; i < s.length(); i++) {
            intArray[s.charAt(i) - 'a']++;
        }
        for (int i = 0; i < s.length(); i++) {
            if (intArray[s.charAt(i) - 'a'] == 1) {
                return i;
            }
        }
        return -1;
    }


}
