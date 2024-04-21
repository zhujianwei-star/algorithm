package org.example.leetcode.l3;

import java.util.HashMap;
import java.util.Map;

/**
 * @description: 第三题 无重复字符的最长子串
 * @question: <a href="https://leetcode-cn.com/problems/longest-substring-without-repeating-characters/">...</a>
 *  给定一个字符串，请你找出其中不含有重复字符的最长子串的长度。
 * @answer: 这是一道典型的滑动窗口的题目，滑动窗口的固定模板，一般使用map来表示这个窗口，key一般为滑动的数据，此处为字符，value的看具体情况，此处为每个字符出现的次数
 */
public class L3 {

    public static void main(String[] args) {
        String s = " ";
        int result = lengthOfLongestSubstring(s);
        System.out.println(result);
    }

    private static int lengthOfLongestSubstring(String s) {
        // 设置左右滑动窗口
        int left = 0, right = 0;
        // 设置结果，存储滑动窗口间隔的最大值
        int result = 0;
        // 存储滑动窗口
        Map<Character, Integer> map = new HashMap<>();
       while (right < s.length()) {
           char c = s.charAt(right++);
           // 右指针滑动，窗口右移，更新窗口内字符出现次数
           map.put(c, map.getOrDefault(c, 0) + 1);
           // 左指针滑动，窗口左移，窗口内字符出现次数减1，直到窗口内没有重复字符
           while (map.get(c) > 1) {
               char temp = s.charAt(left++);
               map.put(temp, map.getOrDefault(temp, 0) - 1);
           }
           // 窗口右移，更新结果
           result = Math.max(result, right - left);
       }
        return result;
    }

}
