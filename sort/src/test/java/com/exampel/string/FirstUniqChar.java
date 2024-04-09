package com.exampel.string;

import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName : FirstUniqChar
 * @Description: 求一个字符串中的第一个不重复的字符，并返回它的索引 。如果不存在，则返回 -1 。
 * @Author : Zhujw
 * @CreateDate : 2022/2/18 16:18
 */
public class FirstUniqChar {

    public static void main(String[] args) {
        String s = "leetcode";
//        System.out.println(solution(s));
        System.out.println(officialSolution1(s));
        System.out.println(officialSolution2(s));
        System.out.println(officialSolution3(s));
    }

    /**
     * 自己的解法，问题，无法从map中获取到字符数组的顺序
     * @param s
     * @return
     */
    private static int solution(String s) {
        Map<Character, Integer> map = new HashMap<>();
        Character c = null;
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            map.put(chars[i], map.getOrDefault(chars[i], 0) + 1);
        }
        System.out.println(map);
        for (Map.Entry<Character, Integer> characterIntegerEntry : map.entrySet()) {
            if (characterIntegerEntry.getValue() == 1) {
                c = characterIntegerEntry.getKey();
                break;
            }
        }
        if (c == null) {
            return -1;
        }
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == c) return i;
        }
        return -1;
    }

    /**
     * 官方题解，两次循环，用数组存储
     * @param s
     * @return
     */
    private static int officialSolution1(String s) {
        int[] arr = new int[1024];
        char[] chars = s.toCharArray();
        for (char aChar : chars) {
            arr[aChar - 'a']++;
        }
        for (int i = 0; i < chars.length; i++) {
            if (arr[chars[i] - 'a'] == 1) return i;
        }
        return -1;
    }

    /**
     * 官方题解，两次循环，用HashMap存储
     * @param s
     * @return
     */
    private static int officialSolution2(String s) {
        Map<Character, Integer> map = new HashMap<>();
        char[] chars = s.toCharArray();
        for (char aChar : chars) {
            map.put(aChar, map.getOrDefault(aChar, 0) + 1);
        }
        for (int i = 0; i < chars.length; i++) {
            if (map.get(chars[i]) == 1) return i;
        }
        return -1;
    }

    /**
     * 官方题解，使用indexOf和lastIndexOf方法取判断字符串s中char出现的位置，如果返回的索引相等，说明只出现一次
     * @param s
     * @return
     */
    private static int officialSolution3(String s) {
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (s.indexOf(chars[i]) == s.lastIndexOf(chars[i])) return i;
        }
        return -1;
    }
}
