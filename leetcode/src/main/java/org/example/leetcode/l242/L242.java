package org.example.leetcode.l242;

/**
 * @description: 第L242题-有效的字母异位词
 * @question: <a href="https://leetcode-cn.com/problems/valid-anagram/">...</a>
 * @answer: 多种方法，比较简单，1.排序后比较；2.使用26字母的数组进行计算，此处使用该方法
 */
public class L242 {

    public static void main(String[] args) {
        String s = "anagram";
        String t = "nagaram";
        System.out.println(isAnagram(s, t));
    }

    public static boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        int[] count = new int[26];
        for (int i = 0; i < s.length(); i++) {
            count[s.charAt(i) - 'a']++;
            count[t.charAt(i) - 'a']--;
        }
        for (int i = 0; i < count.length; i++) {
            if (count[i] != 0) {
                return false;
            }
        }
        return true;
    }
}
